package com.example.karan.volleyjson;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.karan.volleyjson.models.Course;
import com.example.karan.volleyjson.models.TestJson;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JsonOpsActivty extends AppCompatActivity {
    public static final String TAG = "MainActivty";
    Button btnReadJson;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_ops_activty);
        btnReadJson = (Button) findViewById(R.id.btnReadJson);
        gson = new Gson();
        btnReadJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String JsonData = getJsonFileasString("test.json");
                    TestJson testJson = gson.fromJson(JsonData, TestJson.class);
//                    JSONObject coursesObj = new JSONObject(JsonData);
//                    JSONArray coursesArray = coursesObj.getJSONArray("courses");
//                    ArrayList<Course> courseList = new ArrayList<Course>();
//                    for (int i = 0; i < coursesArray.length(); i++) {
//                        courseList.add(gson.fromJson(coursesArray.getJSONObject(i).toString(), Course.class));
                    Log.d(TAG, "onClick: " + testJson.getCourses().get(0).getTeacher());
                    Log.d(TAG, "onClick: " + testJson.getCourses().get(2).getStudents().get(1).getName());
//                    }

                } catch (Exception e) {
                    Log.e(TAG, "onClick: some problem with json parsing ");
                    e.printStackTrace();
                }

            }
        });
    }

    String getJsonFileasString(String filename) {
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open(filename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            Log.e(TAG, "error reading file: ");
        }
        return null;
    }
}
