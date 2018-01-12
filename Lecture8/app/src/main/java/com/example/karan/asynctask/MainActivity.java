package com.example.karan.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainAct";
    Button btnStart, btnStop;
    TextView textView;
    int x = 1;
    //static boolean flag=true;
    static void loopOneSec() {
        long StartTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - StartTime <= 1000) ;
    }

    /**
     * intent service-onBind() action takes time hence it can't be cancelled until the action has been completed
     * intent service-bringing data back is difficult
     * there are better mechanisms such as Async Task so that the main UI thread is not blocked
     * the threads are executed in a parallel manner but the order is decided by the OS.
     * creating multiple objects don't create a new thread but these multiple objects use the same newly created thread
     * to achieve multiple threads use AsyncWorker
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btnStart);
//        btnStop=(Button)findViewById(R.id.btnStop);
        textView = (TextView) findViewById(R.id.textView);
//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                flag=false;
//            }
//        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
//                flag=true;
                MyTask task = new MyTask();
                task.execute(10);
            }
        });
    }

    /**
     * the return type of doInBackground-(<the third parameter>) is used.
     * the functions onPreExecute() and OnPostExecute() run on the original thread that is the thread on which object was created
     * the order of execution is OnPre(),Progress(),OnPost();
     * calling publishProgress() calls onProgressUpdate() in the main thread
     */
    class MyTask extends AsyncTask<Integer, Float, String> {
        @Override
        protected void onPreExecute() {
            /**
             * this function is used to prepare the service before starting the other thread
             * it can be used to get any data ready before the inBack is executed
             * for example: checking available space*/
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                loopOneSec();
                publishProgress((float) i / (float) integers[0]);
            }
            return "completed";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
//            Log.d(TAG, "onPostExecute: "+1.0/3.0);
            textView.setText(s);
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
            if (values[0] <= 1) {
                textView.setText(values[0]*100+"%");
                x++;
            }
        }
/*
        @Override
        protected Void doInBackground(Void... voids) {
            //the code written here will be executed in a separate thread
            for (int i = 0; i < 10; i++) {
                loopOneSec();
                Log.d(TAG, "doInBackground: " + i);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(x+++" ");
                    }
                });
            }
            return null;
        }
*/
    }
}
