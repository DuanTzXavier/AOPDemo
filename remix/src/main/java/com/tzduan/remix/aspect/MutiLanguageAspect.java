package com.tzduan.remix.aspect;

import com.tzduan.remix.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by tzduan on 17/12/12.
 */

@Aspect
public class MutiLanguageAspect {
    @Pointcut("execution(* android.widget.TextView.setText(..))")
    public void toastMakeText(){}

    @Around("toastMakeText()")
    public void toastMakeTextImp(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.proceed();
        LogUtils.infoLog(joinPoint.toLongString());
    }
}
