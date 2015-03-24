package project.dnet3.appcit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by shay on 22/03/2015.
 */
public class TableTableDisplayActivity extends ActionBarActivity {

    private static final String TAG = "TimeTableDisplay";

//    private static final String FIRST_URL_HALF = "http://timetables.cit.ie:70/reporting/Individual;Programme+Of+Study;name;";
//    private static final String SECOND_URL_HALF = "?weeks=&days=1-5&periods=1-40&height=75&width=75";

    // http://timetables.cit.ie:70/reporting/Individual;Student+Set;name;CO.DNET3%0D%0A?weeks=&days=1-5&periods=1-40&height=100&width=100
    private static final String FIRST_URL_HALF = "http://timetables.cit.ie:70/reporting/Individual;Programme+Of+Study;";
    private static final String SECOND_URL_HALF = "?weeks=&days=1-5&periods=1-40&height=75&width=75";

    private WebView act_timetable_webview;

    private Spinner spinner;
    private String department;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_timetable);
        act_timetable_webview = (WebView) findViewById(R.id.act_timetable_webview);
        WebSettings webSettings = act_timetable_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setBuiltInZoomControls(true);
        act_timetable_webview.setWebViewClient(new WebViewClient());

        spinner = (Spinner) findViewById(R.id.spinner2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View arg1, int position, long arg3) {
                department = (String) adapter.getAdapter().getItem(position);
                if(!department.equals("Select")){
                    department = department.replace(" ", "+");
                    Log.d(TAG, "url : " + FIRST_URL_HALF + department + SECOND_URL_HALF);
            //        act_timetable_webview.loadUrl(FIRST_URL_HALF + name + SECOND_URL_HALF);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timetable, menu);
        MenuItem menu_timetable_dropdown = menu.findItem(R.id.menu_timetable_dropdown);
        View view1 = menu_timetable_dropdown.getActionView();
        if (view1 instanceof Spinner){
            Spinner spinner = (Spinner) view1;
            ArrayList<String> itemList = TimeTableCategories.getTimeTablesList();
            ArrayAdapter<String> timeTableAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, itemList);
            spinner.setAdapter(timeTableAdapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> adapter, View arg1, int position, long arg3) {
                    String name = (String) adapter.getAdapter().getItem(position);
                    if(!name.equals("Select")){
                        name = name.replace(" ", "+");
                        Log.d(TAG, "url : " + FIRST_URL_HALF + name + SECOND_URL_HALF);
                        act_timetable_webview.loadUrl(FIRST_URL_HALF + name + SECOND_URL_HALF);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
            spinner.setSelection(0);
        }
        return true;
    }


    public static void Open(Context context){
        Intent intent = new Intent(context, TableTableDisplayActivity.class);
        context.startActivity(intent);
    }

}