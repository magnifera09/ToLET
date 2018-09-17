package com.hpe.tolet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class SliderActivity extends AppCompatActivity implements View.OnClickListener {
ViewFlipper vf;
    Button s,n;
    ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
       vf= (ViewFlipper) findViewById(R.id.viewFlipper);
        s= (Button) findViewById(R.id.next);
        s.setOnClickListener(this);
        n= (Button) findViewById(R.id.prev);
        n.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view==s) {




             Intent in = new Intent(this, LoginActivityOfTolet.class);
               startActivity(in);
            finish();
            }

        else if(view==n)
        {
            vf.showNext();
        }
    }
}
