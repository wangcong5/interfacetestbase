package com.moon.interfacetestbase.maintool.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpService extends HttpClient {
    public HttpService() {

    }

    /**
     * 创建 Retrofit 实例对象
     */
    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
