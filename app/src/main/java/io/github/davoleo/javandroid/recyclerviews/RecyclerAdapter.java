/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 09/05/2020 / 15:06
 * Class: RecyclerAdapter
 * Project: Java-Android
 * Copyright - © - Davoleo - 2020
 * ----------------------------------- */

package io.github.davoleo.javandroid.recyclerviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import net.davoleo.java_android.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AndroidVersionViewHolder> {

    private List<String> versionList;
    private int[] images = {
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.gingerbread,
            R.drawable.honeycomb,
            R.drawable.ice_cream_sandwich,
            R.drawable.jelly_bean,
            R.drawable.kitkat,
            R.drawable.lollipop,
            R.drawable.marshmallow,
            R.drawable.nougat,
            R.drawable.oreo,
            R.drawable.pie,
            R.drawable.q
    };

    public RecyclerAdapter(List<String> versionList) {
        this.versionList = versionList;
    }

    //Called to create each ViewHolder object of the RecyclerView
    @NonNull
    @Override
    public AndroidVersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = (LayoutInflater.from(parent.getContext()).inflate(R.layout.android_versions_view_holder, parent, false));

        return new AndroidVersionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AndroidVersionViewHolder holder, int position) {
        holder.title.setText(versionList.get(position));

        int imageId = images[position];
        holder.logo.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }

    public static class AndroidVersionViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView logo;

        public AndroidVersionViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.androidVersionTextView);
            logo = itemView.findViewById(R.id.androidVersionLogo);
        }
    }
}
