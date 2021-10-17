package myapps.quiz1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import myapps.quiz1.Activity.modeltest.ChapterTestActivity;
import myapps.quiz1.Activity.modeltest.ModeltestActivity;
import myapps.quiz1.Activity.rules.RulesActivity;
import myapps.quiz1.Adapter.Main1Adapter;
import myapps.quiz1.Adapter.Main2Adapter;
import myapps.quiz1.Adapter.MainAdapter;
import myapps.quiz1.Helper.PrefManager;
import myapps.quiz1.R;

/**
 * Created by comsol on 29-Jan-18.
 */
public class Main1Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private View navHeader;
    MainAdapter adapter;
    Main1Adapter adapter1;
    Main2Adapter adapter2;
    TextView textView,textView1,textView2,textView3,textView4,textView5,textView6;
    ImageView imageView,imageView1,imageView2,imageView3,imageView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navHeader = navigationView.getHeaderView(0);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       String[] course = {" CHAPTER TEST" ,"COURSE LIST"};
        String[] course1 = {"MODEL TEST"," Techniques"};
        String[] course2 = {"FORMULAS","SETTINGS"};
        int[] Imageid = {R.drawable.quiz_id,R.drawable.che_5};
        int[] Imageid1 = {R.drawable.questions_id,R.drawable.help};
        int[] Imageid3 = {R.drawable.formulas,R.drawable.settings};


        GridView gridview = (GridView) findViewById(R.id.gridview);
        adapter = new MainAdapter(Main1Activity.this, course, Imageid);
        gridview.setAdapter(adapter);

        GridView gridview1 = (GridView) findViewById(R.id.gridview1);
        adapter1 = new Main1Adapter(Main1Activity.this,course1,Imageid1);
        gridview1.setAdapter(adapter1);

        GridView gridview2 = (GridView) findViewById(R.id.gridview2);
        adapter2 = new Main2Adapter(Main1Activity.this,course2,Imageid3);
        gridview2.setAdapter(adapter2);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Launch ViewImage.java using intent
                if (position == 0) {
                    Intent myIntent1 = new Intent(view.getContext(),  ChapterTestActivity.class);
                    startActivityForResult(myIntent1, 0);
                }
                if (position == 1) {
                    Intent myIntent1 = new Intent(view.getContext(),  CourseActivity.class);
                    startActivityForResult(myIntent1, 0);
                }
            }
        });
        gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position1, long id) {

                // Launch ViewImage.java using intent
                if (position1 == 0) {
                    Intent ii = new Intent(view.getContext(), ModeltestActivity.class);
                    startActivityForResult(ii, 0);
                }
                if (position1 == 1) {
                    Intent myIntent1 = new Intent(view.getContext(),  HelpActivity.class);
                    startActivityForResult(myIntent1, 0);
                }


            }
        });
        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position2, long id) {

                // Launch ViewImage.java using intent
                if (position2 == 0) {
                    Intent iii = new Intent(view.getContext(), RulesActivity.class);
                    startActivityForResult(iii, 0);
                }
                if (position2 == 1) {
                    Intent myIntent2 = new Intent(view.getContext(),  SettingsActivity.class);
                    startActivityForResult(myIntent2, 0);
                }


            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
      /*  if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //if (id == R.id.home) {
            // Handle the camera action

       if (id == R.id.nav_log) {

           PrefManager pref = new PrefManager(this);
           pref.clearSession();

           startActivity(new Intent(Main1Activity.this, MainActivity.class));

        } if (id == R.id.nav_course) {

            Intent intent = new Intent(Main1Activity.this, CourseActivity.class);

            startActivity(intent);

        } else if (id == R.id.nav_test) {
            Intent intent = new Intent(Main1Activity.this, ModeltestActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_help) {
            Intent intent = new Intent(Main1Activity.this, HelpActivity.class);
            startActivity(intent);
        }

         else if (id == R.id.nav_rules) {
            Intent intent = new Intent(Main1Activity.this, RulesActivity.class);

            startActivity(intent);
        }
        else if (id == R.id.nav_settings) {
            Intent intent = new Intent(Main1Activity.this, SettingsActivity.class);

            startActivity(intent);
        }
         else if (id == R.id.nav_about_us) {
            Intent intent = new Intent(Main1Activity.this, AboutUsActivity.class);

            startActivity(intent);
        }
        else if (id == R.id.nav_policy) {
            Intent intent = new Intent(Main1Activity.this, PrivacyPolicyActivity.class);

            startActivity(intent);
        }
        else if (id == R.id.nav_exit) {
           Main1Activity.this.finish();
           return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
