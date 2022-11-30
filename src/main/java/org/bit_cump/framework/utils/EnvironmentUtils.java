package org.bit_cump.framework.utils;

import com.github.hardnorth.common.config.ConfigLoader;
import com.github.hardnorth.common.config.ConfigProvider;

public class EnvironmentUtils {

    public static final String URL;
    public static final String password;
    public static final String standardUser;

    private static final ConfigProvider PROVIDER = new ConfigLoader().get();

    static {
        URL = PROVIDER.getProperty("url", String.class);
        password = PROVIDER.getProperty("password", String.class);
        standardUser = PROVIDER.getProperty("standard.user", String.class);
    }
}
