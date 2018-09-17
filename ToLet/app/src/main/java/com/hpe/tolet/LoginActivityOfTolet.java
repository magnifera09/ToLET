package com.hpe.tolet;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;
import com.hpe.tolet.Google.GoogleActivity;

public class LoginActivityOfTolet extends AppCompatActivity {
     EditText et,et2;
     Button b;
    TextView tv6;
    String emailLogin,passwordLogin;
    SignInButton signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_of_tolet);

        et= (EditText) findViewById(R.id.editText);
        et2= (EditText) findViewById(R.id.editText2);
    et.setText("d@g.c");
    et2.setText("hello");
        b= (Button) findViewById(R.id.button);

        tv6= (TextView) findViewById(R.id.textView6);
        //
         signInButton = findViewById(R.id.sign_in_button1);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivityOfTolet.this, GoogleActivity.class);
                startActivity(i);
            }
        });    }


    public void signupper(View v){
        Intent i=new Intent(this, SignUpModule.class);
        startActivity(i);

    }

    public void signinopener(View v){


        if(et.getText().toString().length()==0)
        {
            et.setError("EMAIL CANNOT BE BLANK");
        }
        if(et2.getText().toString().length()==0)
        {
            et2.setError("PASSWORD CANNOT BE BLANK");
        }


        emailLogin=et.getText().toString().trim();
        passwordLogin=et2.getText().toString().trim();

        Toast.makeText(this, "email"+emailLogin+"password"+passwordLogin, Toast.LENGTH_SHORT).show();

        String method="login1";
        if (isOnline())
        {

            Toast.makeText(this, "connection is ok", Toast.LENGTH_SHORT).show();
            Log.d("Tag","1");
            BackgroundTask backgroundTask=new BackgroundTask(LoginActivityOfTolet.this);
            backgroundTask.execute(method,emailLogin,passwordLogin);

        }
    }
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null && info.isConnectedOrConnecting();
    }


        /*if(username.equals("tolet99")&&pass.equals("brofrobro")){
            Toast.makeText(this, "Welcome to Tolet App :)", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,HomePage.class);
            startActivity(i);
        }
      */
    }




