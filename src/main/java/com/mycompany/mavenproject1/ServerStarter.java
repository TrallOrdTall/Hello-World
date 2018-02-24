/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

/**
 *
 * @author lionius
 */
public class ServerStarter{
    
    public static void main(String[] args) throws Exception{
                     
        withStaticServer();
        
    }
    private static void simpleServer() throws Exception, InterruptedException{
        Server server = new Server(8080);
        server.setHandler(new PageGenerator());
        server.start();
        System.out.println("Server started...");
        server.join();
    }
    private static void withStaticServer() throws Exception, InterruptedException {
        Server server = new Server(8080);
                
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setWelcomeFiles(new String[]{ "index.html" });
 
        resource_handler.setResourceBase(".");
 
        //HandlerList handlers = new HandlerList();
        //handlers.setHandlers(new Handler[] { resource_handler, new PageGenerator()});
        server.setHandler(resource_handler);
 
        server.start();
        System.out.println("Server started...");
        server.join();
    }
}
