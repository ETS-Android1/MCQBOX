package myapps.quiz1.Activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import myapps.quiz1.R;

/**
 * Created by comsol on 26-Nov-17.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return web.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // Create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        // if it's not recycled, initialize some attributes
        if (convertView == null) {
            imageView = new ImageView(mContext);

            // Center crop image

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        } else {
            imageView = (ImageView) convertView;
        }
        // Set images into ImageView
        imageView.setImageResource(web[position]);

        return imageView;
    }
    public  Integer[] web = { R.drawable.phy1, R.drawable.phy2,
            R.drawable.che4, R.drawable.che1, R.drawable.bio4,
            R.drawable.bio1, R.drawable.math2, R.drawable.math1
    } ;



}

