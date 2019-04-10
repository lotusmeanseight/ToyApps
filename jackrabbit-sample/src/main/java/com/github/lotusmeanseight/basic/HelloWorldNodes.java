package com.github.lotusmeanseight.basic;

import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.*;

public class HelloWorldNodes {

    public static void main(String[] args) throws RepositoryException {
        Repository repository = JcrUtils.getRepository();
        Session session = repository.login(
                new SimpleCredentials("admin", "admin".toCharArray()));
        Node root = session.getRootNode();

        // Store content
        Node hello = root.addNode("hello");
        Node world = hello.addNode("world");
        world.setProperty("message", "Hello, World!");
        session.save();

        // Retrieve content
        Node node = root.getNode("hello/world");
        System.out.println(node.getPath());
        System.out.println(node.getProperty("message").getString());

        // Remove content
        root.getNode("hello").remove();
        session.save();

        session.logout();
    }
}
