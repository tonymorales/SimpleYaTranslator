package com.example.tony_.simpleyatranslator.UI;

import android.support.design.widget.CheckableImageButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tony_.simpleyatranslator.R;
import com.example.tony_.simpleyatranslator.storage.model.Translation;

import java.util.List;


public class HistoryRecyclerViewAdapter extends Adapter<HistoryRecyclerViewAdapter.ViewHolder> {
    private List<Translation> records;

    public HistoryRecyclerViewAdapter(List<Translation> records) {
        this.records = records;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list_item_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Translation record = records.get(position);
        holder.languageTextView.setText(record.getLangFrom() + "-" + record.getLangTo());
        holder.textToTextView.setText(record.getTextResult());
        holder.textFromTextView.setText(record.getTextFrom());
        holder.favoritesImageButton.setChecked(record.getFavorite() == 1);

    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        CheckableImageButton favoritesImageButton;
        TextView textFromTextView;
        TextView textToTextView;
        TextView languageTextView;
        //protected Translation mItem;



        private ViewHolder(View itemView) {
            super(itemView);
            favoritesImageButton = (CheckableImageButton) itemView.findViewById(R.id.favorites_image_button);
            textFromTextView = (TextView) itemView.findViewById(R.id.text_from_text_view);
            textToTextView = (TextView) itemView.findViewById(R.id.text_to_text_view);
            languageTextView = (TextView) itemView.findViewById(R.id.language_text_view);

        }
    }
}
