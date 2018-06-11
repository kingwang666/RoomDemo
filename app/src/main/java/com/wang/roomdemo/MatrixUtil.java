package com.wang.roomdemo;

import android.graphics.Matrix;

import java.math.BigDecimal;

/**
 * Author: wangxiaojie6
 * Date: 2018/4/12
 */
public class MatrixUtil {

    public static double getDegrees(float[] values) {

//        float tx = values[Matrix.MTRANS_X];
//        float ty = values[Matrix.MTRANS_Y];

// calculate real scale
//        float scalex = values[Matrix.MSCALE_X];
//        float skewy = values[Matrix.MSKEW_Y];
//        float rScale = (float) Math.sqrt(scalex * scalex + skewy * skewy);

// calculate the degree of rotation
        double degrees = Math.atan2(-values[Matrix.MSKEW_X], values[Matrix.MSCALE_X]) * (180.0 / Math.PI);
        BigDecimal bd = new BigDecimal(degrees);
        return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
