package io.barcode.qrscan.qrcode.ui.create.link;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import io.barcode.qrscan.qrcode.databinding.ActivityLinkBinding;
import io.barcode.qrscan.qrcode.ui.BaseActivity;

public class QrCodeLinkActivity extends BaseActivity {

    private ActivityLinkBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLinkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAfterTransition();
    }
}