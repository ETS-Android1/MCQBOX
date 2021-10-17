package myapps.quiz1.Activity.help;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import myapps.quiz1.Activity.technique.Phytechnique;
import myapps.quiz1.Adapter.ModelATestAdapter;
import myapps.quiz1.Model.ModelList;
import myapps.quiz1.R;

/**
 * Created by comsol on 03-Feb-18.
 */
public class Physics1 extends AppCompatActivity {
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
        Intent i = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(i, 0);
        }
        if (position == 1) {
        Intent myIntent = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(myIntent, 0);
        }

        if (position == 2) {
        Intent myIntent = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(myIntent, 0);
        }

        if (position == 3) {
        Intent myIntent = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(myIntent, 0);
        }

        if (position == 4) {
        Intent myIntent = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(myIntent, 0);
        }

        if (position == 5) {
        Intent myIntent = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(myIntent, 0);
        }

        if (position == 6) {
        Intent myIntent = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(myIntent, 0);
        }

        if (position == 7) {
        Intent myIntent = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(myIntent, 0);
        }
        if (position == 8) {
        Intent myIntent = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(myIntent, 0);
        }
        if (position == 9) {
        Intent myIntent = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(myIntent, 0);
        }
        if (position == 10) {
        Intent myIntent = new Intent(view.getContext(), Phytechnique.class);
        startActivityForResult(myIntent, 0);
        }

        }
        });
        }

private ArrayList<ModelList> generateData() {
        ArrayList<ModelList> items = new ArrayList<ModelList>();
        items.add(new ModelList(" 1st Chapter short techniques"));
        items.add(new ModelList(" 2nd Chapter short techniques"));
        items.add(new ModelList(" 3rd Chapter short techniques"));
        items.add(new ModelList(" 4th Chapter short techniques"));
        items.add(new ModelList(" 5th Chapter short techniques"));
        items.add(new ModelList(" 6th Chapter short techniques"));
        items.add(new ModelList(" 7th Chapter short techniques "));
        items.add(new ModelList(" 8th Chapter short techniques "));
        items.add(new ModelList(" 9th Chapter short techniques"));
        items.add(new ModelList(" 10th Chapter short techniques "));

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