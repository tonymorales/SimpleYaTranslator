package com.example.tony_.simpleyatranslator.UI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tony_.simpleyatranslator.AppConfig;
import com.example.tony_.simpleyatranslator.R;
import com.example.tony_.simpleyatranslator.ServiceManager;
import com.example.tony_.simpleyatranslator.network.response.TranslatedText;
import com.example.tony_.simpleyatranslator.storage.model.DaoSession;
import com.example.tony_.simpleyatranslator.storage.model.Translation;
import com.example.tony_.simpleyatranslator.storage.model.TranslationDao;

import java.text.SimpleDateFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentTranslation extends Fragment {

    private TextView mTextViewResult;
    private EditText mEditextToTranslate;
    private Button mButtonTranslate;
    private TranslationDao mTranslationDao;




    public FragmentTranslation() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment_translation, container, false);

        DaoSession daoSession = ServiceManager.getDaoSession();
        mTranslationDao = daoSession.getTranslationDao();

        mTextViewResult = ((TextView) rootView.findViewById(R.id.text_result));
        mEditextToTranslate = ((EditText) rootView.findViewById(R.id.text_to_translate));




        mButtonTranslate = (Button) rootView.findViewById(R.id.button_tarnslate);
        mButtonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String translateText = mEditextToTranslate.getText().toString();

                ServiceManager.getApi().getTranslate(AppConfig.API_KEY, translateText, "ru", "plain").enqueue(new Callback<TranslatedText>() {
                    @Override
                    public void onResponse(Call<TranslatedText> call, Response<TranslatedText> response) {
                        if(response.code()==200){
                            String[] lang = response.body().lang.split("-", 2);
                            String textResult = response.body().text.get(0);
                            mTextViewResult.setText(textResult);
                            String dateTime = new SimpleDateFormat("d MMM yyyy HH:mm:ss").toString();
                            //String dateTime = new SimpleDateFormat("d MMM yyyy HH:mm:ss").toString();
                            Translation translation = new Translation(translateText, textResult, lang[0], lang[1], 0, dateTime);
                            mTranslationDao.insert(translation);



                        }

                    }

                    @Override
                    public void onFailure(Call<TranslatedText> call, Throwable t) {

                    }
                });

            }

        });

        return rootView;
    }




}
