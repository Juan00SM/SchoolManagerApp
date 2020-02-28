package com.juansm.schoolmanager.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

import com.juansm.schoolmanager.R;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Help extends AppCompatActivity {

    public static final String HELP_KEY = "WEB_HELP";
    private static final String URL_HELP_INDEX = "https://www.google.com/";
    public static final String URL_HELP_FORM_CONTACT = "https://www.youtube.com/?gl=ES&tab=r11";
    public static final String URL_HELP_LIST_AND_SEARCH_CONTACT = "https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox";


    String TAG = "SchoolManager/Help";

    WebView webview_help;
    LinearLayout linearLayout_disconnected;
    Button buttonRetry;
    String url_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_activity_help));

        this.linearLayout_disconnected = findViewById(R.id.linearlayout_help_disconnect);
        this.buttonRetry = findViewById(R.id.retry_button_help);
        this.buttonRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnectionToInternetAndLoadURL();
            }
        });

        this.webview_help = findViewById(R.id.webview_help);
        this.webview_help.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        this.webview_help.getSettings().setJavaScriptEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.url_help = bundle.getString(HELP_KEY);
        }

        checkConnectionToInternetAndLoadURL();
    }

    private void checkConnectionToInternetAndLoadURL() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm!=null){
            if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()){
                Log.d(TAG, "Conexion Correcta");
                this.webview_help.setVisibility(LinearLayout.VISIBLE);
                this.linearLayout_disconnected.setVisibility(LinearLayout.GONE);
                if (this.url_help!=null && !this.url_help.equals("")){
                    this.webview_help.loadUrl(this.url_help);
                }else{
                    this.webview_help.loadUrl(URL_HELP_INDEX);
                }
            }else{
                Log.d(TAG, "Conexion Incorrecta");
                this.webview_help.setVisibility(LinearLayout.GONE);
                this.linearLayout_disconnected.setVisibility(LinearLayout.VISIBLE);
            }
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webview_help.canGoBack()) {
            this.webview_help.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "Entrando en onOptionsItemSelected...");
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "Ejecutando onStart...");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Ejecutando onResume...");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Ejecutando onStop...");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "Ejecutando onRestart...");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Ejecutando onPause...");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Ejecutando onDestroy...");
    }
}
