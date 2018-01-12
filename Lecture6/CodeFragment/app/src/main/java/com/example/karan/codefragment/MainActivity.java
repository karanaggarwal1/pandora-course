package com.example.karan.codefragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//we need a fragment manager to import fragments into main activity via code
//fluent api-a way of programming where setters of classes return the object this itself
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fragmentManager;
    //FragmentTransaction fragTxn is returned by fragManager.beginTransaction() it helps to carry out all tasks simultaneously within the same fragment via the commit() function
    //savedInstanceState
    public final int FRAG_BLUE = 0;
    public final int FRAG_RED = 1;
    public int fragType = FRAG_BLUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnRed = (Button) findViewById(R.id.btnRed);
        Button btnBlue = (Button) findViewById(R.id.btnBlue);
        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            fragType = savedInstanceState.getInt("fragvalue");
        }
        getFrag(fragType);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("fragvalue", fragType);
        super.onSaveInstanceState(outState);
    }

    public void getFrag(int fragx) {
        fragType = fragx;
        switch (fragx) {
            case FRAG_BLUE:
                BlueFragment blueFragment = new BlueFragment();
                fragmentManager.beginTransaction().replace(R.id.flFragContainer, blueFragment).commit();
                break;
            case FRAG_RED:
                RedFragment redFragment = new RedFragment();
                fragmentManager.beginTransaction().replace(R.id.flFragContainer, redFragment).commit();
                break;

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBlue:
                getFrag(FRAG_BLUE);
                break;
            case R.id.btnRed:
                getFrag(FRAG_RED);
                break;
        }
    }
}
