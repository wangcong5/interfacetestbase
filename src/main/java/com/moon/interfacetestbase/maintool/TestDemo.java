package com.moon.interfacetestbase.maintool;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Objects;

public class TestDemo {
    @Test
    public void mm(){
        FileInputStream file;
        System.out.println(this.getClass().getClassLoader().getResource(""));
        System.out.println(this.getClass().getResource(""));
        System.out.println(Objects.requireNonNull(this.getClass().getClassLoader().getResource("app.properties")).getPath());

        System.out.println(this.getClass().getClassLoader().getResourceAsStream("app.properties"));
    }
    public static void main(String[] args) {

    }
}
