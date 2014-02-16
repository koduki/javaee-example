/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.apps.model;

import pascal.orz.cn.example.javaee.commons.annotations.TimeLog;
import pascal.orz.cn.example.javaee.commons.annotations.ErrorLog;
import pascal.orz.cn.example.javaee.commons.annotations.FirstOrLastRequired;
import java.io.Serializable;
import javax.inject.Named;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author koduki
 */
@Named
@TimeLog
@ErrorLog
@ToString
@FirstOrLastRequired
public class User implements Serializable {

    @Getter
    @Setter
    @Size(min = 1)
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private int age;
}
