package myapps.quiz1.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.quiz1.Model.AllData;
import myapps.quiz1.R;

/**
 * Created by comsol on 28-May-18.
 */
public class Course_listAdapter  extends BaseAdapter {
    private Context mContext;
    private ArrayList<AllData> allDatas;
    private ArrayList<AllData> mFilteredList;
    private ProgressDialog pDialog;


    public Course_listAdapter(Context mCtx, ArrayList<AllData> allDatas){
        this.mContext = mCtx;
        this.allDatas = allDatas;
        this.mFilteredList = allDatas;


    }

    @Override
    public int getCount() {
        return 0;
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
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.course_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);

        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}

