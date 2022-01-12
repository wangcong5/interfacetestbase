package com.moon.interfacetestbase.http.appkey1.demoservice02;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.moon.interfacetestbase.maintool.http.HttpService;
import com.moon.interfacetestbase.maintool.model.ResponseMap;
import com.moon.interfacetestbase.maintool.util.AssertUtil;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CSDNServiceTest extends HttpService {
    public static DemoApiService demoApiService = new DemoApiService();

    /**
     * 网易云音乐随机歌曲:
     * https://api.uomg.com/doc-rand.music.html
     *
     * @param preconditions
     * @param comments
     * @param request
     * @param expect
     */
    @Test(dataProvider = "json")
    public void testGetMusic(JSONObject preconditions, String comments, JSONObject request, JSONObject expect) {
        ResponseMap responseMap = demoApiService.getLocation(request.getJSONObject("req"));
        JSONObject resp = JSON.parseObject(responseMap.getResponseBody());
        System.out.println(resp);
        AssertUtil.assertEquals(expect.get("code"), responseMap.getCode(), "返回码与预期不符 ");
    }

    /**
     * 发表评论
     *
     * @param preconditions
     * @param comments
     * @param request
     * @param expect
     */
    @Test(dataProvider = "json")
    public void postComment(JSONObject preconditions, String comments, JSONObject request, JSONObject expect) {
        Map<String, Object> headMap = new HashMap<>();
        headMap.put("cookie", "UserName=wan_zaiyunduan;UserToken=919a956ecd944f3ea49042da903453b6;");

        ResponseMap responseMap = demoApiService.postComment(request.getJSONObject("req"), headMap);
        System.out.println("response=\n" + responseMap.getResponseBody());

//        AssertUtil.assertEquals(expect.get("code"), responseMap.getCode(), "返回码与预期不符 ");
    }
}
