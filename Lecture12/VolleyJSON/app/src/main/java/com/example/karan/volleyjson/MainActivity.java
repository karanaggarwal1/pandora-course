package com.example.karan.volleyjson;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    Button btnSendReq;
    RequestQueue requestQueue;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        btnSendReq = (Button) findViewById(R.id.btnSendReq);
        textView=(TextView)findViewById(R.id.textView);
        btnSendReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://example.com", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //request has been completed and response has been fetched
                        textView.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //will be called if any error is encountered
                        Log.d(TAG, "onErrorResponse: ");
                    }
                });
                stringRequest.setTag("my request");
                //parameters-get or post(optional, if not given it is always get,string url, two interfaces, normal and error listener
                requestQueue.add(stringRequest);
                //requestQueue.cancelAll("my request"); will cancel the request with the given tag
//                requestQueue.cancelAll(new RequestQueue.RequestFilter() {
//                    @Override
//                    public boolean apply(Request<?> request) {
//                        if (request == stringRequest) {
//                            return true;
//                        }
//                        return false;
//                    }
//                });
// the above code will help to cancel various requests together based on their identity
                requestQueue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<StringRequest>() {
                    @Override
                    public void onRequestFinished(Request<StringRequest> request) {
                        Toast.makeText(MainActivity.this, "Request Completed", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });

    }
}
