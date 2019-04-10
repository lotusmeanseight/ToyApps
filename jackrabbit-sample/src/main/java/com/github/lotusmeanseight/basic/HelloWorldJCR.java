package com.github.lotusmeanseight.basic;

import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.GuestCredentials;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

public class HelloWorldJCR {

    public static void main(String[] args) throws RepositoryException {
            //Setup
            Repository repository = JcrUtils.getRepository();
            Session session = repository.login(new GuestCredentials());
            //create credentials
            String user = session.getUserID();
            String name = repository.getDescriptor(Repository.REP_NAME_DESC);
            System.out.println("Logged in as " + user + " to a " + name + " repository.");
            //close session
            session.logout();
    }
}
