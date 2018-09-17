package com.hpe.tolet.Fragments;


import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hpe.tolet.IconTextTabsActivity;
import com.hpe.tolet.IpAddress;
import com.hpe.tolet.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class RentFragment extends Fragment implements SearchView.OnQueryTextListener{
    IpAddress ip;
Context ctx;
    IconTextTabsActivity iconTextTabsActivity;
    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    RecyclerView rv;
    DataAdapter dataAdapter;
    List<GetSet> data;
    public RentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new ArrayList<>();

        iconTextTabsActivity= (IconTextTabsActivity) getActivity();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ctx=getActivity();
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_rent, container, false);
        new AsyncFetch().execute();


        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(TAG, "Tag" + newText);
        final List<GetSet> filteredModelList = filter(data, newText);
        rv.setLayoutManager(new LinearLayoutManager(iconTextTabsActivity));
        dataAdapter = new  DataAdapter( iconTextTabsActivity,filteredModelList);
        dataAdapter.notifyDataSetChanged();
        rv.setAdapter(dataAdapter);
        // itemCount.setTitle("("+filteredModelList.size() + ")");
        return true;

    }
    private List<GetSet> filter(List<GetSet> models, String query) {
        query = query.toLowerCase();
        final List<GetSet> filteredModelList = new ArrayList<>();
        for (GetSet model : models) {
            final String text = model.getPaddress().toLowerCase();
            if (text.contains(query)) {

                filteredModelList.add(model);
            }

        }
        return filteredModelList;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                      //  adapter.setFilter(mCountryModel);
                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        // Do something when expanded
                        searchView.setQueryHint("Enter Location");
                        searchView.clearFocus();
                        searchView.isSubmitButtonEnabled();
                        searchView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        searchView.getMaxWidth();
                        searchView.getQuery();
                        return true; // Return true to expand action view
                    }
                });
    }

    private class  AsyncFetch extends AsyncTask<String, String, String> {
//        ProgressDialog pdLoading = new ProgressDialog(ctx);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
         //   pdLoading.setMessage("\tLoading...");
          //  pdLoading.setCancelable(false);
        //    pdLoading.show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                ip=new IpAddress();
                String ipurl= ip.serverip.trim();
                Log.d("iptag",ipurl);

                // Enter URL address where your json file resides
                // Even you can make call to php file which returns json data
               // url = new URL("http://192.168.43.7/script/alldata_ad.php");
                url = new URL(ipurl+"alldata_ad.php");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return e.toString();
            }
            try {

                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("GET");

                // setDoOutput to true as we recieve data from json file
                conn.setDoOutput(true);

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return e1.toString();
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread

            //pdLoading.dismiss();
              data=new ArrayList<>();

           // pdLoading.dismiss();
            try {
                Log.d("TAG", result);
                JSONArray jArray = new JSONArray(result);
          //      Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
                Log.d("TAG", String.valueOf(jArray));
                // Extract data from json and store into ArrayList as class objects
                for (int i = 0; i < jArray.length(); i++) {

                    JSONObject json_data = jArray.getJSONObject(i);
                   GetSet getSet=new GetSet();

                    getSet.setTop(json_data.getString("top"));
                    getSet.setTopr(json_data.getString("topr"));
                    getSet.setPaddress(json_data.getString("paddress"));
                    getSet.setPpricerange(json_data.getString("ppricerange"));
                    getSet.setPdetails(json_data.getString("pdetails"));
                    getSet.setPphoneno(json_data.getString("pphoneno"));
                    getSet.setPownername(json_data.getString("pownername"));
                    getSet.setSelectedPermissionsRadio(json_data.getString("selectedPermissionsRadio"));
                    getSet.setImagepath1(json_data.getString("imagepath").trim());

                    //
                    Log.d("TAG","Server result"+""+json_data.getString("top")+""+json_data.getString("topr")+""+json_data.getString("paddress")+
                            json_data.getString("ppricerange")+""+ json_data.getString("pdetails")+""+json_data.getString("pphoneno")
                        +""+json_data.getString("pownername")+""+json_data.getString("selectedPermissionsRadio")+"image"+json_data.getString("imagepath"));
                    data.add(getSet);

                }
                rv = getView().findViewById(R.id.rv_recycler_view);
                dataAdapter = new DataAdapter(ctx,data);
                rv.setAdapter(dataAdapter);
                rv.setLayoutManager(new LinearLayoutManager(getContext()));

                // Setup and Handover data to recyclerview
                //     mRVFishPrice = (RecyclerView)findViewById(R.id.fishPriceList);
                //     dataAdapter2 = new AdapterFish(MainActivity.this, data);
                //   mRVFishPrice.setAdapter(dataAdapter2);
                //  mRVFishPrice.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            } catch (JSONException e) {
                Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
            }

        }


    }
}