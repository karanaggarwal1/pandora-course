package com.example.karan.unittestsinterestcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etPrincipal, etInterest, etYears;
    Button btnCalculateInterest;
    TextView tvAmount;

    public static float calcInterest(float p, float i, int y) {
        return ((p * i * y) / 100) + p;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPrincipal = (EditText) findViewById(R.id.etPrincipal);
        etInterest = (EditText) findViewById(R.id.etInterest);
        etYears = (EditText) findViewById(R.id.etYears);
        tvAmount = (TextView) findViewById(R.id.tvAmount);
        btnCalculateInterest = (Button) findViewById(R.id.btnCalculate);
        btnCalculateInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvAmount.setText("" + calcInterest(
                        Float.valueOf(etPrincipal.getText().toString()),
                        Float.valueOf(etInterest.getText().toString()),
                        Integer.valueOf(etYears.getText().toString())));
            }
        });
    }
}
