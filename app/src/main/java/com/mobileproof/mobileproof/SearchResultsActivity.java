package com.mobileproof.mobileproof;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import java.util.concurrent.ExecutionException;

public class SearchResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        handleIntent(getIntent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent){
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Client client = new Client(query);
            client.execute();
            WebView wv1=(WebView)findViewById(R.id.webView);
            wv1.getSettings().setJavaScriptEnabled(true);
            try {
                String htmlData = client.get();
                PageGenerator pg = new PageGenerator(htmlData);
                wv1.loadDataWithBaseURL("https://proofwiki.org/", pg.getHtml(), "text/html", null, null);
            } catch (InterruptedException | ExecutionException e) {
                makeSnackbar(e.getMessage());
            }
        }
    }

    private void makeSnackbar(String response){
        View view = findViewById(R.id.activity_main);
        Snackbar mySnackbar = Snackbar.make(view, response, Snackbar.LENGTH_LONG);
        mySnackbar.show();
    }
}
