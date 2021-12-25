package com.moon.interfacetestbase.http.appkey1.demoservice02;

import com.alibaba.fastjson.JSONObject;
import com.moon.interfacetestbase.maintool.http.HttpService;
import com.moon.interfacetestbase.maintool.model.ResponseMap;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public class DemoApiService extends HttpService {

    public interface ApiServices {
        @GET("ws/location/v1/ip")
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
    }

    public ResponseMap getLocation(JSONObject request) {
        ApiServices apiServices = retrofit.create(ApiServices.class);
        Call<ResponseBody> call = apiServices.getLocation2(request);
        return sendRequest(call);
    }
}
