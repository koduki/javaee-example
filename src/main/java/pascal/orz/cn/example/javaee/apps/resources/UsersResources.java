/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.apps.resources;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import pascal.orz.cn.example.javaee.apps.model.Users;
import pascal.orz.cn.example.javaee.apps.model.UsersDao;
import pascal.orz.cn.example.javaee.commons.annotations.ErrorLog;
import pascal.orz.cn.example.javaee.commons.annotations.TimeLog;

/**
 *
 * @author koduki
 */
@Path("/users")
@TimeLog
@ErrorLog
@Transactional
@Consumes("application/json")
@Produces("application/json")
public class UsersResources {

    @Inject
    UsersDao usersDao;

    @GET
    public List<Users> list() {
        return this.usersDao.findAll();
    }

    @POST
    public Users create(Users user) {
        this.usersDao.create(user);

        return user;
    }
}
