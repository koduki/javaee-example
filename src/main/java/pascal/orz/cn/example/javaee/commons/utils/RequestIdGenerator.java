/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.commons.utils;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;

/**
 *
 * @author koduki
 */
@Named
@RequestScoped
public class RequestIdGenerator {

    @Getter
    String id;

    @PostConstruct
    public void init() {
        this.id = String.valueOf(Math.random());
    }
}
