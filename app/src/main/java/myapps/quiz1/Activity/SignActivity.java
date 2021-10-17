package myapps.quiz1.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import myapps.quiz1.Api.ApiService;
import myapps.quiz1.Api.ApiUrl;
import myapps.quiz1.Model.ForLogin;
import myapps.quiz1.Model.Login;
import myapps.quiz1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 29-Jan-18.
 */
public class SignActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SignActivity";
    private static final int REQUEST_SIGNUP = 0;
    private ProgressDialog pDialog;

    @Bind(R.id.input_name)
    EditText _nameText;
    @Bind(R.id.phone)
    EditText _phoneText;
    @Bind(R.id.input_password)
    EditText _passwordText;

    @Bind(R.id.btn_login)
    Button _loginButton;
    //@Bind(R.id.link_signup)
    TextView _signupLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ButterKnife.bind(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();


            }
        });

    }


    public void login() {
        Log.d(TAG, "Login");

        if (validate() == false) {
            onLoginFailed();
            return;
        }

        // _loginButton.setEnabled(false);

        userLogIn();
    }

    private void userLogIn() {
       // private ProgressDialog pDialog;
        pDialog = ProgressDialog.show(SignActivity.this,"Loading...",
                "Loading data, please wait...", false, false);

        String username = _nameText.getText().toString();
        String phone = _phoneText.getText().toString();
        String password = _passwordText.getText().toString();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Defining retrofit api service
        ApiService service = retrofit.create(ApiService.class);

        Login login = new Login(username, phone, password);
        Call<ForLogin> userCall = service.userLogIn(login.getName(), login.getPhone(), login.getPassword()
                );

        userCall.enqueue(new Callback<ForLogin>() {


            @Override
            public void onResponse(Call<ForLogin> call, Response<ForLogin> response) {
                pDialog.dismiss();
                //Log.d("onResponse", "" + response.body().getMessage());


                Toast.makeText(SignActivity.this, "" + "login successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SignActivity.this, Main1Activity.class));

                finish();

            }

            @Override
            public void onFailure(Call<ForLogin> call, Throwable throwable) {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }


    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;


        String password = _passwordText.getText().toString();



        if (password.isEmpty()) {
            _passwordText.setError("Password is empty");
            requestFocus(_passwordText);
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        userLogIn();
    }
}

