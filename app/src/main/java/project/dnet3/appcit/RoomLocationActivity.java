package project.dnet3.appcit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.apache.http.Header;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shay on 23/03/2015.
 */
public class RoomLocationActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener /*implements View.OnClickListener */ {

    Spinner spinner;
    ImageView img1;
    ImageView img2;

    List<String> rooms = new ArrayList<String>();

    String room_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_find_room_location);


        spinner = (Spinner) findViewById(R.id.spinner);
        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);

        rooms.add(0, "Select Room Number");

        //main_map.loadUrl("http://192.168.1.102/joomla/images/GroundFloor/FloorG1.PNG");
       // main_map.loadUrl("http://192.168.1.102/joomla/index.php/first-floor-plans/74-g0");

        Log.i("CIT App", "Room Location constructor called");

        addListenerOnSpinnerItemSelection();
     //   responseToRoomListTest();
        makeRoomListApiCall("http://192.168.1.102/joomla/get_rooms.php");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rooms);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
    }


    private RoomFullData responseToRoom(byte[] response){
        String jsonString = new String(response);
        RoomFullData roomFullData = new Gson().fromJson(jsonString, RoomFullData.class);
        return roomFullData;
    }

    private List<RoomShortData> responseToListOfRooms(byte[] responseBytes){
        Log.e("repsonseToListOfRooms", new String(responseBytes));
        Type type = new TypeToken<List<RoomShortData>>(){}.getType();
        String jsonString = new String(responseBytes);
        List<RoomShortData> listOfRooms = new Gson().fromJson(jsonString, type);
        return listOfRooms;
    }

    private void makeRoomListApiCall(final String url){
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                final List<RoomShortData> roomsList = responseToListOfRooms(responseBody);

                for(RoomShortData room : roomsList){
                    Log.e("responseRoomListDB", "room number : " + room.getRoomNumber());
                    rooms.add(room.getRoomNumber());
                }

            }

            @Override
            public void onFailure(final int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // show error message to user
                showApiErrorMessage(url, statusCode);
            }
        });
    }

    private void makeRoomApiCall(final String url){
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, /*requestParams,*/ new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                final RoomFullData room = responseToRoom(responseBody);
                displayRoomData( room );


                Log.e("responseRoomDB", room.toString());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(room == null){
                            // error loading room or there is some problem
                            // do something
                        }
                        else {
                            // use room object in ui / dropdown
                        }
                    }
                });
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                showApiErrorMessage(url, statusCode);
            }
        });
    }

    private void showApiErrorMessage(final String url, final int statusCode){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RoomLocationActivity.this, "Error " + statusCode + " loading data from " + url, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class RoomShortData implements Serializable {

        private static final long	serialVersionUID	= -7216710072788834035L;

        public String room_number;

        public String getRoomNumber(){
            return room_number;
        }
    }

    public class RoomFullData implements Serializable {

        private static final long	serialVersionUID	= -7216110072788834032L;

        public String room_number;
        public String floor_level;
        public String map_section;
        public String map_page_link;
        @SerializedName("room_co-ordinates")
        public String room_co_ordinates;

        public String getRoomNumber(){
            return room_number;
        }

        public String getFloorLevel(){
            return floor_level;
        }

        public String getMapSection(){
            return map_section;
        }

        public String getMapPageLink(){
            return map_page_link;
        }

        public String getRoomCoordinates(){
            return room_co_ordinates;
        }

        @Override
        public String toString(){
            return "Room : " + getRoomNumber() + ", Floor Level : " + getFloorLevel() +
                    ", Map Section : " + getMapSection() + ", Map Page Link : " + getMapPageLink()
                    + ", Room Co-Ordinates : " + getRoomCoordinates();
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        room_number = parent.getItemAtPosition(pos).toString();


         String url = "http://192.168.1.102/joomla/get_room_location.php/?room_number=" + room_number;

Log.i("MYCIT", url);

    if( !room_number.equals("Select Room Number" ))

    {
        makeRoomApiCall(url);
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    void displayRoomData( RoomFullData room ){
        String url1;
        String url2;
        if(room.getFloorLevel().equals("G")){
            url1 = "http://192.168.1.102/joomla/images/GroundFloor/FloorG0.PNG";
            url2 = "http://192.168.1.102/joomla/images/GroundFloor/Floor" + room.getMapSection() + ".PNG";
        }
        else{
            url1 = "http://192.168.1.102/joomla/images/FirstFloor/Floor10.png";
            url2 = "http://192.168.1.102/joomla/images/FirstFloor/Floor" + room.getMapSection() + ".PNG";
        }
        Picasso.with( this ).load(url1).into( img1 );
        Picasso.with( this ).load( url2 ).into( img2 );

        Paint paint = new Paint();
        paint.setColor(0xB51845);
        paint.setStrokeWidth(1);

        try {
            Bitmap bm = Bitmap.createBitmap(10, 15, Bitmap.Config.ALPHA_8);

            Canvas cv = new Canvas(bm);

            cv.drawBitmap(bm, 0, 0, null);
            Log.i("MYCIT", "coordinates = " + room.getRoomCoordinates());
            int x = 0;
            int y = 0;
            Pattern pattern = Pattern.compile(",*");
            Matcher matcher = pattern.matcher(room.getRoomCoordinates());
            if (matcher.find()) {
                String sx = room.getRoomCoordinates().substring(0, matcher.start());
                String sy = room.getRoomCoordinates().substring(matcher.end());
                x = Integer.parseInt(sx);
                y = Integer.parseInt(sy);
            }
            cv.drawCircle(x, y, 10, paint);

            img2.setImageDrawable(new BitmapDrawable(getResources(), bm));
        }
        catch(Exception e){}


/*
        try {
            URL thumb_u = new URL( url );
            Drawable thumb_d = Drawable.createFromStream(thumb_u.openStream(), "src");
            img.setImageDrawable(thumb_d);
        }
        catch (Exception e) {
            Log.e("MyCIT", "Error loading image");
        }
      // img.setImageURI(Uri.parse( url ));
*/

/*
        try {
            URL pic = new URL(url);
            Bitmap bm =  getRemoteImage( pic );
            img.setImageBitmap( bm );
        }
        catch(Exception e){}

*/
       Log.i("MyCIT", url2);
    }

    public Bitmap getRemoteImage(final URL aURL) {
        try {
            final URLConnection conn = aURL.openConnection();
            conn.connect();
            final BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            final Bitmap bm = BitmapFactory.decodeStream(bis);
            bis.close();
            return bm;
        } catch (IOException e) {}
        return null;
    }
}

