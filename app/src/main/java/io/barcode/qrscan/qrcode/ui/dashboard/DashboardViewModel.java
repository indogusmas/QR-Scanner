package io.barcode.qrscan.qrcode.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.barcode.qrscan.qrcode.App;

public class DashboardViewModel extends ViewModel {

    private   MutableLiveData<List<App>> listMutableLiveDataApp = new MutableLiveData<>();


    public  void setApp(){
        List<App> appList = new ArrayList<>();
        appList.add(new App("Save Status-Story for WhatsApp","https://res.cloudinary.com/dev-indo/image/upload/v1649383610/app/unnamed-3_odyynh.png","https://bit.ly/3imbfRZ"));
        appList.add(new App("Sound Animal","https://res.cloudinary.com/dev-indo/image/upload/v1649383609/app/unnamed_s6e7sr.png","https://bit.ly/3NCF9jg"));
        appList.add(new App("Screen Recorder","https://res.cloudinary.com/dev-indo/image/upload/v1649383609/app/unnamed-2_fxdeu4.png","https://bit.ly/3q38nOc"));
        appList.add(new App("Signature Digital","https://res.cloudinary.com/dev-indo/image/upload/v1649383609/app/unnamed-4_oetaht.png","https://bit.ly/3HgLjC4"));
        appList.add(new App("Compress Image","https://res.cloudinary.com/dev-indo/image/upload/v1649384743/app/unnamed-5_bdrybq.png","https://bit.ly/34mI8ul"));
        listMutableLiveDataApp.setValue(appList);
    }

    public  LiveData<List<App>> getAppLiveData(){
        return listMutableLiveDataApp;
    }
}