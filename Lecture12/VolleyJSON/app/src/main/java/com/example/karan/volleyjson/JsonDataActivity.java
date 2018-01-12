package com.example.karan.volleyjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.karan.volleyjson.models.Post;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonDataActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button button;
    RequestQueue requestQueue;
    ArrayList<Post> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_data);
        button = (Button) findViewById(R.id.button);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final Gson gson = new Gson();
        requestQueue = Volley.newRequestQueue(this);
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("https://jsonplaceholder.typicode.com/posts", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                postList = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    JSONObject postJsonObj = null;
                    try {
                        postJsonObj = response.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Post post = gson.fromJson(postJsonObj.toString(), Post.class);
                    postList.add(post);
                    Log.d("MA", "onResponse: " + postList.size());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestQueue.add(jsonArrayRequest);
                recyclerView.setLayoutManager(new LinearLayoutManager(JsonDataActivity.this));
                PostAdapter postAdapter = new PostAdapter(postList, JsonDataActivity.this);
                recyclerView.setAdapter(postAdapter);
            }
        });


    }
}
