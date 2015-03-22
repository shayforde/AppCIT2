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
 * Created by shay on 19/03/2015.
 */
public class HandbooksActivity extends ActionBarActivity implements View.OnClickListener {


    Button button1;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handbook);


        Log.i("CIT App", "ViewCIT constructor called");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_view_cit, menu);

        //View v = inflater.inflate(R.layout.activity_main, container, false);

        button1 = (Button) findViewById(R.id.handbook_student);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.handbook_union);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.web4student);
        button3.setOnClickListener(this);


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
            case R.id.handbook_student:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string.buttViewCitBlackboard, Toast.LENGTH_SHORT).show();

                intent = new Intent(this, StudentHandbookActivity.class);
                startActivity( intent );
                break;

            case R.id.handbook_union:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                intent = new Intent(this, SportsHandbookActivity.class );
                startActivity( intent );
                break;

            case R.id.web4student:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                intent = new Intent(this, Web4Student.class);
                startActivity( intent );
                break;


            default:
        }
    }
}
