/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxicalls.gateway.model;

import java.io.Serializable;

/**
 *
 * @author romulo
 */
public class Driver implements Serializable {

    private Long id;
    private String email;
    private String password;
    private Coordinate atualCoordinate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coordinate getAtualCoordinate() {
        return this.atualCoordinate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
