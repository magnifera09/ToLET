package com.hpe.tolet;

import android.animation.Animator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
  TextView tv;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    tv= (TextView) findViewById(R.id.textView);
        iv= (ImageView) findViewById(R.id.imageView);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        final Intent i=new Intent(this,LoginActivityOfTolet.class);

        Thread t=new Thread(){
          public void run()
      {
            try
            {
                sleep(5000);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }

            finally{
                startActivity(i);
                finish();
            }
          }

        };
        t.start();

    }
}
