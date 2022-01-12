package com.moon.interfacetestbase.http.appkey1.demoservice02;

import com.alibaba.fastjson.JSONObject;
import com.moon.interfacetestbase.maintool.http.HttpService;
import com.moon.interfacetestbase.maintool.model.ResponseMap;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public class DemoApiService extends HttpService {

    public interface ApiServices {
        @GET("api/rand.music")
        Call<ResponseBody> getLocation2(@QueryMap JSONObject jsonObject);

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

        @FormUrlEncoded
        @Headers({"cookie:UserName=wan_zaiyunduan;UserToken=919a956ecd944f3ea49042da903453b6;"})
        @POST("phoenix/web/v1/comment/submit")
        Call<ResponseBody> postComment(@FieldMap JSONObject jsonObject, @HeaderMap Map<String,Object> headerMap);
    }

    public ResponseMap getLocation(JSONObject request) {
        ApiServices apiServices = retrofit.create(ApiServices.class);
        Call<ResponseBody> call = apiServices.getLocation2(request);
        return sendRequest(call);
    }

    public ResponseMap postComment(JSONObject request, Map<String,Object> map ){
        ApiServices apiServices = retrofit.create(ApiServices.class);
        Call<ResponseBody> call = apiServices.postComment(request,map);
        return sendRequest(call);
    }
}
