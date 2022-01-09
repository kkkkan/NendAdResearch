package com.kkkkan.nendadresearch

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.gms.ads.*
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.kkkkan.nendadresearch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        MobileAds.initialize(
            this
        ) { }


        binding.button.setOnClickListener {
            val adLoader = AdLoader.Builder(this, largeAdUnitId)
                .forNativeAd { ad: NativeAd ->
                    // Show the ad.

                    Toast.makeText(this, "広告読み込み成功", Toast.LENGTH_SHORT).show()
                    binding.header.text = ad.headline
                    binding.body.text = ad.body
                    binding.nativeAd.bodyView = binding.body
                    binding.nativeAd.headlineView = binding.header
                    binding.nativeAd.mediaView = binding.mainContent
                    binding.nativeAd.setNativeAd(ad)

                }
                .withAdListener(object : AdListener() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        // Handle the failure by logging, altering the UI, and so on.
                        Toast.makeText(
                            this@MainActivity,
                            "広告読み込み失敗 " + adError.message + " " + adError.code + " " + adError.responseInfo?.mediationAdapterClassName,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
                .withNativeAdOptions(
                    NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build()
                )
                .build()

            adLoader.loadAd(AdRequest.Builder().build())
        }
    }
}