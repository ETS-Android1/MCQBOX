package myapps.quiz1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import myapps.quiz1.R;

/**
 * Created by comsol on 26-Nov-17.
 */
public class SingleItemView extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

        // Get position from intent passed from MainActivity.java
        Intent i = getIntent();

        int position = i.getExtras().getInt("id");

        // Open the Image adapter
        ImageAdapter imageAdapter = new ImageAdapter(this);

        // Locate the ImageView in singleitemview.xml
        ImageView imageView = (ImageView) findViewById(R.id.image);
      //  ImageView imageView1 = (ImageView) findViewById(R.id.image);

        // Get image and position from ImageAdapter.java and set into ImageView
        imageView.setImageResource(imageAdapter.web[position]);

    }
}
