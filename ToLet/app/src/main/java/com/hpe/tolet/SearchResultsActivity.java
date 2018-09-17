package com.hpe.tolet;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hpe.tolet.Fragments.DataAdapter;
import com.hpe.tolet.Fragments.DataAdapter2;
import com.hpe.tolet.Fragments.GetSet;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity {
    DataAdapter2 dataAdapterb;
    DataAdapter dataAdapterr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);


        //
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, "serch query"+query, Toast.LENGTH_SHORT).show();

            showResults(query);
        }
    }

    private void showResults(String query) {
        // Query your data set and show results



    }
}


