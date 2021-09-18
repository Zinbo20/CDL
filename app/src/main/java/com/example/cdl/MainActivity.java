package com.example.cdl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    WebView webView;
    Button bt;
    ImageButton bt2;
    TextView tv;
    ImageView i;
    boolean count =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.button);
        bt2 = (ImageButton) findViewById(R.id.imageButton);
        webView = (WebView) findViewById(R.id.webview);
        tv = (TextView) findViewById(R.id.textView4);
        i = (ImageView) findViewById(R.id.imageView);

        readLoadUrl();
        readUrlon();
        readUrloff();

        tv.setText("Desconectado");
        webView.loadUrl(MainActivity2.LoadUrl);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                tv.setText("");
                bt.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(count) {
                            webView.loadUrl(MainActivity2.Urloff);
                            webView.setWebViewClient(new WebViewClient() {
                                @Override
                                public void onPageFinished(WebView view, String url) {
                                    super.onPageFinished(view, url);
                                    count = false;
                                    i.setImageResource(R.drawable.lambada_off);
                                }
                            });
                        }
                        if(!count) {
                            webView.loadUrl(MainActivity2.Urlon);
                            webView.setWebViewClient(new WebViewClient() {
                                @Override
                                public void onPageFinished(WebView view, String url) {
                                    super.onPageFinished(view, url);
                                    count = true;
                                    i.setImageResource(R.drawable.lampada_on);
                                }
                            });
                        }



                    }
                });




            }
        });





        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });







    }


    private void readLoadUrl() {
        SharedPreferences sharedPreferences = getSharedPreferences("readLoadUrl", Context.MODE_PRIVATE);
        String var = sharedPreferences.getString("readLoadUrl", "");
        if (var != "") {
            MainActivity2.LoadUrl = var;
        }
    }

    private void readUrlon() {
        SharedPreferences sharedPreferences = getSharedPreferences("readUrlon", Context.MODE_PRIVATE);
        String var = sharedPreferences.getString("readUrlon", "");
        if (var != "") {
            MainActivity2.Urlon = var;
        }
    }


    private void readUrloff() {
        SharedPreferences sharedPreferences = getSharedPreferences("readUrloff", Context.MODE_PRIVATE);
        String var = sharedPreferences.getString("readUrloff", "");
        if (var != "") {
            MainActivity2.Urloff = var;
        }
    }

}