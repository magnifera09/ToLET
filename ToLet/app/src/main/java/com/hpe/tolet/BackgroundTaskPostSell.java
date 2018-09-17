package com.hpe.tolet;


import android.content.Context;
import android.content.Intent;
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

public class BackgroundTaskPostSell extends AsyncTask<String,Void,String> {
    IpAddress ip;
    String method;
    Context ctx;
    public BackgroundTaskPostSell(Context ctx)
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
        //String reg_url = "http://192.168.43.147/script/tolet_postad.php";
        String reg_url = ipurl+"tolet_postsell.php";


        method = params[0];
        if (method.equals("postregister")) {
            String Customer_typeofproperty = params[1];
            String Customer_selectedProertyTypeRadio = params[2];
            String Customer_paddress = params[3];
            String Customer_ppricerange = params[4];
            String Customer_pdetails = params[5];
            String Customer_pphoneno = params[6];
            String Customer_pownername = params[7];
            String Customer_image=params[8];
            //String Customer_password = params[10];
            Log.d("Tag", "in regis");
            Log.d("Tag",Customer_typeofproperty+" "+Customer_selectedProertyTypeRadio+" "
                    +Customer_paddress+" "+Customer_ppricerange+" "+Customer_pdetails+" "+Customer_pphoneno+" ");

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                //encode data before send it
                //no space permiteted in equals sign
                String data = URLEncoder.encode("Customer_typeofproperty", "UTF-8") + "=" + URLEncoder.encode(Customer_typeofproperty, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_selectedProertyTypeRadio", "UTF-8") + "=" + URLEncoder.encode(Customer_selectedProertyTypeRadio, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_paddress", "UTF-8") + "=" + URLEncoder.encode(Customer_paddress, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_ppricerange", "UTF-8") + "=" + URLEncoder.encode(Customer_ppricerange, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_pdetails", "UTF-8") + "=" + URLEncoder.encode(Customer_pdetails, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_pphoneno", "UTF-8") + "=" + URLEncoder.encode(Customer_pphoneno, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_pownername", "UTF-8") + "=" + URLEncoder.encode(Customer_pownername, "UTF-8") + "&" +
                        URLEncoder.encode("Customer_image", "UTF-8") + "=" + URLEncoder.encode(Customer_image, "UTF-8");

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




        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Toast.makeText(ctx, "res"+result, Toast.LENGTH_SHORT).show();
        if (result.equals("UploadSuccess"))
        {
            Toast.makeText(ctx, "Maze Kro", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(ctx,IconTextTabsActivity.class);
            ctx.startActivity(intent);
        }

    }
}
