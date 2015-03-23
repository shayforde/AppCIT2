package project.dnet3.appcit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by shay on 20/03/2015.
 */
public class FindLocationActivity extends ActionBarActivity implements View.OnClickListener {
        Button button1;
        Button button2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_location);

            Log.i("CIT App", "ViewCIT constructor called");
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            //getMenuInflater().inflate(R.menu.menu_view_cit, menu);

            //View v = inflater.inflate(R.layout.activity_main, container, false);

            button1 = (Button) findViewById(R.id.butt_cit_location);
            button1.setOnClickListener(this);

            button2 = (Button) findViewById(R.id.butt_floor_plans);
            button2.setOnClickListener(this);

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
                case R.id.butt_cit_location:
                    Log.i("CIT App", "Button cit_location has been pressed");
                    //Toast.makeText(this, R.string.buttViewCitBlackboard, Toast.LENGTH_SHORT).show();

                    intent = new Intent(this, CITLocationActivity.class);
                    startActivity( intent );
                    break;

                case R.id.butt_floor_plans:
                    Log.i("CIT App", "Button floor_plans has been pressed");
                    //Toast.makeText(this, R.string., Toast.LENGTH_SHORT).show();

                    intent = new Intent(this, FloorPlansActivity.class);
                    startActivity( intent );
                    break;

                default:
            }
        }


}



 /*
    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        connectWebView();

        mWebview.loadUrl("http://192.168.1.102/joomla/index.php/location");
        setContentView(mWebview );

    }

    void connectWebView(){

        mWebview  = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;
        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_cit, menu);
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
}
*/