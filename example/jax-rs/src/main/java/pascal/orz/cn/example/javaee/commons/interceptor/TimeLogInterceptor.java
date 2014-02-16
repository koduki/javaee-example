/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.commons.interceptor;

import pascal.orz.cn.example.javaee.commons.utils.ApplicationLogger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import pascal.orz.cn.example.javaee.commons.annotation.TimeLog;

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
