package com.moon.interfacetestbase.maintool;

import com.moon.interfacetestbase.maintool.jsontool.Json2Param;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class TestBase {
    public TestBase() {
    }

    @DataProvider(
            name = "json"
    )
    public Object[][] getJsonAllCases(Method method) {
        String testJsonString = this.getTestDataFile(method, ".json");
        return Json2Param.JSON2Array(testJsonString);
    }

    /**
     * 获取指定路径下的文件路径
     *
     * @param method
     * @param postfix
     * @return
     */
    private String getTestDataFile(Method method, String postfix) {
        String packageNames = this.getClass().getPackage().getName();
        String prefix = packageNames.contains("other") ? "other" : "http";
        String className = this.getClass().getName();


        String testJsonCaseName;

        String packageName = packageNames.replace(".", "/");
        testJsonCaseName = System.getProperty("user.dir")
                + "/src/test/java/"
                + packageName + "/data/"
                + method.getName() + postfix;
        return testJsonCaseName;
    }
}
