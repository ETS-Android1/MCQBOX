package myapps.quiz1.Activity.modeltest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import myapps.quiz1.Adapter.ModelmixedAdapter;
import myapps.quiz1.Api.ApiService;
import myapps.quiz1.Api.ApiUrl;
import myapps.quiz1.Model.modeltest;
import myapps.quiz1.Model.modeltest1;
import myapps.quiz1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 01-Mar-18.
 */
public class MixedSubjectActivity extends AppCompatActivity {
    ModelmixedAdapter adapter;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physics1_test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listview = (ListView) findViewById(R.id.listview);

        getmodel_list1();

    }
    private void getmodel_list1() {
        final ProgressDialog pDialog = ProgressDialog.show(MixedSubjectActivity.this, "Loading...",
                "Loading data, please wait...", false, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<modeltest> call =  api.getmodel_list1();

        call.enqueue(new Callback<modeltest>() {
            @Override
            public void onResponse(Call<modeltest> call, final Response<modeltest> response) {
                pDialog.dismiss();
                final ArrayList<modeltest1> test = response.body().getModeltest1();
                adapter = new ModelmixedAdapter(getApplicationContext(), test);


                listview.setAdapter( adapter);


                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Intent intent =  new Intent(MixedSubjectActivity.this, ModelTest.class);
                        // Log.d("Course: ", String.valueOf(response.body().getChapterDatas().get(position).getId()));
                        //   intent.putExtra("Course", response.body().getChapterTests().get(position).getId());
                        startActivity(intent);
                    }

                });
            }

            @Override
            public void onFailure(Call<modeltest> call, Throwable t) {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
    }
       /* ModelATestAdapter adapter = new ModelATestAdapter(this, generateData());
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Launch ViewImage.java using intent
                if (position == 0) {
                    Intent i = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(i, 0);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 7) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 8) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 9) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 10) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

            }
        });
    }

    private ArrayList<ModelList> generateData() {
        ArrayList<ModelList> items = new ArrayList<ModelList>();
        items.add(new ModelList(" Mixed Model test 1"));
        items.add(new ModelList(" Mixed Model test 2"));
        items.add(new ModelList(" Mixed Model test 3"));
        items.add(new ModelList(" Mixed Model test 4"));
        items.add(new ModelList(" Mixed Model test 5"));
        items.add(new ModelList(" Mixed Model test 6"));
        items.add(new ModelList(" Mixed Model test 7 "));
        items.add(new ModelList(" Mixed Model test 8 "));
        items.add(new ModelList(" Mixed Model test 9"));
        items.add(new ModelList("Mixed Model test 10"));

        return items;


    }


*/

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
