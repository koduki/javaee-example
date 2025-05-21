/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pascal.orz.cn.example.javaee;

import java.net.InetSocketAddress;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.ext.RuntimeDelegate;
import jakarta.xml.ws.spi.http.HttpHandler;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pascal.orz.cn.example.javaee.apps.resources.ApplicationConfig;

/**
 *
 * @author hnakada
 */
public class UserResourcesTest {
    
    public UserResourcesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello()throws Exception{
//        java.net.URI uri = UriBuilder.fromUri("http://localhost/").port(8282).build();
// 
//        // Create an HTTP server listening at port 8282
//        HttpServer server;
//        InetSocketAddress addr = new InetSocketAddress(uri.getPort());
//        server= HttpServer.createSimpleServer(, 0);
//        // Create a handler wrapping the JAX-RS application
//        HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig(), HttpHandler.class);
//        // Map JAX-RS handler to the server root
//        server.createContext(uri.getPath(), handler);
//        // Start the server
//        server.start();
// 
    }
}
