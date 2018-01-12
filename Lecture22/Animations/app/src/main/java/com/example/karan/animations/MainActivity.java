package com.example.karan.animations;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ObjectAnimator animator = ObjectAnimator.ofFloat(findViewById(R.id.text1), "translationX", 0f, 700f);
        /**
         * object animator can change only the default properties of the objects that extend view
         * like translationX,translationY etc
         * radius is always a custom property
         * it has to be changed through value animator
         * */
//        animator.setDuration(2000);
//        animator.start();
    }

    public void navigate(View view) {
//        Intent intent= new Intent(this, SecondActivity.class);
//
//        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
//                Pair.create(findViewById(R.id.image1), "transition_image"),
//                Pair.create(findViewById(R.id.fab), "transition_fab"));
//
//        startActivity(intent, options.toBundle());
        ImageView imageView = (ImageView) findViewById(R.id.image1);
        int cx = imageView.getWidth() / 2;
        int cy = imageView.getHeight() / 2;
        int finalradius = imageView.getHeight();
        Animator anim = ViewAnimationUtils.createCircularReveal(imageView, cx, cy, 0, finalradius);
        anim.setDuration(6000);
        imageView.setVisibility(View.VISIBLE);
        anim.start();
    }
}
