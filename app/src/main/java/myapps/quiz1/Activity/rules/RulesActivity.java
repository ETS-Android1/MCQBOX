package myapps.quiz1.Activity.rules;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import myapps.quiz1.R;

/**
 * Created by comsol on 11-Mar-18.
 */
public class RulesActivity extends AppCompatActivity {
    TextView labelView, labelView1, labelView2;
    ImageView imageView,imageView1,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        labelView = (TextView)findViewById(R.id.label);
        labelView1 = (TextView)findViewById(R.id.label1);
        labelView2 = (TextView)findViewById(R.id.label2);

        imageView = (ImageView) findViewById(R.id.grid_image);
        imageView1 = (ImageView) findViewById(R.id.grid_image1);
        imageView2 = (ImageView) findViewById(R.id.grid_image2);

        labelView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RulesActivity.this, Physicsrules.class);
                startActivity(myIntent);
            }
        });
        labelView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RulesActivity.this, Physicsrules.class);
                startActivity(myIntent);
            }
        });
        labelView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RulesActivity.this, Physicsrules.class);
                startActivity(myIntent);
            }
        });

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