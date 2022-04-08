package io.barcode.qrscan.qrcode.ui.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

import io.barcode.qrscan.qrcode.App;
import io.barcode.qrscan.qrcode.databinding.FragmentDashboardBinding;
import io.barcode.qrscan.qrcode.ui.create.link.QrCodeLinkActivity;
import io.barcode.qrscan.qrcode.ui.create.text.QrCodeTextActivity;

public class DashboardFragment extends Fragment implements AdapterApp.ItemClickListener {

    private FragmentDashboardBinding binding;
    private  DashboardViewModel dashboardViewModel;
    private AdapterApp adapterApp;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapterApp = new AdapterApp(new ArrayList<>(),this);
        binding.rvApp.setAdapter(adapterApp);
        binding.rvApp.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.rvApp.setHasFixedSize(false);
        dashboardViewModel.setApp();
        dashboardViewModel.getAppLiveData().observe(getActivity(),apps -> {
            adapterApp.setItems(apps);
        });
        binding.cardText.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), QrCodeTextActivity.class);
            startActivity(intent);
        });
        binding.cardLink.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), QrCodeLinkActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void gotoPlayStore(App app) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(app.getLink()));
        startActivity(browserIntent);
    }
}