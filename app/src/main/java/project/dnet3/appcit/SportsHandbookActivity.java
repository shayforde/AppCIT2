package project.dnet3.appcit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

/**
 * Created by shay on 19/03/2015.
 */
/*
public class SportsHandbookActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView mWebView=new WebView(MyPdfViewActivity.this);
        mWebView.getSettings().setJavaScriptEnabled(true);
   //     mWebView.getSettings().setPluginsEnabled(true);
        mWebView.loadUrl("https://docs.google.com/gview?embedded=true&url="+"http://www.mycit.ie/index.cfm/page/handbooks/handbookId/4");
        setContentView(mWebView);
    }
}
*/

public class SportsHandbookActivity extends ActionBarActivity implements OnPageChangeListener {

    private PDFView pdfView;
    private int pageNumber = 1;

    public static final String PDF_FILE = "CIT-Sports.pdf";

    private String fileName = PDF_FILE;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpdf);
        pdfView = (PDFView) findViewById(R.id.pdfview);
   //     display("http://www.mycit.ie/index.cfm/page/handbooks/handbookId/4", true);
        display(PDF_FILE, true);
   //     pdfView.load("http://www.mycit.ie/index.cfm/page/handbooks/handbookId/4", true);
    }

    private void display(String assetFileName, boolean jumpToFirstPage) {
        if (jumpToFirstPage) pageNumber = 1;
        setTitle(fileName = assetFileName);
/*
        pdfView.fromAsset(assetFileName)
                .defaultPage(1)
                .onPageChange(this)
                .load();
                */
    }
/*
    private void load(Uri uri, OnLoadCompleteListener onLoadCompleteListener, int... userPages) {
        this.uri = uri;

        if (!recycled) {
            throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
        }

        // Manage UserPages if not null
        if (userPages != null) {
            this.originalUserPages = userPages;
            this.filteredUserPages = ArrayUtils.deleteDuplicatedPages(originalUserPages);
            this.filteredUserPageIndexes = ArrayUtils.calculateIndexesInDuplicateArray(originalUserPages);
        }

        this.onLoadCompleteListener = onLoadCompleteListener;

        // Start decoding document
        decodingAsyncTask = new DecodingAsyncTask(uri, this);
        decodingAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        renderingAsyncTask = new RenderingAsyncTask(this);
        renderingAsyncTask.execute();
    }
*/

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
//        setTitle(format("%s %s / %s", pdfName, page, pageCount));
    }

    public static void Open(Context context){
        Intent intent = new Intent(context, StudentHandbookActivity.class);
        context.startActivity(intent);
    }

}
