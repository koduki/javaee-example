/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author koduki
 */
@Named
@TimeLog
@ErrorLog
@FlowScoped("simpleFlow")
public class SimpleForm implements Serializable {

    @Inject
    @Getter
    @Valid
    User user;

    @Getter
    @Setter
    @Size(min = 1)
    private String message;

    @PostConstruct
    public void init() {

    }

    public void startFlow() {
        System.out.println("FLOW-START:" + this.getClass().getSimpleName());
    }

    public void endFlow() {
        System.out.println("FLOW-END:" + this.getClass().getSimpleName());
    }
}
