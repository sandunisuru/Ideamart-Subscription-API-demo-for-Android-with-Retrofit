package me.morasquad.ideamart_subcription;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.morasquad.ideamart_subcription.API.APIService;
import me.morasquad.ideamart_subcription.API.APIUrl;
import me.morasquad.ideamart_subcription.Models.Request;
import me.morasquad.ideamart_subcription.Models.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button subscribe, unsubscribe, status;
    EditText number;
    private String AppID = "APP_000001";  //App Id is here
    private String AppPassword = "password";  //App Password is Here
    private String version = "1.0";
    private String action = "";
    private String subscriberId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (EditText) findViewById(R.id.number);
        subscribe = (Button) findViewById(R.id.subscribe);
        unsubscribe = (Button) findViewById(R.id.unsubscribe);
        status = (Button) findViewById(R.id.check_status);

        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobileNumber = number.getText().toString().trim();

                //Mobile Number Validation
                if (!(mobileNumber.length() == 10 )){

                    Toast.makeText(MainActivity.this, "Mobile Number Invalid", Toast.LENGTH_SHORT).show();
                }else if(!(mobileNumber.charAt(0) == '0')){

                    Toast.makeText(MainActivity.this, "Mobile Number is Invalid", Toast.LENGTH_SHORT).show();
                }else {
                    //Mobile Number Truncation
                    int number = Integer.parseInt(mobileNumber);
                    int truncated = number%1000000000;
                    String data = Integer.toString(truncated);

                    subscribeNow(data);
                }
            }
        });

        unsubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobileNumber = number.getText().toString().trim();
                if (!(mobileNumber.length() == 10 )){

                    Toast.makeText(MainActivity.this, "Mobile Number Invalid", Toast.LENGTH_SHORT).show();
                }else if(!(mobileNumber.charAt(0) == '0')){

                    Toast.makeText(MainActivity.this, "Mobile Number is Invalid", Toast.LENGTH_SHORT).show();
                }else {

                    int number = Integer.parseInt(mobileNumber);
                    int truncated = number%1000000000;
                    String data = Integer.toString(truncated);

                    unsubscribeNow(data);
                }
            }
        });
    }

    //Retrofit Connection for Unsubscribe Service
    private void unsubscribeNow(String data) {

        //In Ideamart Subscription API Action = 0 means Unsubscribe the service
        action = "0";
        subscriberId = "tel:94"+data;


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        final Request request = new Request(AppID, AppPassword, version, action, subscriberId);


        Call<Result> call = service.sendRequest(
                request
        );

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                if (response.body().getStatusCode().equals("S1000")) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

                }else if (response.body().getStatusCode().equals("E1351")){

                    Toast.makeText(MainActivity.this, "User is Already Registered", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    //Retrofit Connection for Subscribe Service
    private void subscribeNow(String mobileNumber) {

        //In Ideamart Subscription API Action = 1 means subscribe the service
        action = "1";
        subscriberId = "tel:94"+mobileNumber;

        //Creating Object of Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);

        final Request request = new Request(AppID, AppPassword, version, action, subscriberId);


        Call<Result> call = service.sendRequest(
                request
        );

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                if (response.body().getStatusDetail().equals("Success")) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
               }else if (response.body().getStatusCode().equals("E1351")){

                    Toast.makeText(MainActivity.this, "User is Already Registered", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }


}
