package com.example.tony_.simpleyatranslator.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tony_.simpleyatranslator.R;
import com.example.tony_.simpleyatranslator.ServiceManager;
import com.example.tony_.simpleyatranslator.storage.model.Translation;

import java.util.List;


public class HistoryFragment extends Fragment {

    RecyclerView historyRecyclerView;
    List<Translation> translationList;
    HistoryRecyclerViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.history_fragment_layout, container, false);

        translationList = ServiceManager.getDaoSession().getTranslationDao().loadAll();

        historyRecyclerView = (RecyclerView) rootview.findViewById(R.id.history_list_view);
        mAdapter = new HistoryRecyclerViewAdapter(translationList);
        historyRecyclerView.setAdapter(mAdapter);


        return rootview;
    }
}
