package me.inassar.aoplogging.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class RequestLogAspect {

/**
 * Use this method to log a specific class
 * */
//    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) && execution(public * *(..))")
//    public Object log(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
//                .currentRequestAttributes())
//                .getRequest();
//
//        Object value;
//
//        try {
//            value = proceedingJoinPoint.proceed();
//        } catch (Throwable throwable) {
//            throw throwable;
//        } finally {
//            log.info(
//                    "{} {} from {}",
//                    request.getMethod(),
//                    request.getRequestURI(),
//                    request.getRemoteAddr(),
//                    request.getHeader("user-id"));
//        }
//
//        return value;
//    }

    /**
     * Use this method to log a specific parent class and it's sub classes
     */
    @Around("within(me.inassar.aoplogging.ClassX+) && execution(public * *(..))")
    public Object log(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        Object value;

        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            log.info(
                    "{} {} from {}",
                    request.getMethod(),
                    request.getRequestURI(),
                    request.getRemoteAddr(),
                    request.getHeader("user-id"));
        }

        return value;
    }
}