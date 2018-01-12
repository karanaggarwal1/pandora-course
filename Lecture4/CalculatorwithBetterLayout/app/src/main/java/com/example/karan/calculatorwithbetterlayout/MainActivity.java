package com.example.karan.calculatorwithbetterlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public double a = 0;
    public double b = 0;
    public int count=0;
    public char ch;
    public static final String TAG = "MainAct";
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btndot, btnsub, btnmul, btnplus, btndiv, btnC, btneql;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnC = (Button) findViewById(R.id.btnC);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnmul = (Button) findViewById(R.id.btnmul);
        btnplus = (Button) findViewById(R.id.btnplus);
        btnsub = (Button) findViewById(R.id.btnsub);
        btndot = (Button) findViewById(R.id.btndiv);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btneql = (Button) findViewById(R.id.btneql);
        View.OnClickListener buttonClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn0:
                        tvResult.setText(tvResult.getText()+"0");
                        break;
                    case R.id.btn1:
                        tvResult.setText(tvResult.getText()+"1");
                        break;
                    case R.id.btn2:
                        tvResult.setText(tvResult.getText()+"2");
                        break;
                    case R.id.btn3:
                        tvResult.setText(tvResult.getText()+"3");
                        break;
                    case R.id.btn4:
                        tvResult.setText(tvResult.getText()+"4");
                        break;
                    case R.id.btn5:
                        tvResult.setText(tvResult.getText()+"5");
                        break;
                    case R.id.btn6:
                        tvResult.setText(tvResult.getText()+"6");
                        break;
                    case R.id.btn7:
                        tvResult.setText(tvResult.getText()+"7");
                        break;
                    case R.id.btn8:
                        tvResult.setText(tvResult.getText()+"8");
                        break;
                    case R.id.btn9:
                        tvResult.setText(tvResult.getText()+"9");
                        break;
                    case R.id.btndot:
                        tvResult.setText(tvResult.getText()+".");
                        break;
                    case R.id.btnmul:
                        if(count==0){
                            a=Float.parseFloat(tvResult.getText()+"");
                            Log.d(TAG, "onClick: a"+a);
                        }
                        else
                        {
                            b=Float.parseFloat(tvResult.getText()+"");
                            Log.d(TAG, "onClick: b"+b);
                        }
                        tvResult.setText("");
                        ch='*';
                        count++;
                        break;
                    case R.id.btndiv:
                        if(count==0){
                            a=Float.parseFloat(tvResult.getText()+"");
                        }
                        else
                        {
                            b=Float.parseFloat(tvResult.getText()+"");
                        }
                        tvResult.setText("");
                        ch='/';
                        count++;
                        break;
                    case R.id.btnsub:
                        if(count==0){
                            a=Float.parseFloat(tvResult.getText()+"");
                        }
                        else
                        {
                            b=Float.parseFloat(tvResult.getText()+"");
                        }
                        tvResult.setText("");
                        ch='-';
                        count++;
                        break;
                    case R.id.btnplus:
                        if(count==0){
                            a=Float.parseFloat(tvResult.getText()+"");
                        }
                        else
                        {
                            b=Float.parseFloat(tvResult.getText()+"");
                        }
                        tvResult.setText("");
                        ch='+';
                        count++;
                        break;
                    case R.id.btnC:
                            a = 0.0;
                            b = 0.0;

                            tvResult.setText("");
                            break;
                    case R.id.btneql:
                        displayResult(ch);
                        tvResult.setText(String.valueOf(a));
                        Log.d(TAG, "onClick: "+a);
                        b=0.0;
                }
            }
        };
        btn0.setOnClickListener(buttonClicked);
        btn1.setOnClickListener(buttonClicked);
        btn2.setOnClickListener(buttonClicked);
        btn3.setOnClickListener(buttonClicked);
        btn4.setOnClickListener(buttonClicked);
        btn5.setOnClickListener(buttonClicked);
        btn6.setOnClickListener(buttonClicked);
        btn7.setOnClickListener(buttonClicked);
        btn8.setOnClickListener(buttonClicked);
        btn9.setOnClickListener(buttonClicked);
        btnplus.setOnClickListener(buttonClicked);
        btnmul.setOnClickListener(buttonClicked);
        btndiv.setOnClickListener(buttonClicked);
        btnsub.setOnClickListener(buttonClicked);
        btnC.setOnClickListener(buttonClicked);
        btndot.setOnClickListener(buttonClicked);
        btneql.setOnClickListener(buttonClicked);
    }


    public void displayResult(char ch) {
        switch (ch) {
            case '+':
                a=a+b;
                Log.d(TAG, "displayResult: "+a);
                break;
            case '-':
                a=a-b;
                break;
            case '/':
                a=a/b;
                break;
            case '*':
                a=a*b;
                break;
        }
    }

}
