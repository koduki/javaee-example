/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee;

import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import javax.inject.Named;
import lombok.Getter;

/**
 * Simple Flow Definition.
 *
 * @author koduki
 */
@Named
@Dependent
public class SimpleFlowDefinition implements Serializable {

    @Getter
    private final String flowId = "simpleFlow";

    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        flowBuilder.id("", flowId);

        // start flow method
        flowBuilder.initializer("#{simpleForm.startFlow()}");

        // page flow
        flowBuilder.viewNode("step1", "/input01.xhtml").markAsStartNode();
        flowBuilder.navigationCase().fromOutcome("step2").toViewId("/input02.xhtml").redirect();
        flowBuilder.navigationCase().fromOutcome("step3").toViewId("/confirm.xhtml").redirect();
        flowBuilder.viewNode("step2", "/input02.xhtml");
        flowBuilder.viewNode("step3", "/confirm.xhtml");

        // back page
        flowBuilder.returnNode("complete").fromOutcome("/complete");

        // end flow method
        flowBuilder.finalizer("#{simpleForm.endFlow()}");

        return flowBuilder.getFlow();
    }
}
