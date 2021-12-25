package com.moon.interfacetestbase.maintool.file;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertiesUtil {
    public Properties prop = getProperties();

    public String getProperty(String property) {
        return prop.getProperty(property);
    }

    //向Properties中添加属性
    public void setProperty(String key, String value) {
        prop.setProperty(key, value);
    }

    public Properties getProperties() {
        Properties prop = new Properties();
        try {
            InputStream file = this.getClass().getClassLoader().getResourceAsStream("app.properties");
            prop.load(file);
            log.info("\n关闭文件 {}", file);
            assert file != null;
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}
