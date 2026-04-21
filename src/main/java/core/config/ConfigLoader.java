package core.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    public static Properties properties = new Properties();
    static {

            String env = "local";
            boolean isCI = System.getenv("CI") != null;
            if (isCI) {
                env = "staging";
            }
            String fileName = "config-" + env + ".properties";
        try {
            Properties envProperties = new Properties();
            InputStream envStream = ConfigLoader.class.getClassLoader().getResourceAsStream("config/" + fileName);
            if (envStream == null) {
                throw new RuntimeException("Cannot find config file:" + fileName);
            }
            properties.load(envStream);
        } catch(Exception e){
                throw new RuntimeException("Cannot find config file:" + fileName);
            }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }

    public static int getInt(String key, int defaultValue){
        String strValue = get(key);
        return strValue != null ? Integer.parseInt(strValue) : defaultValue;
    }

}
