package project.dnet3.appcit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by shay on 21/03/2015.
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main2);

        Log.i("CIT App", "MainActivity constructor called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_view_cit, menu);

        //View v = inflater.inflate(R.layout.activity_main, container, false);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

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
            case R.id.button1:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string.buttViewCitBlackboard, Toast.LENGTH_SHORT).show();

                intent = new Intent(this, ViewCIT.class);
                startActivity( intent );
                break;

            case R.id.button2:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                intent = new Intent(this, HandbooksActivity.class);
                startActivity( intent );
                break;

            case R.id.button3:
                Log.i("CIT App", "Button timetables has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                intent = new Intent(this, TimeTableActivity.class);
                startActivity( intent );
                break;

            case R.id.button4:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                intent = new Intent(this, SocialMediaActivity.class);
                startActivity( intent );
                break;

            case R.id.button5:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                intent = new Intent(this, VirtualTourActivity.class);
                startActivity( intent );
                break;

            case R.id.button6:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

//                intent = new Intent(this, Find.class);
//                startActivity( intent );
                break;


            default:
        }
    }
}
