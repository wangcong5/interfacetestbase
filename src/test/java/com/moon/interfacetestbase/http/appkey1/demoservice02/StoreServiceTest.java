package com.moon.interfacetestbase.http.appkey1.demoservice02;

import com.alibaba.fastjson.JSONObject;
import com.moon.interfacetestbase.maintool.http.HttpService;
import com.moon.interfacetestbase.maintool.model.ResponseMap;
import com.moon.interfacetestbase.maintool.util.AssertUtil;
import org.testng.annotations.Test;

public class StoreServiceTest extends HttpService {
    public static DemoApiService demoApiService = new DemoApiService();

    @Test(dataProvider = "json")
    public void test01(JSONObject preconditions, String comments, JSONObject request, JSONObject expect) {
        ResponseMap responseMap = demoApiService.getLocation(request.getJSONObject("req"));
        System.out.println("headers=\n"+responseMap.getHeaders());
        System.out.println("respnse=\n" + responseMap.getResponseBody());

        AssertUtil.assertEquals(expect.get("code"),responseMap.getCode(),"返回码与预期不符 ");
    }
}
