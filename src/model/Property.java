/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Property implements Serializable {


       


    
    private String host;
    private String port;
   
    private String Driver = "com.mysql.jdbc.Driver";
    private String password;
    private String username;
    private String mysqlPath = "C:/Program Files/MySQL/MySQL Server 5.0/bin";

    

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    /**
     * @return the Driver
     */
    public String getDriver() {
        return Driver;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @param SqlUrl the SqlUrl to set
     */
    

    /**
     * @param Driver the Driver to set
     */
    public void setDriver(String Driver) {
        this.Driver = Driver;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getMysqlPath() {
        return mysqlPath;
    }

    public void setMysqlPath(String mysqlPath) {
        this.mysqlPath = mysqlPath;
    }
}





