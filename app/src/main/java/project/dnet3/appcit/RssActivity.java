package project.dnet3.appcit;

import nl.matshofman.saxrssreader.RssFeed;

        import android.content.Context;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;


        import org.xml.sax.SAXException;

        import java.io.IOException;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.ArrayList;

        import nl.matshofman.saxrssreader.RssItem;
        import nl.matshofman.saxrssreader.RssReader;

public class RssActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private static final String RSS_URL = "http://www.cit.ie/rss/news/index.cfm";

    private ListView act_rss_list;
    private RssAdapter rssAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_rss);
        act_rss_list = (ListView) findViewById(R.id.act_rss_list);
        setTitle("CIT Newsfeed RSS");
        new RetrieveFeedTask().execute("");
    }

    public static void Open(Context context){
        Intent intent = new Intent(context, RssActivity.class);
        context.startActivity(intent);
    }

    public static void launchBrowerForUrl(Context context, String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RssItem rssItem = (RssItem) parent.getAdapter().getItem(position);
        launchBrowerForUrl(this, rssItem.getLink());
    }

    class RetrieveFeedTask extends AsyncTask<String, Void, ArrayList<RssItem>> {

        protected ArrayList<RssItem> doInBackground(String... urls) {
            URL url = null;
            try {
                url = new URL(RSS_URL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            RssFeed feed = null;
            try {
                feed = RssReader.read(url);
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }

            ArrayList<RssItem> rssItems = null;
            if (feed != null) {
                rssItems = feed.getRssItems();
            }
            if (rssItems != null) {
                for(RssItem rssItem : rssItems) {
                    Log.i("RSS Reader", rssItem.getTitle());
                }
            }
            return rssItems;
        }

        protected void onPostExecute(final ArrayList<RssItem> rssItems) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    rssAdapter = new RssAdapter(RssActivity.this, rssItems);
                    act_rss_list.setAdapter(rssAdapter);
                    act_rss_list.setOnItemClickListener(RssActivity.this);
                }
            });
        }
    }
}
