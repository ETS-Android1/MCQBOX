package myapps.quiz1.Activity.rules;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import myapps.quiz1.Adapter.RulestAdapter;
import myapps.quiz1.Api.ApiService;
import myapps.quiz1.Api.ApiUrl;
import myapps.quiz1.Model.Formula;
import myapps.quiz1.Model.Formuladata;
import myapps.quiz1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 11-Mar-18.
 */
public class Physicsrules extends AppCompatActivity {
    ListView listview;
    RulestAdapter adapter;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phy_rules);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listview = (ListView) findViewById(R.id.listview);
        getAllrules();
    }
    private void getAllrules() {
       /* pDialog = new ProgressDialog(Physicsrules.this,
                R.style.AppTheme_Dark_Dialog);
        pDialog.setCancelable(false);
        pDialog.setIndeterminate(true);

        pDialog.setMessage("loading data,please wait...");
        pDialog.show();*/
       // private ProgressDialog pDialog;
        pDialog = ProgressDialog.show(Physicsrules.this,"Loading...","Loading data, please wait...", false, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<Formuladata> call =  api.getAllrules();

        call.enqueue(new Callback<Formuladata>() {
            @Override
            public void onResponse(Call<Formuladata> call, Response<Formuladata> response) {
                pDialog.dismiss();
                ArrayList<Formula> allshort = response.body().getAllrules();

                //creating adapter object
                adapter = new RulestAdapter(getApplicationContext(), allshort);

                //adding it to adapterview flipper
                listview.setAdapter(adapter);
             //   listview.setDivider(new ColorDrawable(Color.parseColor("#0040c1")));
             //   listview.setDividerHeight(3);



            }

            @Override
            public void onFailure(Call<Formuladata> call, Throwable t) {
               pDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
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




