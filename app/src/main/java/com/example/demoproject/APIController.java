package com.example.demoproject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIController {

    private  static  String baseUrl="https://jsonplaceholder.typicode.com/" ;

    private static APIController instance ;

    private  static Retrofit retrofit ;

    public APIController(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit=new Retrofit.Builder ()
                .baseUrl (baseUrl)
                .addConverterFactory ( GsonConverterFactory.create ())
                .client(client)
                .build ();
    }

    public static synchronized APIController getInstance(){
        if(instance==null)
            instance = new APIController();
            return instance;
    }

    public  APIset getAPIset(){
        return  retrofit.create(APIset.class);
    }
}

