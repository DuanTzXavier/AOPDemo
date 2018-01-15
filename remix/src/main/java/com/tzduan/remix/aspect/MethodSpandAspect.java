package com.tzduan.remix.aspect;

import com.tzduan.remix.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by tzduan on 17/12/12.
 */

@Aspect
public class MethodSpandAspect {

    private static final String POINTCUT_METHOD =
            "execution(@com.tzduan.remix.annotation.MethodSpand * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithMethodSpand() {}

    @Around("methodAnnotatedWithMethodSpand()")
    public void weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.proceed();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        LogUtils.infoLog(className + methodName);
        LogUtils.infoLog(joinPoint.toLongString());
    }
}
