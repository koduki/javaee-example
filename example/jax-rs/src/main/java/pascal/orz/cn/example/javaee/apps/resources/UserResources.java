/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.apps.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import pascal.orz.cn.example.javaee.commons.annotations.ErrorLog;
import pascal.orz.cn.example.javaee.commons.annotations.TimeLog;

/**
 *
 * @author koduki
 */
@Path("/users")
@TimeLog
@ErrorLog
public class UserResources {

    @GET
    public String list() {
        if (1 == 1) {
            throw new RuntimeException();
        }
        return "hello";
    }
}
