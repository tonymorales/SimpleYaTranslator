package com.example.tony_.simpleyatranslator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tony_.simpleyatranslator.network.NetworkServiceGenerator;
import com.example.tony_.simpleyatranslator.network.response.TranslatedText;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private TextView mTextViewResult;
    private EditText mEditextToTranslate;
    private Button mButtonTranslate;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.traslation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.history_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = ((TextView) findViewById(R.id.text_result));
        mEditextToTranslate = ((EditText) findViewById(R.id.text_to_translate));

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mButtonTranslate = (Button) findViewById(R.id.button_tarnslate);
        mButtonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String translateText = mEditextToTranslate.getText().toString();

                    NetworkServiceGenerator.getApi().getTranslate(AppConfig.API_KEY, translateText, "ru", "plain").enqueue(new Callback<TranslatedText>() {
                        @Override
                        public void onResponse(Call<TranslatedText> call, Response<TranslatedText> response) {
                            if(response.code()==200){
                                mTextViewResult.setText(response.body().text.toString());
                            }

                        }

                        @Override
                        public void onFailure(Call<TranslatedText> call, Throwable t) {

                        }
                    });

             }

        });
    }
}
