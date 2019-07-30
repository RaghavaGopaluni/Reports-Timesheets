package com.rest.properties;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class SystemConfigProperties implements ConfigProperties {

    @Override
    public String getStringProperty(String propertyName){
        String Property = "";
        try{
            InputStream input = new FileInputStream("/Users/raghavagopaluni/Desktop/Reports-Timesheets/src/main/resources/server.com.rest.properties");
            Properties props = new Properties();
            props.load(input);
            Property = props.getProperty(propertyName);
        } catch (Exception e){
            System.out.println("The error is " + e);
        }
        return Property;
    }

    @Override
    public int getIntProperty(String propertyname){
        int Property = 0;
        try{
            InputStream input = new FileInputStream("/Users/raghavagopaluni/Desktop/Reports-Timesheets/src/main/resources/server.com.rest.properties");
            Properties props = new Properties();
            props.load(input);
            Property = Integer.parseInt(props.getProperty(propertyname));
        } catch (Exception e){
            System.out.println("The error is " + e);
        }
        return Property;
    }

}
