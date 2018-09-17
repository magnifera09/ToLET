package com.hpe.tolet;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import android.widget.Toolbar;

public class TermActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);
        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Term & Condition");
       setSupportActionBar(toolbar);
        // get our html content
        String htmlAsString = getString(R.string.tc);      //
        Spanned htmlAsSpanned = Html.fromHtml(htmlAsString); // used by TextView

        // set the html content on a TextView
        TextView textView = (TextView) findViewById(R.id.tc);
        textView.setText(htmlAsSpanned);
    }
}
