package io.barcode.qrscan.qrcode.ui.create.text;


import android.os.Bundle;

import io.barcode.qrscan.qrcode.databinding.ActivityQrCodeTextBinding;
import io.barcode.qrscan.qrcode.ui.BaseActivity;

public class QrCodeTextActivity extends BaseActivity {

    private ActivityQrCodeTextBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQrCodeTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAfterTransition();
    }
}