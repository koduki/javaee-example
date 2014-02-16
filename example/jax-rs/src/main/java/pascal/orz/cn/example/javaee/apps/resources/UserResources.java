/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.apps.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import pascal.orz.cn.example.javaee.apps.model.User;
import pascal.orz.cn.example.javaee.commons.annotations.ErrorLog;
import pascal.orz.cn.example.javaee.commons.annotations.TimeLog;

/**
 *
 * @author koduki
 */
@Path("/users")
@TimeLog
@ErrorLog
@Consumes("application/json")
@Produces("application/json")
public class UserResources {

    @GET
    public User list() {
        return new User();
    }
}
