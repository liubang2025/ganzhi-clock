package com.ganzhi.clock;

import android.service.dreams.DreamService;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ClockDreamService extends DreamService {
    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        // 允许点击屏幕切换深浅色主题，不会误触退出屏保
        setInteractive(true);
        // 全屏沉浸式显示，隐藏状态栏和底部导航栏
        setFullscreen(true);

        WebView webView = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        // 全屏沉浸标志
        webView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            | View.SYSTEM_UI_FLAG_FULLSCREEN
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        webView.loadUrl("file:///android_asset/index.html");
        setContentView(webView);
    }
}