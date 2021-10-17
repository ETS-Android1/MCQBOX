package myapps.quiz1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import myapps.quiz1.R;

/**
 * Created by comsol on 03-Feb-18.
 */
public class HelpAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] course;
    private final int[] Imageid;

    public HelpAdapter(Context c,String[] course,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.course = course;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return course.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.model_grid1, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(course[position]);
            imageView.setImageResource(Imageid[position]);

        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
