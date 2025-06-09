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
import pascal.orz.cn.example.javaee.commons.annotations.ErrorLog;

@ErrorLog
@Interceptor
public class ErrorLogInterceptor {

    @Inject
    transient ApplicationLogger logger;

    @AroundInvoke
    public Object errorLog(InvocationContext ic) throws Exception {
        try {
            return ic.proceed();
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }
}
