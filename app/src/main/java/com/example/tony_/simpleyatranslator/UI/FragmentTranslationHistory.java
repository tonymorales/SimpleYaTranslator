package com.example.tony_.simpleyatranslator.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tony_.simpleyatranslator.R;
import com.example.tony_.simpleyatranslator.ServiceManager;

import com.example.tony_.simpleyatranslator.storage.model.DaoSession;
import com.example.tony_.simpleyatranslator.storage.model.Translation;
import com.example.tony_.simpleyatranslator.storage.model.TranslationDao;

import java.util.List;

public class FragmentTranslationHistory extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
   // private OnListFragmentInteractionListener mListener;
    private TranslationDao mTranslationDao;
    private List<Translation> mTranslations;
    private org.greenrobot.greendao.query.Query<Translation> mTranslationsQuery;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentTranslationHistory() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FragmentTranslationHistory newInstance(int columnCount) {
        FragmentTranslationHistory fragment = new FragmentTranslationHistory();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            DaoSession daoSession = ServiceManager.getDaoSession();
            mTranslationDao = daoSession.getTranslationDao();

           // mTranslations = (List<Translation>) mTranslationDao.queryBuilder().build();
            mTranslations = mTranslationDao.loadAll();

            recyclerView.setLayoutManager(new LinearLayoutManager(context));
           // recyclerView.setAdapter(new TranslationHistoryRecyclerViewAdapter(mTranslations, mListener));
        }
        return view;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onListFragmentInteraction(DummyItem item);
//    }
}
