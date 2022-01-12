package com.moon.interfacetestbase.maintool.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnirestUtil {
    /**
     * get请求
     * CSDN粉丝列表
     *
     * @return
     */
    public static JSONObject getRequest() {
        HttpResponse<String> httpResponse = Unirest.get("https://blog.csdn.net/community/home-api/v2/get-fans-list")
                // 设置header
                .header("Accept", "application/json")
                .header("x-custom-header", "hello")
                .header("Cookie", "xxx")
                // Basic Authentication
//                .basicAuth("username", "password!")

                // 设置请求参数
                .queryString("page", 1)
                .queryString("pageSize", 20)
                .queryString("id", 0)
                .queryString("noMore", false)
                .queryString("blogUsername", "wan_zaiyunduan")
                .asString();

        log.info("\n GET查询结果：{}", httpResponse.getBody());
        return JSON.parseObject(httpResponse.getBody());
    }

    /**
     * post接口：
     * 提交CSDN评论
     *
     * @return
     */
    public static HttpResponse<JsonNode> PostRequest() {
        HttpResponse<JsonNode> response = Unirest.post("https://blog.csdn.net/phoenix/web/v1/comment/submit")
                .header("cookie", "UserName=wan_zaiyunduan; UserToken=919a956ecd944f3ea49042da903453b6;")

                .field("content", "%E5%97%AF%E5%97%AF%EF%BC%8C%E5%A5%BD%E8%B0%88")
                .field("articleId", "121876998")
                .asJson();

        log.info("\nPOST请求结果为:{}", response.getBody());
        return response;
    }

    //测试
    public static void main(String[] args) {
        PostRequest();
        getRequest();
    }
}
