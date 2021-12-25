package com.moon.interfacetestbase.maintool.http;

import com.moon.interfacetestbase.maintool.TestBase;
import com.moon.interfacetestbase.maintool.file.PropertiesUtil;
import com.moon.interfacetestbase.maintool.model.ResponseMap;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.net.SocketException;

@Slf4j
abstract public class HttpClient extends TestBase {
    public String HOST = new PropertiesUtil().getProperty("HOST");

    public ResponseMap sendRequest(Call<ResponseBody> call) {
        ResponseMap responseMap;
        Response<ResponseBody> response = null;
        try {
            response = call.execute();
        } catch (SocketException socketException) {
            if (socketException.getMessage().contains("Connection reset")) {
                log.error("retry send request {}", call.request().method());
                Call<ResponseBody> newCall = call.clone();
                try {
                    response = newCall.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response != null) {
            String url = response.raw().request().url().toString();
            ResponseBody responseBody;
            if (response.isSuccessful()) {
                responseBody = response.body();
            } else {
                responseBody = response.errorBody();
            }
            Object body = responseBody;
            try {
                assert responseBody != null;
                body = responseBody.string();
            } catch (IOException e) {
                log.info(" get body error, msg: {}", e.getMessage(), e);
            }
            responseMap = new ResponseMap(response.headers(), response.code(), response.message(), url, body.toString(), "");
        } else {
            responseMap = new ResponseMap();
        }
        return responseMap;
    }
}
