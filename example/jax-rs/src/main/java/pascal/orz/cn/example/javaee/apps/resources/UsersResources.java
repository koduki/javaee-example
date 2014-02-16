/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.apps.resources;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
