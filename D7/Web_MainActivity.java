package com.example.webactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etSearch;
    Button btngo;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch= findViewById(R.id.etsearch);
        btngo= findViewById(R.id.btngo);
        webView= findViewById(R.id.webView);

        btngo.setOnClickListener(this);
    }


    @Override
    public void onClick(@org.jetbrains.annotations.NotNull View v) {
        switch (v.getId()) {
            case R.id.btngo:
                String url = etSearch.getText().toString();

                webView.getSettings().setJavaScriptEnabled(true);

                webView.setWebViewClient(new MyWebViewClient());
                webView.loadUrl(url);

                break;


        }

    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(@NotNull WebView view, String url) {
            // return super.shouldOverrideUrlLoading(view, url);
            view.loadUrl(url);
            return  true;
        }
    }
}
