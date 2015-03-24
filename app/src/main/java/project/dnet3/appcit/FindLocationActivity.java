package project.dnet3.appcit;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shay on 20/03/2015.
 */
public class FindLocationActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_find_room_location);
          Spinner spinner = (Spinner) findViewById(R.id.spinner);

        Log.i("CIT app", "going to call response to room list");
responseToRoomListTest(  );
      //  ArrayList<String> itemList = TimeTableCategories.getTimeTablesList();
      //  ArrayAdapter<String> timeTableAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, itemList);
      //  spinner.setAdapter(timeTableAdapter);

        ArrayList<String> itemList;



    }

    private void responseToRoomListTest(){
        String sampleResponse = "[{\"room_number\":\"A111\"},{\"room_number\":\"A142L\"},{\"room_number\":\"A177\"},{\"room_number\":\"A199X\"},{\"room_number\":\"A223LC\"},{\"room_number\":\"A251\"},{\"room_number\":\"A277\"},{\"room_number\":\"A290\"},{\"room_number\":\"B131\"},{\"room_number\":\"B147\"},{\"room_number\":\"B162L\"},{\"room_number\":\"B182\"},{\"room_number\":\"B217\"},{\"room_number\":\"B223L\"},{\"room_number\":\"B248X\"},{\"room_number\":\"B262\"},{\"room_number\":\"C127\"},{\"room_number\":\"C154\"},{\"room_number\":\"C212\"},{\"room_number\":\"C268\"},{\"room_number\":\"D143\"},{\"room_number\":\"D238\"}]";
        Type type = new TypeToken<List<RoomShortData>>() {}.getType();
        List<RoomShortData> listOfRooms = new Gson().fromJson(sampleResponse, type);
        for(RoomShortData room : listOfRooms){
            Log.i("responseToObjectTest", "room number : " + room.getRoomNumber());
        }
    }


}