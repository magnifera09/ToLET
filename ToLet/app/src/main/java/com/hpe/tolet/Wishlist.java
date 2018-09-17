package com.hpe.tolet;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.hpe.tolet.Fragments.DataAdapterWish;
import com.hpe.tolet.Fragments.GetSet;
import java.util.List;

public class Wishlist extends AppCompatActivity {

SharedPreference sharedPreference;
RecyclerView rv;
DataAdapterWish dataAdapter;
Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        toolbar = findViewById(R.id.toolbar);

        // set Title for Toolbar
        toolbar.setTitle("WishList"); // set logo for Toolbar
        setSupportActionBar(toolbar); // Setting/replace toolbar as the ActionBar


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sharedPreference=new SharedPreference();
        List<GetSet> list=sharedPreference.getFavorites(Wishlist.this);
        if (list ==null) {

            Toast.makeText(this, "No WishList Found", Toast.LENGTH_SHORT).show();
        }
        else
        {

            Toast.makeText(this, "size" + list.size(), Toast.LENGTH_SHORT).show();

            rv = findViewById(R.id.rv_recycler_view);
            LinearLayoutManager manager = new LinearLayoutManager(Wishlist.this);
            dataAdapter = new DataAdapterWish(Wishlist.this, list);
            rv.setHasFixedSize(true);
            rv.setLayoutManager(manager);
            rv.setAdapter(dataAdapter);
        }
    }


}
