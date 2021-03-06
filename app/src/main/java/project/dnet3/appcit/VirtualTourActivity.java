package project.dnet3.appcit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by shay on 20/03/2015.
 */
public class VirtualTourActivity extends ActionBarActivity {

    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        // final Activity activity = this;
        connectWebView();

        // mWebview.loadUrl("https://dl.dropboxusercontent.com/u/79441161/startup/DBstartpage.html");
        //mWebview.loadUrl("http://www.mycit.ie/");

        //   mWebview.loadUrl("http://192.168.1.102/joomla/index.php/location");
        //   mWebview.loadUrl("http://mapsengine.google.com/map/embed?mid=zQH00h_hX520.k4SoJnz7xdy8");

        //mWebview.loadUrl("http://static.dermandar.com/php/getimage.php?epid=bcXRZv&equi=1&h=512&r=1");
       // mWebview.loadUrl("file:///android_asset/virtual_tour.html");

      //  mWebview.loadUrl("http://192.168.1.102/joomla/index.php/virtual-tour");

        mWebview.loadUrl(  getString(R.string.server_ip) + "/joomla/index.php/virtual-tour");
        Log.i("CIT App", getString(R.string.server_ip) + "/joomla/index.php/virtual-tour");

        setContentView(mWebview);

/*
        // Get the message from the intent
        Intent intent = getIntent();
       // String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText("hello world again");

        // Set the text view as the activity layout
        setContentView(textView);
*/



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
