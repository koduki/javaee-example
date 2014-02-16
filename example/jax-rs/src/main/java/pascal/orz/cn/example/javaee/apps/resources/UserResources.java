/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pascal.orz.cn.example.javaee.apps.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author koduki
 */
@Path("/users")
public class UserResources {
    
    @GET
    public String list(){
        return   "hello";
    }
}
