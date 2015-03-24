package project.dnet3.appcit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import nl.matshofman.saxrssreader.RssItem;

/**
 * Created by shay on 24/03/2015.
 */
public class RssAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<RssItem> rssItems;

    public RssAdapter(Context context, ArrayList<RssItem> rssItems){
        this.context = context;
        this.rssItems = rssItems;
    }

    @Override
    public int getCount() {
        return rssItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rssItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RssItem rssItem = (RssItem) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.itm_rss, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.itm_rss_text.setText(rssItem.getTitle());
        return convertView;
    }

    private static class ViewHolder {

        public TextView itm_rss_text;

        public ViewHolder(View convertView){
            itm_rss_text = (TextView) convertView.findViewById(R.id.itm_rss_text);
        }
    }
}
