package com.tzduan.remix;

import com.tzduan.remix.annotation.Trace;

/**
 * Created by tzduan on 17/11/15.
 */

public class demo {

    public static void a(){
        b();
    }

    @Trace
    public static void b(){

    }
}
