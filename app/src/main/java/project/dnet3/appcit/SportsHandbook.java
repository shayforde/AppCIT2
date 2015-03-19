package project.dnet3.appcit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

/**
 * Created by shay on 19/03/2015.
 */
public class SportsHandbook extends ActionBarActivity implements OnPageChangeListener {

    private PDFView pdfView;
    private int pageNumber = 1;

    public static final String PDF_FILE = "CIT-Sports.pdf";

    private String fileName = PDF_FILE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_handbook);
        pdfView = (PDFView) findViewById(R.id.pdfview);
        display(PDF_FILE, true);

    }

    private void display(String assetFileName, boolean jumpToFirstPage) {
        if (jumpToFirstPage) pageNumber = 1;
        setTitle(fileName = assetFileName);

        pdfView.fromAsset(assetFileName)
                .defaultPage(1)
                .onPageChange(this)
                .load();
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
//        setTitle(format("%s %s / %s", pdfName, page, pageCount));
    }

    public static void Open(Context context){
        Intent intent = new Intent(context, HandbookActivity.class);
        context.startActivity(intent);
    }

}
