package com.countriesinfo.app.utils;

import android.support.annotation.NonNull;
import com.common.android.utils.ContextHelper;

public class LocalUtils {

    public static int matchDrawable(@NonNull String alphaCode){
        return ContextHelper.getContext().getResources().getIdentifier(alphaCode.toLowerCase() , "drawable", ContextHelper.getContext().getPackageName());
    }

    public static String stripBrackets(@NonNull final  String list) {
        return list.replaceAll("\\[", "").replaceAll("\\]","");
    }

}
