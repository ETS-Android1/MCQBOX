package myapps.quiz1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import myapps.quiz1.Activity.help.Physics1;
import myapps.quiz1.Adapter.HelpAdapter;
import myapps.quiz1.R;

/**
 * Created by comsol on 03-Feb-18.
 */
public class HelpActivity extends AppCompatActivity {

    HelpAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from gridview_main.xml
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String[] course = {"PHYSICS 1ST PAPER","PHYSICS 2ND PAPER","CHEMISTRY 1ST PAPER","CHEMISTRY 2ND PAPER"
                ,"MATH 1ST PAPER","MATH 2ND PAPER"};

        int[] Imageid = {R.drawable.phy_5, R.drawable.phy_6 , R.drawable.che_4, R.drawable.che_5
                , R.drawable.math_3, R.drawable.math_4};
        GridView gridview = (GridView) findViewById(R.id.gridview);

        adapter = new HelpAdapter(HelpActivity.this, course, Imageid);

        // gridView.setAdapter(CourseAdapter);

        // Set the ImageAdapter into GridView Adapter
        gridview.setAdapter(adapter);

        // Capture GridView item click
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Launch ViewImage.java using intent
                if (position == 0) {
                    Intent i = new Intent(view.getContext(), Physics1.class);
                    startActivityForResult(i, 0);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Physics1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Physics1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Physics1.class);
                    startActivityForResult(myIntent, 0);
                }


                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(),Physics1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), Physics1.class);
                    startActivityForResult(myIntent, 0);
                }

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
