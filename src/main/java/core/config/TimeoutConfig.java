package core.config;

import core.constants.ConfigKeys;
import core.constants.Timeout;

public class TimeoutConfig {

    public static int shortTimeout(){
        return ConfigLoader.getInt(ConfigKeys.TIMEOUT_SHORT, Timeout.SHORT);
    }

    public static int mediumTimeout(){
        return ConfigLoader.getInt(ConfigKeys.TIMEOUT_MEDIUM, Timeout.MEDIUM);
    }

    public static int longTimeout(){
        return ConfigLoader.getInt(ConfigKeys.TIMEOUT_LONG, Timeout.LONG);
    }
}
