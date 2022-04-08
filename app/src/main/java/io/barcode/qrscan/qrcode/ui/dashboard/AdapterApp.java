package io.barcode.qrscan.qrcode.ui.dashboard;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import io.barcode.qrscan.qrcode.App;
import io.barcode.qrscan.qrcode.R;
import io.barcode.qrscan.qrcode.databinding.ItemMenuBinding;


public class AdapterApp extends RecyclerView.Adapter<AdapterApp.ViewHolderApp> {

    private List<App> items = new ArrayList<>();
    private int itemLayout = R.layout.item_menu;
    private ItemClickListener itemClickListener;

    public AdapterApp(List<App> items, ItemClickListener itemClickListener) {
        this.items = items;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolderApp onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderApp(ItemMenuBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolderApp holder, int position) {
        holder.bind(items.get(position));
    }

    public void setItems(List<App> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public class ViewHolderApp extends RecyclerView.ViewHolder {

        private ItemMenuBinding itemMenuBinding;

        public ViewHolderApp(ItemMenuBinding itemView) {
            super(itemView.getRoot());
            this.itemMenuBinding = itemView;
        }
        public void bind(App item) {
            itemMenuBinding.tvTitle.setText(item.getTitle());
            itemMenuBinding.getRoot().setOnClickListener(view -> {
                itemClickListener.gotoPlayStore(item);
            });
            Glide.with(itemMenuBinding.getRoot().getContext())
                    .load(item.getImage())
                    .error(R.drawable.ic_broken_image)
                    .into(itemMenuBinding.imgApp);
        }
    }

    public  interface  ItemClickListener{
        void  gotoPlayStore(App app);
    }
}