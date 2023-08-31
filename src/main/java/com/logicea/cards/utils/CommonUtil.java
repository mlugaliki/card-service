package com.logicea.cards.utils;

import org.springframework.util.ObjectUtils;

public class CommonUtil {
    public static boolean validateEmpty(Object name) {
        if (ObjectUtils.isEmpty(name)) {
            return false;
        }

        return true;
    }

    public static boolean validateColour(String colour) {
        if (ObjectUtils.isEmpty(colour)) {
            return true;
        }

        if (!colour.contains("#") || colour.length() != 7 || !colour.substring(0, 1).equalsIgnoreCase("#")) {
            return false;
        }

        return true;
    }
}
