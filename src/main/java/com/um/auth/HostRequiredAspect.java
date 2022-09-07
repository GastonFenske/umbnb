package com.um.auth;

import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.um.repositories.UserRepository;
import com.um.util.*;
import com.um.models.*;

@Component
@Aspect
public class HostRequiredAspect {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Around("@annotation(HostRequired)")
    public Object wrapper(ProceedingJoinPoint joinPoint) throws Throwable {
        try{
            // System.out.println(joinPoint.getArgs()[0] + "ARGSSS");
            String token = joinPoint.getArgs()[0].toString();
            
            User user = (User) userRepository.getUserById(Long.valueOf(jwtUtil.getKey(token)));

            if (user.getHost() == true){
                // return joinPoint.proceed();
                return new ResponseUtil("Resource get successffuly", true, 200, joinPoint.proceed());
            }
            return new ResponseUtil("Unauthorized", false, 401, null);
        }catch(Exception e){
            return new ResponseUtil("Missing Authorization Header", false, 401, null);
        }
    }
}