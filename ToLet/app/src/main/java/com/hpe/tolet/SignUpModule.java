package com.hpe.tolet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class SignUpModule extends AppCompatActivity {
Button submit,reset;
EditText et1,et2,et3,et4,et5,et8,et9,et10,et11;
Spinner sp;
String fname,lname,email,mobno,dob,profession,address,password;
String get_value_of_spinner;
 String   selectedGender;
RadioButton male,female,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_module);
    submit=findViewById(R.id.button4);
    reset=findViewById(R.id.button5);
        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
        et4=findViewById(R.id.editText4);
        et5=findViewById(R.id.editText5);
        et8=findViewById(R.id.editText8);
        et9=findViewById(R.id.editText9);
        et10=findViewById(R.id.editText10);
        et11=findViewById(R.id.editText11);
        sp=findViewById(R.id.spinner);

         male=findViewById(R.id.radioMale);
         female=findViewById(R.id.radioFemale);
         other=findViewById(R.id.radiOther);


    }

    public void submitSignUp(View v) {

        if(et1.getText().toString().length()==0)
        {
            et1.setError("FIRSTNAME CANNOT BE BLANK");
        }
        if(et2.getText().toString().length()==0)
        {
            et2.setError("LASTNAME CANNOT BE BLANK");
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(et3.getText().toString()).matches())
        {
            et3.setError("PLEASE CHECK EMAIL ADDRESS");
        }

        if(et4.getText().toString().length() ==0 ){
            et4.setError("PLEASE FIL 10 DIGIT MOBILE NUMBER");
        }

        if(et5.getText().toString().length()==0)
        {
            et5.setError("DATE CANNOT BE BLANK");
        }


        if(et8.getText().toString().length()==0)
        {
            et8.setError("PROFESSION CANNOT BE BLANK");
        }

        if(et9.getText().toString().length()==0)
        {
            et9.setError("ADDRESS CANNOT BE BLANK");
        }

        if(et10.getText().toString().length()==0)
        {
            et10.setError("PASSWORD CANNOT BE BLANK");
        }

        if(et11.getText().toString().length()==0)
        {
            et11.setError("PASSWORD CANNOT BE BLANK");
        }




//        Intent i = new Intent();
//        startActivity(i);

    //    Toast.makeText(this, "entries can't be blank!", Toast.LENGTH_LONG).show();
        if(male.isChecked()){
            selectedGender=male.getText().toString().trim();
        }
        if(female.isChecked()){
            selectedGender=female.getText().toString().trim();
        }
        if(other.isChecked()){
            selectedGender=other.getText().toString().trim();
        }
      //  Toast.makeText(this, "selected gender is: "+selectedGender, Toast.LENGTH_SHORT).show();

        get_value_of_spinner=sp.getSelectedItem().toString().trim();
        Toast.makeText(this, "selected status is: "+get_value_of_spinner, Toast.LENGTH_SHORT).show();



         fname=et1.getText().toString().trim();
         lname=et2.getText().toString().trim();
         email=et3.getText().toString().trim();
         mobno=et4.getText().toString().trim();
         dob=et5.getText().toString().trim();
         profession=et8.getText().toString().trim();
         address=et9.getText().toString().trim();
         password=et10.getText().toString().trim();

        Toast.makeText(this, "fname"+fname+"lname"+lname+"email"+email+"mobno"+mobno+
                "dob"+dob+"gender"+selectedGender+"marritalstatus"+get_value_of_spinner+
                "profession"+profession+"address"+address+"password"+password, Toast.LENGTH_LONG).show();

        String method="register";
        if (isOnline())
        {

            Toast.makeText(this, "connection is ok", Toast.LENGTH_SHORT).show();
            Log.d("Tag","1");
            BackgroundTask backgroundTask=new BackgroundTask(this);
            backgroundTask.execute(method,fname,email,mobno,dob,selectedGender,get_value_of_spinner,profession,
                    address,password);

        }
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null && info.isConnectedOrConnecting();
    }

    public void resetSignUp(View v){
        Toast.makeText(this, "nhi krenge reset  ", Toast.LENGTH_LONG).show();
    }
/*
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioMale:
                if (checked)
                    Toast.makeText(this, "you selected"+checked, Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radioFemale:
                if (checked)
                    Toast.makeText(this, "you selected"+checked, Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radiOther:
                if (checked)
                    Toast.makeText(this, "you selected"+checked, Toast.LENGTH_SHORT).show();
                    break;
        }
    }

*/
}
