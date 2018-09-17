package com.hpe.tolet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
 Button b1,b2 ,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        b1=findViewById(R.id.post_ad);
        b2=findViewById(R.id.search_rent);
        b3=findViewById(R.id.search_roomie);

    }

    public void postadClick(View v){
        Intent i =new Intent(this,PostAdModule.class);
        startActivity(i);
    }

    public void searchRentClick(View v){
        Intent i=new Intent(this,SearchRentModule.class);
        startActivity(i);
    }

    public void searchRoommieClick(View v){
        Intent i =new Intent(this, SearchRoomatesModule.class);
        startActivity(i);
    }
}

