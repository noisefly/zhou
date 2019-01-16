package com.itheima.ssm.log;

import com.itheima.domain.SysLog;
import com.itheima.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * idea  你已经是一个成熟的软件了 !
 * 应该学会自己写代码,Debug了.....
 *
 * @Auther: ZhouFan
 * @Date: 2019/1/13 14:44
 * @maxim: There is no shortcut in life
 * @emmm: 这是一段会说话的代码!
 */

@Component
@Aspect
public class LogAop {

    @Autowired
//    需要在web.xml中配置监听器  RequestContextServlet
    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;

    private Date visitStart;
    private Class clazz;
    private Method method;


    //定义切入点,方法名称就是切入点id
    @Pointcut("execution(* com.itheima.ssm.controller.*.*(..))")
    public void logPointCut(){};


    //    前置通知
//    @Before("execution(* com.itheima.ssm.controller.*.*(..))")
    @Before("logPointCut()")//引切入点
    public void doAfter(JoinPoint joinPoint) {
        try {
            visitStart = new Date();//当前时间
            clazz = joinPoint.getTarget().getClass();//获取访问的类
            String methodName = joinPoint.getSignature().getName();//获取访问的方法名
            Object[] args = joinPoint.getArgs();//获取访问的方法参数

//        通过反射获取具体执行方法的Method对象
            if (args == null || args.length == 0) {
                //            无参方法对象
                method = clazz.getMethod(methodName);
            } else {
                Class[] classArgs = new Class[args.length];
                //            获取参数
                for (int i = 0; i < args.length; i++) {
//                    原方法中Model 为接口  使用的为实现类 通过反射获得是BindingAwareModelMap
                    if (args[i] instanceof Model){
                        classArgs[i]=Model.class;
                        continue;
                    }
                    if (args[i] instanceof List){
                        classArgs[i]=List.class;
                        continue;
                    }
                    classArgs[i] = args[i].getClass();
                }
                //            带参方法对象
                method = clazz.getMethod(methodName, classArgs);

            }
        } catch (Exception e) {
            System.out.println("************"+e.getMessage());
        }

    }


    //    后置通知
//    @After("execution(* com.itheima.ssm.controller.*.*(..))")
    @After("logPointCut()")//引切入点
    public void doAfter() {
        try {
            String url="";
            long time = new Date().getTime() - visitStart.getTime();
//        获取访问ip
            String ip = request.getRemoteAddr();

            //          获取当前用户名
//        1.从上下文中获取登录的用户对象
            SecurityContext context= SecurityContextHolder.getContext();
            User principal = (User) context.getAuthentication().getPrincipal();
            String  username = principal.getUsername();
//       User user = (User) request.getSession().getAttribute("spring_security_context");


//        获取url
//         url = request.getRequestURI();
            if (clazz != null && method != null && clazz != LogAop.class) {
    //            1,获取类上的 注解 的value值
                RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
                if (clazzAnnotation != null) {
                    String[] classValue = clazzAnnotation.value();
    //                2.获取方法上的 value值
                    RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                    if (methodAnnotation != null) {
                        String[] methodValue = methodAnnotation.value();

                        url=classValue[0]+methodValue[0];

                        SysLog sysLog = new SysLog();
                        sysLog.setExecutionTime(time);
                        sysLog.setIp(ip);
                        sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
                        sysLog.setUrl(url);
                        sysLog.setUsername(username);
                        sysLog.setVisitTime(visitStart);
                        System.out.println(sysLog);

    //                    保存日志
                        sysLogService.save(sysLog);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("************"+e.getMessage());
        }
    }
}
