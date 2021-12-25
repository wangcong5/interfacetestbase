package com.moon.interfacetestbase.http.appkey1.demoservice;

import com.alibaba.fastjson.JSONObject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    /**
     * GET 示例
     * 有两种传参方式：
     *
     * @return
     * @Query
     * @QueryMap
     * @Query
     */
//    @GET("api/rand.music")
//    Call<ResponseBody> getJsonData(@Query("sort") String sort, @Query("format") String format);
    @GET("api/rand.music")
    Call<ResponseBody> getJsonData(@QueryMap JSONObject jsonObject);

    @POST("api/get.qqdj")
    Call<ResponseBody> getQQDj(@QueryMap JSONObject jsonObject);

    /**
     * POST 示例
     * 有两种传参方式：
     *
     * @param jsonObject
     * @return
     * @Field 传递单个参数
     * @FieldMap 传递kv对象，当有多个不确定参数时，我们可以使用@FieldMap注解
     */
    @FormUrlEncoded
    @POST("api/rand.avatar")
    Call<ResponseBody> postData(@FieldMap JSONObject jsonObject);
}