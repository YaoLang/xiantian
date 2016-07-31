package com.sunshine.expsystem.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.security.Signature;


/**
 * 业务耗时计算
 * Created by kong on 16/7/28.
 */
@Component
@Aspect
public class WasteTimeAspect {

    @Around(value = "execution(* com.sunshine.expsystem.service.*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        long started = System.currentTimeMillis();
        result = pjp.proceed();
        long ended = System.currentTimeMillis();

        System.out.println("@AfterReturning：目标方法为：" +
                pjp.getSignature().getDeclaringTypeName() +
                "." + pjp.getSignature().getName()+" waste time:"+(ended-started));


        return result;
    }
}
