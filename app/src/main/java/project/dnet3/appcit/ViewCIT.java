package project.dnet3.appcit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

// 192.168.1.102/joomla/index.php/view-mycit

/**
 * Created by shay on 19/03/2015.
 */
public class ViewCIT extends ActionBarActivity  {

    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        // final Activity activity = this;
        connectWebView();


        WebSettings webSettings = mWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setBuiltInZoomControls(true);
        mWebview.setWebViewClient(new WebViewClient());
        webSettings.setBuiltInZoomControls(true);
       // mWebview.loadUrl("http://" + getString(R.string.server_ip) + "/joomla/index.php/mycit-portal");
        mWebview.loadUrl("http://192.168.1.102/joomla/index.php/mycit-portal");
        Log.i("myCIT","http://192.168.1.102/joomla/index.php/mycit-portal" );
        setContentView(mWebview );




        Log.i("CIT App", "ViewCIT constructor called");
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
