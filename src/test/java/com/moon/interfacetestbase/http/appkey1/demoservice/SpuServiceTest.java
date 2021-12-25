package com.moon.interfacetestbase.http.appkey1.demoservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.moon.interfacetestbase.maintool.http.HttpService;
import okhttp3.ResponseBody;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class SpuServiceTest extends HttpService {

    /**
     * 测试GET接口
     *
     * @param preconditions
     * @param comments
     * @param request
     * @param expect
     */
    @Test(dataProvider = "json")
    public void test01(JSONObject preconditions, String comments, JSONObject request, JSONObject expect) {
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> call = apiService.getJsonData(request.getJSONObject("req"));

        try {
            Response<ResponseBody> response = call.execute();
            System.out.println("response===" + response);
            assert response.body() != null;

            String jsonStr = response.body().string();
            System.out.println("response2===" + JSON.parseObject(jsonStr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试POST接口
     *
     * @param preconditions
     * @param comments
     * @param request
     * @param expect
     */
    @Test(dataProvider = "json")
    public void test02(JSONObject preconditions, String comments, JSONObject request, JSONObject expect) {
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseBody> call = apiService.getQQDj(request.getJSONObject("req"));

        try {
            Response<ResponseBody> response = call.execute();
            System.out.println("response===" + response);
            assert response.body() != null;

            String jsonStr = response.body().string();
            System.out.println("response2===" + JSON.parseObject(jsonStr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCall2() {
        ApiService apiService = retrofit.create(ApiService.class);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sort", "男");
        jsonObject.put("format", "json");
        Call<ResponseBody> call2 = apiService.postData(jsonObject);
        try {
            Response<ResponseBody> response = call2.execute();
            System.out.println("response===" + response);
            assert response.body() != null;

            String jsonStr = response.body().string();
            System.out.println("response2===" + jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
