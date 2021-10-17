package myapps.quiz1.Activity.modeltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import myapps.quiz1.Adapter.ModelAdapter;
import myapps.quiz1.R;

/**
 * Created by comsol on 29-Jan-18.
 */
public class ModeltestActivity extends AppCompatActivity {
    ModelAdapter adapter;
    TextView textView,textView1,textView2,textView3,textView4,textView5,textView6;
    ImageView imageView,imageView1,imageView2,imageView3,imageView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modeltest);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         textView = (TextView) findViewById(R.id.grid_text);
         textView1 = (TextView) findViewById(R.id.grid_text1);
         textView2 = (TextView) findViewById(R.id.grid_text2);
         textView3 = (TextView) findViewById(R.id.grid_text3);
        // textView4 = (TextView) findViewById(R.id.grid_text4);
         imageView = (ImageView) findViewById(R.id.grid_image);
         imageView1 = (ImageView) findViewById(R.id.grid_image1);
         imageView2 = (ImageView) findViewById(R.id.grid_image2);

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ModeltestActivity.this, ChapterTestActivity.class);
                startActivity(myIntent);
               }
            });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ModeltestActivity.this, SubjectActivity.class);
                startActivity(myIntent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_grid_view, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



