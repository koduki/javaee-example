/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee;

import java.io.IOException;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 *
 * @author koduki
 */
public class DefaultExceptionHandler extends ExceptionHandlerWrapper {

    private final ExceptionHandler wrapped;

    public DefaultExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void handle() {
        for (Iterator<ExceptionQueuedEvent> it
                = getUnhandledExceptionQueuedEvents().iterator(); it.hasNext() == true;) {

            ExceptionQueuedEventContext eventContext = it.next().getContext();
            FacesContext facesContext = eventContext.getContext();

            // set error message
            facesContext.addMessage(null,
                    new FacesMessage(
                            "System Error.", "System Error."));
            facesContext.getExternalContext().getFlash().setKeepMessages(true);

            try {
                // redirect error log.
                NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
                navigationHandler.handleNavigation(facesContext, null, "/error?faces-redirect=true");
            } finally {
                // remove error queue.
                it.remove();
            }
        }

        wrapped.handle();
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

}
