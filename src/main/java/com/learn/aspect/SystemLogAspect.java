package com.learn.aspect;

import com.learn.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
@Slf4j
public class SystemLogAspect {



    //Controller层切点
    @Pointcut("@annotation(com.learn.annotation.SystemControllerLog)")
    public void controllerAspect(){
    }

    //Service曾切点
    @Pointcut("@annotation(com.learn.annotation.SystemServiceLog)")
    public void serviceAspect(){
    }
    /*前置通知*/
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        String ip = IPUtils.getIpAddr(request);
        try{
            //*========控制台输出=========*//
            System.out.println("==============前置通知开始==============");
            System.out.println("请求接口" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()));
            System.out.println("方法描述：" + getControllerMethodDescription(joinPoint));
            System.out.println("请求人：" + "test");
            System.out.println("请求ip：" + ip);
        }

    }






}
