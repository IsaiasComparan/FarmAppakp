package com.wamessage.plantapp_plantidentifier.activities;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.wamessage.plantapp_plantidentifier.AppSuperBase;
import com.wamessage.plantapp_plantidentifier.R;
import com.wamessage.plantapp_plantidentifier.fragment.PlantHealthUploadPhotoFragment;
import com.google.android.material.appbar.MaterialToolbar;


public class PlantHealthActivity extends AppSuperBase {
    FrameLayout frameLayout;
    MaterialToolbar toolbar;
    LinearLayout adContainerView;
    AdView adViewone;
    public void BannerIDCardAds() {
        adContainerView = findViewById(R.id.adsmultyViews);
        adViewone = new AdView(getApplicationContext());
        adViewone.setAdUnitId(getString(R.string.AdMob_Banner));
        adContainerView.addView(adViewone);
        BannerLoad();
        adViewone.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

            }
        });
    }
    private void BannerLoad() {
        AdRequest adRequest = new AdRequest.Builder().build();
        AdSize adSize = BannerGetSize();
        adViewone.setAdSize(adSize);
        adViewone.loadAd(adRequest);
    }
    private AdSize BannerGetSize() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;
        int adWidth = (int) (widthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }



    @Override 
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.clear();
    }

    
    @Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planthealth);
        BannerIDCardAds();
        this.toolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        this.frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override 
            public final void onClick(View view) {
                PlantHealthActivity.this.m922x3ca2e54e(view);
            }
        });
        goToUpLoadFragment();
    }

    

    public  void m922x3ca2e54e(View view) {
        finish();
    }

    public void goToUpLoadFragment() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.content_frame, new PlantHealthUploadPhotoFragment());
        beginTransaction.commit();
    }
}
