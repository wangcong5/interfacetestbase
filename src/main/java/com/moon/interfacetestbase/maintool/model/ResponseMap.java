package com.moon.interfacetestbase.maintool.model;


import okhttp3.Headers;

import java.util.Arrays;

public class ResponseMap {
    private okhttp3.Headers headers;
    private int code;
    private String message;
    private String responseBody;
    private String url;
    private String logMsg;

    public ResponseMap() {
    }

    public ResponseMap(okhttp3.Headers headers, int code, String message, String url,String responseBody, String logMsg) {
        this.headers = headers;
        this.code = code;
        this.message = message;
        this.responseBody = responseBody;
        this.url = url;
        this.logMsg = logMsg;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String... logMsg) {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(logMsg));
        this.logMsg = sb.toString();
    }
}
