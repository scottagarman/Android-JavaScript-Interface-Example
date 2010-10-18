package com.scottagarman.android.jsexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class JsExampleMain extends Activity {
    private WebView wv;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //create interface
        JsInterface jsInterface = new JsInterface();
        
        //get webview and enable js
        wv = (WebView) findViewById(R.id.web_view);
        wv.getSettings().setJavaScriptEnabled(true);
        
        //add interface
        wv.addJavascriptInterface(jsInterface, "android");
        
        //load file
        wv.loadUrl("file:///android_asset/test.html");
        
        init(); //does nothing atm
    }
    
    public void init(){
    	
    }
    
    //interface
    private class JsInterface{
    	public void log(String msg){
    		Log.d("MSG FROM JAVASCRIPT", msg);
    	}
    }
}