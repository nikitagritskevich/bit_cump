package org.bit_cump.framework.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtils {

    public static String convertCartNameToXpathFormat(String cartName) {
        String copyCartName= new String(cartName);
        return copyCartName.toLowerCase()
                .replace(" ", "-");
    }

    public static String randomString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }
}
