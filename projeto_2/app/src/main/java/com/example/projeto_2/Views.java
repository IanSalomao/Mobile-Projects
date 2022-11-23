package com.example.projeto_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.app.Activity;
import android.webkit.WebView;

public class Views extends AppCompatActivity {

    private ProgressBar pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cotacao_views);

        WebView web_1 = (WebView) findViewById(R.id.web_1);
        pb1 = findViewById(R.id.pb1);
        pb1.setVisibility(View.INVISIBLE);


        WebSettings w2 = web_1.getSettings();
        w2.setJavaScriptEnabled(true);

        web_1.setWebViewClient(new MyCustomWebViewClient());
        web_1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        web_1.loadUrl("https://www.infomoney.com.br/cotacoes/cripto/ativo/bitcoin-btc/");

        web_1.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap icon){
                super.onPageStarted(view, url, icon);
                pb1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url){
                super.onPageFinished(view, url);
                pb1.setVisibility(View.INVISIBLE);

            }
        });
    }
    private class MyCustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
