package com.hpe.tolet;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by Adboss on 11/22/2016.
 */

public class BackgroundTask extends AsyncTask<String,Void,String> {
    IpAddress ip;
    String method;
    Context ctx;
    String Customer_email1;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        ip=new IpAddress();
        String ipurl= ip.serverip.trim();
        Log.d("iptag",ipurl);

        String reg_url = ipurl+"tolet_register.php";

       String login_url=ipurl+"tolet_login.php";




        method = params[0];
        if (method.equals("register")) {
            String Customer_fname = params[1];
            String Customer_email = params[2];
            String Customer_mobno = params[3];
            String Customer_dob = params[4];
            String Customer_gender = params[5];
            String Customer_ms = params[6];
            String Customer_profession = params[7];
            String Customer_address = params[8];
            //String Customer_image=params[5];
            String Customer_password = params[9];
            Log.d("Tag", "in regis");
            Log.d("Tag",Customer_fname+" "+Customer_email+" "
                    +Customer_mobno+" "+Customer_dob+" "+Customer_gender+" "+Customer_ms+" "+
                    Customer_profession+" "+Customer_address+""+Customer_password);

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                //encode data before send it
                //no space permiteted in equals sign
                String data = URLEncoder.encode("Customer_fname", "UTF-8") + "=" + URLEncoder.encode(Customer_fname, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_email", "UTF-8") + "=" + URLEncoder.encode(Customer_email, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_mobno", "UTF-8") + "=" + URLEncoder.encode(Customer_mobno, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_dob", "UTF-8") + "=" + URLEncoder.encode(Customer_dob, "UTF-8") + "&" +

                        URLEncoder.encode("Customer_gender", "UTF-8") + "=" + URLEncoder.encode(Customer_gender, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_ms", "UTF-8") + "=" + URLEncoder.encode(Customer_ms, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_profession", "UTF-8") + "=" + URLEncoder.encode(Customer_profession, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_address", "UTF-8") + "=" + URLEncoder.encode(Customer_address, "UTF-8")+ "&" +
                URLEncoder.encode("Customer_password", "UTF-8") + "=" + URLEncoder.encode(Customer_password, "UTF-8")
                        ;
                //+ "&" + URLEncoder.encode("Customer_image", "UTF-8") + "=" + URLEncoder.encode(Customer_image, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                Log.d("Tag", "writer flush");
                bufferedWriter.close();
                os.close();
                //get response from server
                // Read data sent from server

                InputStream input = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                reader.close();
                input.close();
                httpURLConnection.disconnect();
                // Pass data to onPostExecute method
                return result.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (method.equals("login1")) {
          String  Customer_email = params[1];
            Customer_email1=Customer_email;
            String Customer_password = params[2];
            Log.d("Tag", "in login");

            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                //encode data before send it
                //no space permiteted in equals sign
                String data =URLEncoder.encode("Customer_email", "UTF-8") + "=" + URLEncoder.encode(Customer_email, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_password", "UTF-8") + "=" + URLEncoder.encode(Customer_password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                Log.d("Tag", "writer flush");

                bufferedWriter.close();
                os.close();
                //get response from server
                // Read data sent from server
                InputStream input = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                reader.close();
                input.close();
                httpURLConnection.disconnect();
                // Pass data to onPostExecute method
                return result.toString().trim();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
  //      Toast.makeText(ctx, "res"+result, Toast.LENGTH_SHORT).show();
        Log.d("Tag",result);
        if (result.equals("RegistrationSuccess"))
        {
           // Toast.makeText(ctx, "Welcome", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(ctx,LoginActivityOfTolet.class);
            ctx.startActivity(i);
        }
        if (result.equals("LoginSuccess"))
        {
      preferences=ctx.getSharedPreferences("MyPref",0);
      editor=preferences.edit();
     editor.putString("dealer",Customer_email1);
     editor.apply();
            Toast.makeText(ctx, "LoginWelcome"+Customer_email1, Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(ctx,IconTextTabsActivity.class);
            ctx.startActivity(intent);
        }
    }
}
