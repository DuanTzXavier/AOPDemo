package com.tzduan.remix.aspect;

import com.tzduan.remix.LogUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by tzduan on 17/11/15.
 */

@Aspect
public class TraceAspect {

    private static final String POINTCUT_METHOD =
            "execution(@com.tzduan.remix.annotation.Trace * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithTrace() {}

    @Before("methodAnnotatedWithTrace()")
    public void weaveJoinPoint(JoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        LogUtils.infoLog(className + methodName);
    }

    @Pointcut("execution(* android.app.Activity.*(..))")
    public void logForActivity(){}  //注意，这个函数必须要有实现，否则Java编译器会报错

    @Before("logForActivity()")
    public void log(JoinPoint joinPoint){
        //对于使用Annotation的AspectJ而言，JoinPoint就不能直接在代码里得到多了，而需要通过
        //参数传递进来。
//        Log.i("123", joinPoint.toShortString());
    }

    @Pointcut("call(* android.util.Log.i(..))")
    public void androidlog(){}  //注意，这个函数必须要有实现，否则Java编译器会报错

    @Before("androidlog()")
    public void logaaa(JoinPoint joinPoint){
        LogUtils.infoLog(joinPoint.toShortString());
    }

}
