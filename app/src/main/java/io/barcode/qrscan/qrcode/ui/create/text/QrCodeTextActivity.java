package io.barcode.qrscan.qrcode.ui.create.text;


import android.content.Intent;
import android.os.Bundle;

import io.barcode.qrscan.qrcode.databinding.ActivityQrCodeTextBinding;
import io.barcode.qrscan.qrcode.ui.BaseActivity;
import io.barcode.qrscan.qrcode.ui.result.DetailResultActivity;

public class QrCodeTextActivity extends BaseActivity {

    private ActivityQrCodeTextBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQrCodeTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnSave.setOnClickListener(view -> {
            Intent intent = new Intent(this, DetailResultActivity.class);
            intent.putExtra("content", binding.edText.getText().toString());
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAfterTransition();
    }
}