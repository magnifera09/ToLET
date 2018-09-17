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
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class PostSellModule extends AppCompatActivity {
    Button b6, b7, b8, b9;
    EditText et12, et13, et15, et16, et17, et18;
    RadioButton flat, pg, hostel, otherr,  owner;
    ImageButton im;
    LinearLayout ll;
    String typeofproperty="sell", selectedProertyTypeRadio, selectedPermissionsRadio,
            selectedPosterRadio, pownername, pphoneno, pdetails, ppricerange,
            paddress;
    ImageView iv;
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    String encodedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_sell_module);

        iv=findViewById(R.id.ivpostad);

        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);


        et12 = findViewById(R.id.editText12);
        et13 = findViewById(R.id.editText13);
        et15 = findViewById(R.id.editText15);
        et16 = findViewById(R.id.editText16);
        et17 = findViewById(R.id.editText17);

        flat = findViewById(R.id.radioButton4);
        pg = findViewById(R.id.radioButton6);
        hostel = findViewById(R.id.radioButton7);
        otherr = findViewById(R.id.radioButton8);




        im = findViewById(R.id.imageButton);
        ll = findViewById(R.id.LinearLayoutCustomId);

      //  ll.setVisibility(View.INVISIBLE);
    }


    public void rentChooser(View v) {

        ll.setVisibility(View.VISIBLE);
        typeofproperty = "Sell";


    }

    public void submitPostAd(View v){
        if (et12.getText().toString().length() == 0) {
            et12.setError("ADDRESS CANNOT BE BLANK");
        }
        if (et13.getText().toString().length() == 0) {
            et13.setError("PRICE RANGE CANNOT BE BLANK");
        }

        if (et15.getText().toString().length() == 0) {
            et15.setError("PLEASE FILL DETAILS");
        }

        if (et16.getText().toString().length() == 0) {
            et16.setError("PLEASE ENTER MOBILE NUMBER");
        }


        if (et17.getText().toString().length() == 0) {
            et17.setError("PLEASE ENTER OWNER NAME");
        }




        if (flat.isChecked()) {
            selectedProertyTypeRadio = flat.getText().toString().trim();
        }
        if (pg.isChecked()) {
            selectedProertyTypeRadio = pg.getText().toString().trim();
        }
        if (hostel.isChecked()) {
            selectedProertyTypeRadio = hostel.getText().toString().trim();
        }
        if (otherr.isChecked()) {
            selectedProertyTypeRadio = otherr.getText().toString().trim();
        }
        else if (selectedProertyTypeRadio==null)
        {
            Toast.makeText(this, "SelectProperty type", Toast.LENGTH_SHORT).show();
        }


   else if (encodedImage==null)
        {
            Toast.makeText(this, "Capture Image", Toast.LENGTH_SHORT).show();

        }

        else {
            Toast.makeText(this, "All field Checked", Toast.LENGTH_SHORT).show();


            paddress = et12.getText().toString().trim();
            ppricerange = et13.getText().toString().trim();
            pdetails = et15.getText().toString().trim();
            pphoneno = et16.getText().toString().trim();
            pownername = et17.getText().toString().trim();


     /*   Toast.makeText(this, "type" + typeofproperty + "1property" + selectedProertyTypeRadio +
                "2address" + paddress + "3price" + ppricerange + "4details" + pdetails +
                "5phone" + pphoneno + "6owner" + pownername + "7permissions" + selectedPermissionsRadio +
                 "8postingas" + selectedPosterRadio+"image::::", Toast.LENGTH_LONG).show();
                 */
            Log.d("sell", "type" + typeofproperty + "1property" + selectedProertyTypeRadio +
                    "2address" + paddress + "3price" + ppricerange + "4details" + pdetails +
                    "5phone" + pphoneno + "6owner" + pownername +
                    "8postingas" + selectedPosterRadio + "image::::" + encodedImage);

            String method = "postregister";
            if (isOnline()) {

                Toast.makeText(this, "connection is ok", Toast.LENGTH_SHORT).show();
                Log.d("Tag", "1");
                BackgroundTaskPostSell backgroundTaskPostSell = new BackgroundTaskPostSell(this);
                backgroundTaskPostSell.execute(method, typeofproperty, selectedProertyTypeRadio, paddress, ppricerange,
                        pdetails, pphoneno, pownername, encodedImage);

            }
        }

    }





    public void sellChooser(View v){
        ll.setVisibility(View.VISIBLE);
        typeofproperty = "Sell";





    }



    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null && info.isConnectedOrConnecting();
    }




    public void takePicture(View View) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//MediaStore is type of dtabse whwere image and video storeed.
      /*  imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Test.jpg");//directory path and file name two argument in file
        Toast.makeText(LabourRegistration.this, "Picture Clicked" + imageFile, Toast.LENGTH_SHORT).show();

        //generate path Uri
        Uri value = Uri.fromFile(imageFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, value);//Extraoutput show path for saving file
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);//define image quality 0 for low and 1 for high quality
        */
        startActivityForResult(intent, 0);
    }

/*
    public void browseImage(View v) {

// Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryIntent.setType("image/*");
        galleryIntent.putExtra("crop", "true");
        galleryIntent.putExtra("outputX", 200);
        galleryIntent.putExtra("outputY", 260);
        galleryIntent.putExtra("aspectX", 1);
        galleryIntent.putExtra("aspectY", 1);
        galleryIntent.putExtra("scale", true);
        galleryIntent.putExtra("return-data", true);
// Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);


    }
*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (requestCode == 0) {
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        // Toast.makeText(this, "Picture saved at " + imageFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                        Toast.makeText(PostSellModule.this, "ImageSet", Toast.LENGTH_SHORT).show();
                        iv.setImageBitmap(thumbnail);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        if (thumbnail != null) {
                            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object//0 for low quality
                        }
                        byte[] b = baos.toByteArray();
                        encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
                        Toast.makeText(PostSellModule.this, "Wait for moment ...."+encodedImage, Toast.LENGTH_SHORT).show();
                        break;

                    case Activity.RESULT_CANCELED:
                        Toast.makeText(this, "Activity.RESULT_CANCELLED", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;


                }

            }//onActivityCamera-END
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                if (cursor != null) {
                    cursor.moveToFirst();
                }

                int columnIndex = 0;
                if (cursor != null) {
                    columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                }
                if (cursor != null) {
                    imgDecodableString = cursor.getString(columnIndex);
                }
                if (cursor != null) {
                    cursor.close();
                }
                // Set the Image in ImageView after decoding the String
                iv.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));
                //imageUploadSTART

                Bitmap bm = BitmapFactory.decodeFile(imgDecodableString);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object//0 for low quality
                byte[] b = baos.toByteArray();
                encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
                Toast.makeText(PostSellModule.this, "ImageSet", Toast.LENGTH_SHORT).show();
                Toast.makeText(PostSellModule.this, "Wait for moment ....", Toast.LENGTH_SHORT).show();
                Log.d("error", "images" + encodedImage);
                //close
            }
        } catch (Exception e) {
            Toast.makeText(this, "Problem Detected!", Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PostSellModule.this,PostTypeChooser.class));
    }
}
