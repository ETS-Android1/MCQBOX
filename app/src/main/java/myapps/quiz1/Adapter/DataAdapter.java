package myapps.quiz1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.quiz1.Model.ChapterData;
import myapps.quiz1.R;

/**
 * Created by comsol on 24-Jan-18.
 */
public class DataAdapter  extends BaseAdapter {

    private final Context context;
    private final ArrayList<ChapterData> itemsArrayList;

    public DataAdapter(Context context, ArrayList<ChapterData> itemsArrayList) {

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }


    @Override
    public int getCount() {
        return itemsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.textlist, parent, false);

        // 3. Get the two text view from the rowView
        TextView labelView = (TextView) rowView.findViewById(R.id.label);
        TextView valueView = (TextView) rowView.findViewById(R.id.value);

        // 4. Set the text for textView
        labelView.setText(itemsArrayList.get(position).getChapter());
        valueView.setText(itemsArrayList.get(position).getChapter_name());

        // 5. retrn rowView
        return rowView;
    }
}