package vn.edu.hcmuaf.fit.demo.db;

import java.io.IOException;
import java.util.Properties;

public class DBPropertites {
    private static Properties prop = new Properties();

    static {
        try {
            prop.load(DBPropertites.class.getClassLoader().getResourceAsStream("db.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getDbHost(){
        return prop.get("db.host").toString();
    }
    public static String getDbPort(){
        return prop.get("db.port").toString();
    }
    public static String getDbUsername(){
        return prop.get("db.username").toString();
    }
    public static String getDbPassword(){
        return prop.get("db.password").toString();
    }
    public static String getDbname(){
        return prop.get("db.databaseName").toString();
    }
}
