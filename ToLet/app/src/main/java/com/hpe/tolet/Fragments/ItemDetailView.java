package com.hpe.tolet.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;


import com.hpe.tolet.R;
import com.squareup.picasso.Picasso;

public class ItemDetailView extends AppCompatActivity implements View.OnClickListener {
TextView typer,owner,address,price,detail,mobile,roommate,tvroom;
String type1,typer1,owner1,address1,price1,detail1,mobile1,roommate1,imagepath1;
ImageView iv;
Button btpurchase;
String dealername;

//firebae
FirebaseAuth mAuth;
String usergmail;
String demail;
SharedPreferences pref,preffire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail_view);
        pref=getSharedPreferences("MyPref",0);
        dealername=pref.getString("dealer","");
        preffire=getSharedPreferences("Mypref1",0);
        usergmail=preffire.getString("gmail","");
     //   Toast.makeText(this, "dealer email"+dealername, Toast.LENGTH_SHORT).show();
       // Toast.makeText(this, "gmail"+usergmail, Toast.LENGTH_SHORT).show();

if (dealername ==null)
{
    demail=usergmail;
}
if (usergmail==null)
{
    demail=dealername;
}

        //start
        btpurchase=findViewById(R.id.btnpurchase);
        iv=findViewById(R.id.ivImage1);

        typer=findViewById(R.id.txttype1);
        owner=findViewById(R.id.txtowner);
        address=findViewById(R.id.txtloc);
        price=findViewById(R.id.txtprice);
        detail=findViewById(R.id.txtdetail);
        mobile=findViewById(R.id.txtphone);
        roommate=findViewById(R.id.txtroomm);
        tvroom=findViewById(R.id.tvroom);
        //extract values
        Intent intent=getIntent();
         type1=intent.getStringExtra("top");
         typer1=intent.getStringExtra("topr");
        owner1=intent.getStringExtra("own");
         price1=intent.getStringExtra("price");
      address1=intent.getStringExtra("loc");
        detail1=intent.getStringExtra("detail");
        mobile1=intent.getStringExtra("mob");
      roommate1=intent.getStringExtra("roomm");
     imagepath1=intent.getStringExtra("imagepath");
if (roommate1==null)
{
    tvroom.setVisibility(View.INVISIBLE);
    roommate.setVisibility(View.INVISIBLE);
}


        //set values
        typer.setText(typer1);
        owner.setText(owner1);
        address.setText(address1);
        price.setText(price1);
        detail.setText(detail1);
        mobile.setText(mobile1);
        roommate.setText(roommate1);
        Picasso.with(this).load(imagepath1)
                .error(R.drawable.ic_image_error)
                .into(iv);

//end
btpurchase.setOnClickListener(this);


    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null && info.isConnectedOrConnecting();
    }


    @Override
    public void onClick(View view) {

//send deal data to server
      Toast.makeText(this, "type" + type1 + "1property" + typer1+
                "2address" + address1 + "3price" + price1 + "4details" + detail1 +
                "5phone" + mobile1 + "6owner" + owner1 + "7permissions" + roommate1+
                 "8imagepath" + imagepath1+"demail"+dealername, Toast.LENGTH_LONG).show();

if (demail==null)
{
    demail=dealername;
}


        String method = "postdeal";
        if (isOnline()) {
if (roommate1==null)
{
    roommate1="Not Mention";
}
            Toast.makeText(this, "connection is ok", Toast.LENGTH_SHORT).show();

            Log.d("ad","type" + type1 + "1property" + typer1+
                    "2address" + address1 + "3price" + price1 + "4details" + detail1 +
                    "5phone" + mobile1 + "6owner" + owner1 + "7permissions" + roommate1+
                    "8postimages" + imagepath1+"image::::"+"demail"+demail);


            BackgroundTaskDeal backgroundTaskDeal = new BackgroundTaskDeal(this);
            backgroundTaskDeal.execute(method, type1,typer1,address1, price1,
                    detail1, mobile1,owner1, roommate1,imagepath1,demail);


        }
    }
}
