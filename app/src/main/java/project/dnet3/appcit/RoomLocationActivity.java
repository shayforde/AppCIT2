package project.dnet3.appcit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shay on 23/03/2015.
 */
public class RoomLocationActivity extends ActionBarActivity implements View.OnClickListener {


//    Button button1;
//    Button button2;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_find_room_location);

        spinner = (Spinner) findViewById(R.id.spinner);
        Log.i("CIT App", "Room Location constructor called");

        addListenerOnSpinnerItemSelection();
        responseToRoomListTest();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_view_cit, menu);

        //View v = inflater.inflate(R.layout.activity_main, container, false);

//        button1 = (Button) findViewById(R.id.butt_handbooks);
//        button1.setOnClickListener(this);

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



    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked
        Intent intent;
        switch (v.getId()) {
            case R.id.butt_locate_room:
                Log.i("CIT App", "butt locate room has been pressed");
                //Toast.makeText(this, R.string.buttViewCitBlackboard, Toast.LENGTH_SHORT).show();

                intent = new Intent(this, LinkHandbooks.class);
                startActivity( intent );
                break;

            default:
        }

    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    private void responseToRoomListTest(){
        String sampleResponse = "[{\"room_number\":\"A111\"},{\"room_number\":\"A142L\"},{\"room_number\":\"A177\"},{\"room_number\":\"A199X\"},{\"room_number\":\"A223LC\"},{\"room_number\":\"A251\"},{\"room_number\":\"A277\"},{\"room_number\":\"A290\"},{\"room_number\":\"B131\"},{\"room_number\":\"B147\"},{\"room_number\":\"B162L\"},{\"room_number\":\"B182\"},{\"room_number\":\"B217\"},{\"room_number\":\"B223L\"},{\"room_number\":\"B248X\"},{\"room_number\":\"B262\"},{\"room_number\":\"C127\"},{\"room_number\":\"C154\"},{\"room_number\":\"C212\"},{\"room_number\":\"C268\"},{\"room_number\":\"D143\"},{\"room_number\":\"D238\"}]";
        Type type = new TypeToken<List<RoomShortData>>() {}.getType();
        List<RoomShortData> listOfRooms = new Gson().fromJson(sampleResponse, type);
        List<String>rooms = new ArrayList<String>();
        for(RoomShortData room : listOfRooms){
            Log.e("responseToObjectTest", "room number : " + room.getRoomNumber());
            rooms.add(room.getRoomNumber());

        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, rooms);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

}

class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
