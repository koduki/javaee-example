/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.commons.interceptors;

import pascal.orz.cn.example.javaee.commons.utils.ApplicationLogger;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import pascal.orz.cn.example.javaee.commons.annotations.TimeLog;

@TimeLog
@Interceptor
public class TimeLogInterceptor {

    @Inject
    transient ApplicationLogger logger;

    @AroundInvoke
    public Object methodLog(InvocationContext ic) throws Exception {
        long start = System.currentTimeMillis();
        try {
            return ic.proceed();
        } finally {
            logger.time(ic.getTarget().getClass().getSimpleName(),
                    ic.getMethod().getName(),
                    (System.currentTimeMillis() - start));
        }
    }
}
