/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

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
