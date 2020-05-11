/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 09/05/2020 / 15:06
 * Class: RecyclerAdapter
 * Project: Java-Android
 * Copyright - © - Davoleo - 2020
 * ----------------------------------- */

package io.github.davoleo.javandroid.recyclerviews;

import android.content.Context;
import android.content.Intent;
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

    private Context context;

    public RecyclerAdapter(List<String> versionList, Context context) {
        this.versionList = versionList;
        this.context = context;
    }

    //Called to create each ViewHolder object of the RecyclerView
    @NonNull
    @Override
    public AndroidVersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = (LayoutInflater.from(parent.getContext()).inflate(R.layout.android_versions_view_holder, parent, false));

        return new AndroidVersionViewHolder(view, context, images);
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

    public static class AndroidVersionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private ImageView logo;

        private Context context;
        private int[] images;

        public AndroidVersionViewHolder(@NonNull View itemView, Context context, int[] images) {
            super(itemView);
            title = itemView.findViewById(R.id.androidVersionTextView);
            logo = itemView.findViewById(R.id.androidVersionLogo);
            itemView.setOnClickListener(this);

            this.context = context;
            this.images = images;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DisplayLogoActivity.class);
            intent.putExtra("imageId", images[getAdapterPosition()]);
            context.startActivity(intent);
        }
    }
}
