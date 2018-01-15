package com.tzduan.remix.aspect;

import com.tzduan.remix.LogUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by tzduan on 17/11/16.
 */

@Aspect
public class ToastAspect {
    @Pointcut("call(* android.widget.Toast.show(..))")
    public void toastMakeText(){}

    @Around("toastMakeText()")
    public void toastMakeTextImp(ProceedingJoinPoint joinPoint){
        joinPoint.getArgs();
        LogUtils.infoLog(joinPoint.toLongString());
    }

    @Pointcut("call(* com.tzduan.remix.demo.a(..))")
    public void demo(){}

    @Before("demo()")
    public void demoa(JoinPoint joinPoint){
        joinPoint.getArgs();
        LogUtils.infoLog(joinPoint.toLongString());
    }
}
