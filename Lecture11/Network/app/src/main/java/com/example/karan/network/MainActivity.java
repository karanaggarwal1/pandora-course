package com.example.karan.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.karan.network.models.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etUrl;
    TextView tvResult;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUrl = (EditText) findViewById(R.id.etUrl);
        btnGo = (Button) findViewById(R.id.btnGo);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isConnected()) {
                    String temp = etUrl.getText().toString();
                    new LoadUrlDataTask().execute("https://jsonplaceholder.typicode.com/posts");
                } else {
                    Toast.makeText(MainActivity.this, "You are not connected to the Internet!", Toast.LENGTH_SHORT).show();
//                    Log.d("MA", "onClick: not connected");
                }
            }
        });
    }

    //check if user is connected to the internet or not
    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
//            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
//            }
        }
        return false;
    }

    class LoadUrlDataTask extends AsyncTask<String, Void, ArrayList<Post>> {
        @Override
        protected void onPostExecute(ArrayList<Post> postList) {
//            super.onPostExecute(s);
//            if (s != null) {
//                tvResult.setText(s);
//            }
        }

        @Override
        protected ArrayList<Post> doInBackground(String... params) {
            //there can be various protocols to use, HTTP,FTP,HTTPS etc.
            //so we need to create a connection for that as well
            //to connect through a server we need a port
            //either define a port
            //for an HTTP-the default port is port 80 and for ftp it is port 21
            //we request the code only without being interested in the body
            //it consists of headers,code and bodies
            //headers-cache time
            //^both requests and response consists of ^
            //both connection and code have IOException
            //what if the server returns something the client can't understand
            URL url = null;
            HttpURLConnection httpURLConnection = null;
            try {
                url = new URL(params[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                //setConnectTimeout()-10 seconds default value-set the time max to connect to the network
                //setReadTimeout()-5 seconds default value-set the time max to render the page
                //we can set request method as well
                //by default it is the get request mode
                //setDoOutput(true) makes the body method available for the post type request
                //Javascript Object Notation-JSON

//                httpURLConnection.setRequestMethod("POST");
//                httpURLConnection.setDoOutput(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            OutputStream os = null;
//            try {
//                os = httpURLConnection.getOutputStream();
//                os.write(("hello".getBytes()));
//                Log.d("", "doInBackground: Done");
//                //server will get hello in byte form
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            try {
//                int respCode = httpURLConnection.getResponseCode();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                String str = null;
                while ((str = reader.readLine()) != null) {
                    stringBuilder.append(str);
                }
                ArrayList<Post> respPostList = getPostListFromResponse(stringBuilder.toString());
                return respPostList;
//                return stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private ArrayList<Post> getPostListFromResponse(String s) throws JSONException {
        JSONArray jsonArray=new JSONArray(s);
        ArrayList<Post> retval=new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            retval.add(new Post())
        }
    }
}
