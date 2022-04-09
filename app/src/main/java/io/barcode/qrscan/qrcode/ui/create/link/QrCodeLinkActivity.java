package io.barcode.qrscan.qrcode.ui.create.link;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import io.barcode.qrscan.qrcode.databinding.ActivityLinkBinding;
import io.barcode.qrscan.qrcode.ui.BaseActivity;
import io.barcode.qrscan.qrcode.ui.result.DetailResultActivity;

public class QrCodeLinkActivity extends BaseActivity {

    private ActivityLinkBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLinkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.edText.setText("https://");
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

    private void barcode(){
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        try {
            Bitmap bitmap = barcodeEncoder.encodeBitmap("test",BarcodeFormat.QR_CODE,512,512);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

}