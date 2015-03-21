package project.dnet3.appcit;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by shay on 20/03/2015.
 */

public class FacebookActivity extends ActionBarActivity {

    private WebView act_facebook_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_facebook_layout);
        act_facebook_webview = (WebView) findViewById(R.id.act_facebook_webview);
        WebSettings webSettings = act_facebook_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        act_facebook_webview.setWebViewClient(new WebViewClient());
        act_facebook_webview.loadUrl("https://www.facebook.com/myCIT");
    }
/*
    public static void Open(Context context){
        Intent intent = new Intent(context, FacebookActivity.class);
        context.startActivity(intent);
    }
    */
}
