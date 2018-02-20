package com.npkompleet.phenomenon.bowser.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Random;

/**
 * Created by PHENOMENON on 1/26/2018.
 */

public class Utils {
    public static final Random RANDOM= new Random();

    public static float convertDpToPixel(float dp, Context context){
        Resources res= context.getResources();
        DisplayMetrics metrics= res.getDisplayMetrics();
        float px = dp*((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

//    public static int randInt(int min, int max){
//        int randomNum= RANDOM.nextInt((max-min))
//    }

}
