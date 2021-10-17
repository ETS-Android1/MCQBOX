package myapps.quiz1.Activity.modeltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import myapps.quiz1.Adapter.ModelATestAdapter;
import myapps.quiz1.Model.ModelList;
import myapps.quiz1.R;

/**
 * Created by comsol on 01-Mar-18.
 */
public class Physics1Test extends AppCompatActivity {
    //   ModelAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physics1_test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ModelATestAdapter adapter = new ModelATestAdapter(this, generateData());
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Launch ViewImage.java using intent
                if (position == 0) {
                    Intent i = new Intent(view.getContext(), Test1Activity.class);
                    startActivityForResult(i, 0);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Test1Activity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Test1Activity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Test1Activity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), Test1Activity.class);
                    startActivityForResult(myIntent, 0);
                }



            }
        });
    }

    private ArrayList<ModelList> generateData() {
        ArrayList<ModelList> items = new ArrayList<ModelList>();
        items.add(new ModelList("  Model Test 1"));
        items.add(new ModelList(" Model Test 2"));
        items.add(new ModelList("  Model Test 3"));
        items.add(new ModelList("  Model Test 4"));
        items.add(new ModelList("  Model Test 5"));



        return items;


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

