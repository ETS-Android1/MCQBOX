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
 * Created by comsol on 28-Feb-18.
 */
public class Main1Adapter extends BaseAdapter {
    private Context mContext;
    TextView textView, textView1 , textView2;
    private final String[] course1;
    private final int[] Imageid1;

    public Main1Adapter(Context c, String[] course1,int[] Imageid1) {
        mContext = c;
        this.course1 = course1;
        this.Imageid1 = Imageid1;

    }



    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Imageid1.length;

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
          /* if(position==0) {
              // grid = new View(mContext);
               grid = inflater.inflate(R.layout.model_grid, null);
               TextView textView = (TextView) grid.findViewById(R.id.grid_text);
               ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
               textView.setText(course[position]);
               imageView.setImageResource(Imageid[position]);
           }*/

            grid = inflater.inflate(R.layout.second_grid, null);
            textView = (TextView) grid.findViewById(R.id.grid_text);
            textView.setText(course1[position]);
          //  textView1 = (TextView) grid.findViewById(R.id.grid_text1);
           // textView2 = (TextView) grid.findViewById(R.id.grid_text2);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            imageView.setImageResource(Imageid1[position]);
           // ImageView imageView1 = (ImageView) grid.findViewById(R.id.grid_image1);
           // imageView1.setImageResource(Imageid2[position]);





        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
