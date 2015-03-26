package project.dnet3.appcit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


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
    Button button7;
    Button button8;

    private ListView act_rss_list;
//    private RssAdapter rssAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main2);

   /*     act_rss_list = (ListView) findViewById(R.id.act_rss_list);
        setTitle("MyCit RSS");
        new RetrieveFeedTask().execute("");
*/
        Log.i("CIT App", "MainActivity constructor called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_view_cit, menu);

        //View v = inflater.inflate(R.layout.activity_main, container, false);

        button1 = (Button) findViewById(R.id.butt_view_cit);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.butt_stu_union_and_serve);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.butt_timetables);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.butt_social_media);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.butt_find_location);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.butt_virtual_tour);
        button6.setOnClickListener(this);

        button7 = (Button) findViewById(R.id.butt_rss_feed);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.butt_about);
        button8.setOnClickListener(this);

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
            case R.id.butt_view_cit:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string.buttViewCitBlackboard, Toast.LENGTH_SHORT).show();

                intent = new Intent(this, ViewCIT.class);
            //    intent = new Intent(this, RoomLocationActivity.class);
                startActivity( intent );
                break;

            case R.id.butt_stu_union_and_serve:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                intent = new Intent(this, SUandStudentActivity.class);
                startActivity( intent );
                break;

            case R.id.butt_timetables:
                Log.i("CIT App", "Button timetables has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                intent = new Intent(this, TableTableDisplayActivity.class);
                startActivity( intent );
                break;

            case R.id.butt_social_media:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                intent = new Intent(this, SocialMediaActivity.class);
                startActivity( intent );
                break;

            case R.id.butt_find_location:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                intent = new Intent(this, MainFindLocationActivity.class);
                startActivity( intent );
                break;

            case R.id.butt_virtual_tour:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();
                intent = new Intent(this, VirtualTourActivity.class);
                startActivity( intent );
                break;

            case R.id.butt_rss_feed:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();
                intent = new Intent(this, RssActivity.class);
                startActivity( intent );
                break;

            case R.id.butt_about:
                Log.i("CIT App", "Button Blackboard has been pressed");
                //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();
                intent = new Intent(this, AboutActivity.class);
                startActivity( intent );
                break;
            default:
        }
    }
}
