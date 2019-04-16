package com.movie.pncinema.utils.common;

import org.springframework.lang.Nullable;

import java.util.UUID;

public class StringUtils {

    public static boolean isNullOrEmpty(@Nullable String str) {
        return str == null || "".equals(str);
    }

    public static String generateUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
