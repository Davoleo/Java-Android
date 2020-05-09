/* -----------------------------------
 * Author: Davoleo
 * Date / Hour: 09/05/2020 / 15:06
 * Class: RecyclerAdapter
 * Project: Java-Android
 * Copyright - © - Davoleo - 2020
 * ----------------------------------- */

package io.github.davoleo.javandroid.recyclerviews;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import net.davoleo.java_android.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AndroidVersionViewHolder> {

    private List<String> versionList;

    public RecyclerAdapter(List<String> versionList) {
        this.versionList = versionList;
    }

    //Called to create each ViewHolder object of the RecyclerView
    @NonNull
    @Override
    public AndroidVersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        TextView textView = ((TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.android_versions_view_holder, parent, false));

        return new AndroidVersionViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull AndroidVersionViewHolder holder, int position) {
        holder.versionName.setText(versionList.get(position));
    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }

    public static class AndroidVersionViewHolder extends RecyclerView.ViewHolder {

        TextView versionName;

        public AndroidVersionViewHolder(@NonNull TextView itemView) {
            super(itemView);
            versionName = itemView;
        }
    }
}
