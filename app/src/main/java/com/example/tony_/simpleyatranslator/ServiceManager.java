package com.example.tony_.simpleyatranslator;


import android.app.Application;

import com.example.tony_.simpleyatranslator.network.IRestApi;
import com.example.tony_.simpleyatranslator.storage.model.DaoMaster;
import com.example.tony_.simpleyatranslator.storage.model.DaoSession;

import org.greenrobot.greendao.database.Database;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceManager extends Application{

    private static IRestApi api;
    private static DaoSession daoSession;



    @Override
    public void onCreate() {
        super.onCreate();

        //Initializing Retrofit session for API interaction
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(logging);


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConfig.BASE_URL)
                .client(httpClient.build())
                .build();
        //Initializing Dao session for Database interaction
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "translations-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        api = retrofit.create(IRestApi.class);
    }

    public static IRestApi getApi(){
        return api;
    }

    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
