package com.hpe.tolet;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class profile extends AppCompatActivity {
  ImageView iv;
    TextView tvname,tvemail;
    FirebaseAuth mAuth;
    SharedPreferences preferences,preferences1;
    String email,emaillogin,user,url;
    String email1,url1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=mAuth.getCurrentUser();
        if( firebaseUser != null) {
            email1 = firebaseUser.getEmail();
            url1= String.valueOf(firebaseUser.getPhotoUrl());
        }


        Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
        preferences=getApplicationContext().getSharedPreferences("Myprefs", Context.MODE_PRIVATE);
        preferences1=getApplicationContext().getSharedPreferences("MyPref",0);
         //
        emaillogin=preferences1.getString("dealer","");
        email=preferences.getString("gmail","");
        url=preferences.getString("url","");
        Toast.makeText(this, "em"+emaillogin+"photo"+url1, Toast.LENGTH_SHORT).show();
        iv=findViewById(R.id.prof_img1);

        tvemail=findViewById(R.id.email1);

        if (TextUtils.isEmpty(url))
        {
          //  Picasso.with(getApplicationContext()).cancelRequest(iv);
           // iv.setImageDrawable(null);
            Picasso.with(getApplicationContext()).load(R.drawable.babyimg).into(iv);
        }
else
        {
            Picasso.with(getApplicationContext()).load(url).fit().into(iv);
            tvemail.setText(email1);
        }

        if (email1==null && url1==null)
        {
            tvemail.setText(emaillogin);
        }

    }



}
