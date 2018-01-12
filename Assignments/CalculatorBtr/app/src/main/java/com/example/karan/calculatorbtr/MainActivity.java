package com.example.karan.calculatorbtr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String TAG=":";
    TextView result;
    Button one, two, three, four, five, six, seven, eight, nine, mul, div, sub, add, cancel, zero, equal, dot;
    Boolean flag = true, flag2 = false;
    double a = 0.0;
    double b = 0.0;
    double multiplier = 0.1;
    int counter = 0;
    char c = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (Button) findViewById(R.id.btn1);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        zero = (Button) findViewById(R.id.btn0);
        div = (Button) findViewById(R.id.btndiv);
        mul = (Button) findViewById(R.id.btnmul);
        sub = (Button) findViewById(R.id.btnsub);
        add = (Button) findViewById(R.id.btnplus);
        equal = (Button) findViewById(R.id.btneql);
        cancel = (Button) findViewById(R.id.btnC);
        result = (TextView) findViewById(R.id.tvResult);
        dot = (Button) findViewById(R.id.btndot);
        View.OnClickListener ButtonClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn1:
                        addtoaorb((float) 1.0);
                        break;
                    case R.id.btn2:
                        addtoaorb((float) 2.0);
                        break;
                    case R.id.btn3:
                        addtoaorb((float) 3.0);
                        break;
                    case R.id.btn4:
                        addtoaorb((float) 4.0);
                        break;
                    case R.id.btn5:
                        addtoaorb((float) 5.0);
                        break;
                    case R.id.btn0:
                        addtoaorb(0);
                        break;
                    case R.id.btn6:
                        addtoaorb((float) 6.0);
                        break;
                    case R.id.btn7:
                        addtoaorb((float) 7.0);
                        break;
                    case R.id.btn8:
                        addtoaorb((float) 8.0);
                        break;
                    case R.id.btn9:
                        addtoaorb((float) 9.0);
                        break;
                    case R.id.btnplus:
                        addandshow();
                        flag2=false;
                        break;
                    case R.id.btnmul:
                        mulandshow();
                        flag2=false;
                        break;
                    case R.id.btndiv:
                        divandshow();
                        flag2=false;
                        break;
                    case R.id.btnsub:
                        subandshow();
                        flag2=false;
                        break;
                    case R.id.btneql:
                        showResult();
                        flag2=false;
                        break;
                    case R.id.btnC:
                        cancel();
                        flag2=false;
                        break;
                    case R.id.btndot:
                        flag2=true;
                }
            }
        };
        one.setOnClickListener(ButtonClicked);
        two.setOnClickListener(ButtonClicked);
        three.setOnClickListener(ButtonClicked);
        four.setOnClickListener(ButtonClicked);
        five.setOnClickListener(ButtonClicked);
        six.setOnClickListener(ButtonClicked);
        seven.setOnClickListener(ButtonClicked);
        eight.setOnClickListener(ButtonClicked);
        nine.setOnClickListener(ButtonClicked);
        zero.setOnClickListener(ButtonClicked);
        add.setOnClickListener(ButtonClicked);
        sub.setOnClickListener(ButtonClicked);
        div.setOnClickListener(ButtonClicked);
        mul.setOnClickListener(ButtonClicked);
        equal.setOnClickListener(ButtonClicked);
        cancel.setOnClickListener(ButtonClicked);
        dot.setOnClickListener(ButtonClicked);

    }

    public void showResult() {
        switch (c) {
            case '+':
                result.setText(String.valueOf(a + b));
                a=a+b;
                b=(double)0;
                break;
            case '-':
                result.setText(String.valueOf(a - b));
                a=a-b;
                b=(double)0;
                break;
            case '/':
                result.setText(String.valueOf(a / b));
                a=a/b;
                b=(double)0;
                break;
            case '*':
                result.setText(String.valueOf(a * b));
                a=a*b;
                b=(double)0;
                break;
        }
    }

    public void cancel() {
        a = (double) 0;
        b = (double) 0;
        result.setText("");
    }

    public void subandshow() {
        result.setText("");
        counter++;
        flag = !flag;
        c = '-';
        if (counter > 1) {
            showResult();
            flag = !flag;
            a = a - b;
            b = Float.parseFloat(result.getText()+"");
        }

//        if(a!=null&&b!=null)
//        {
//            showResult();
//        }
    }

    public void divandshow() {
        result.setText("");
        flag = !flag;
        c = '/';
        counter++;
        if (counter > 1) {
            showResult();
            flag = !flag;
            result.setText("");
            a = a / b;
            b = Float.parseFloat(result.getText()+"");
        }

//        if(a!=null&&b!=null)
//        {
//            showResult();
//        }
    }

    public void mulandshow() {

        flag = !flag;
        counter++;
        c = '*';
        if (counter > 1) {
            showResult();
            flag = !flag;
            result.setText("");
            a = a * b;
            b = 0;
        }

//        if(a!=null&&b!=null)
//        {
//            showResult();
//        }
    }

    public void addtoaorb(float x) {
        if (flag) {
//            if(a==null)
//            {
//                a=(double)0;
//            }
            if (!flag2) {
                a = a * 10 + x;
                result.setText(String.valueOf(a));
            } else {
                a += (x * multiplier);
                multiplier /= 10;
                result.setText(String.valueOf(a));
            }
        } else {
//            if(b==null)
//            {
//                a=(double)0;
//            }
            b = b * 10 + x;
            result.setText(String.valueOf(b));
        }
    }

    public void addandshow() {
        flag = !flag;
        counter++;
        c = '+';
        if (counter > 1) {
            showResult();
            flag = !flag;
            result.setText("");
            a = a + b;
            b = 0;
        }

    }

}
