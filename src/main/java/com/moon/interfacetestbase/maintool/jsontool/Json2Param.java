package com.moon.interfacetestbase.maintool.jsontool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class Json2Param {
    public Json2Param() {
    }

    /**
     * 将json转为 Object
     *
     * @param fileName
     * @return
     */
    public static Object[][] JSON2Array(String fileName) {
        String jsonString = readFile(fileName);
        System.out.println("====================\n"+jsonString);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        Iterator<String> iterator = jsonObject.keySet().iterator();

        List<Object[]> objects = new ArrayList<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            JSONArray jsonArray = jsonObject.getJSONArray(key);

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject caseJson = jsonArray.getJSONObject(i);

                try {
                    Object[] caseObject = new Object[]{
                            caseJson.getJSONObject("preconditions")
                            , caseJson.getString("comments")
                            , caseJson.getJSONObject("request")
                            , caseJson.getJSONObject("expect")};
                    objects.add(caseObject);
                } catch (Exception e) {
                    log.info("\n json 格式可能不正确");
                }
            }
        }

        Object[][] objects1 = new Object[objects.size()][];
        for (int i = 0; i < objects.size(); i++) {
            objects1[i] = objects.get(i);
        }

        return objects1;
    }

    /**
     * 读取文件
     *
     * @param jsonFile
     * @return
     */
    private static String readFile(String jsonFile) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileInputStream fileInputStream = new FileInputStream(jsonFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                stringBuilder.append(tempString);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

}
