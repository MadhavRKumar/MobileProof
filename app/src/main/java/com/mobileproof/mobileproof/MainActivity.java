package com.mobileproof.mobileproof;

import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private SearchView searchView;
    private WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        // User pressed the search button
        Client client = new Client(query);
        client.execute();
        wv1=(WebView)findViewById(R.id.webView);
        wv1.getSettings().setJavaScriptEnabled(true);
        try {
            String htmlData = client.get();
            PageGenerator pg = new PageGenerator(htmlData);
            wv1.loadDataWithBaseURL("https://proofwiki.org/", pg.getHtml(), "text/html", null, null);
        } catch (InterruptedException | ExecutionException e) {
            makeSnackbar(e.getMessage());
        }
        searchView.clearFocus();
        return true;
    }
    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }


    private void makeSnackbar(String response){
        View view = findViewById(R.id.activity_main);
        Snackbar mySnackbar = Snackbar.make(view, response, Snackbar.LENGTH_LONG);
        mySnackbar.show();
    }

}
