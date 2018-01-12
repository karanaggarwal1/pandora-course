package com.example.karan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainAct";

    EditText etNum1, etNum2;
    Button btnAdd,btnSub,btnDiv,btnMul;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1=(EditText) findViewById(R.id.etNum1);
        etNum2= (EditText) findViewById(R.id.etNum2);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnSub=(Button) findViewById(R.id.btnSub);
        btnDiv=(Button) findViewById(R.id.btnDiv);
        btnMul=(Button) findViewById(R.id.btnMul);
        tvResult=(TextView) findViewById(R.id.tvResult);
//        to create non wrap calculator, change addandshow() etc functions
        final View.OnClickListener ButtonClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==btnAdd.getId())
                {
                    addandshow();
                }
                else if(view.getId()==btnSub.getId())
                {
                    subtractandshow();
                }
                else if(view.getId()==btnMul.getId())
                {
                    mulandshow();
                }
                else
                {
                    divandshow();
                }
                Log.d(TAG, "onCreate: "+view.getId());
            }
        };
        btnAdd.setOnClickListener(ButtonClicked);
        btnDiv.setOnClickListener(ButtonClicked);
        btnSub.setOnClickListener(ButtonClicked);
        btnMul.setOnClickListener(ButtonClicked);
    /*
    int div=0
    while(true)
    {
        div=div*10+a;
    }
    */

    }
    void addandshow() {
        int a = Integer.valueOf(etNum1.getText().toString());
        int b = Integer.valueOf(etNum2.getText().toString());
        tvResult.setText(String.valueOf(a + b));
        etNum1.setText(String.valueOf(a+b));
    }
    void mulandshow() {
        int a = Integer.valueOf(etNum1.getText().toString());
        int b = Integer.valueOf(etNum2.getText().toString());

        tvResult.setText(String.valueOf(a * b));
        etNum1.setText(String.valueOf(a*b));
    }
    void divandshow() {
        int a = Integer.valueOf(etNum1.getText().toString());
        int b = Integer.valueOf(etNum2.getText().toString());

        tvResult.setText(String.valueOf(a / b));
        etNum1.setText(String.valueOf(a/b));
    }
    void subtractandshow() {
        int a = Integer.valueOf(etNum1.getText().toString());
        int b = Integer.valueOf(etNum2.getText().toString());

        tvResult.setText(String.valueOf(a - b));
        etNum1.setText(String.valueOf(a-b));
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
