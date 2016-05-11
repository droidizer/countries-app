package com.countriesinfo.app.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

public class LocalUtils {

    public static int matchDrawable(@NonNull final Context context, @NonNull final String alphaCode) {
        return context.getResources().getIdentifier(alphaCode.toLowerCase(), "drawable", context.getPackageName());
    }

    public static String stripBrackets(@NonNull final String list) {
        return list.replaceAll("\\[", "").replaceAll("\\]", "");
    }

    public static String listToString(@NonNull final List<String> currencies) {
        StringBuilder sb = new StringBuilder();
        for (String s : currencies) {
            sb.append(s);
            if (currencies.size() > 1)
                sb.append(" , ");
        }
        return sb.toString();
    }
}
