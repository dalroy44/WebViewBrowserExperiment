package com.webview.demo.webview;

import android.webkit.WebViewClient;
import android.webkit.WebView;
import android.webkit.WebResourceRequest;
import android.content.Intent;
import android.net.Uri;
/**
 * Created by alroy.dsouza on 11/27/2016.
 */

public class MyAppWebViewClient extends WebViewClient {

    public static String url = null;

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        url = view.getUrl();
        if(Uri.parse(url).getHost().endsWith("google.com")) {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.loadUrl(url);
        view.getContext().startActivity(intent);
        return true;
    }
}
