package com.example.intellijpluginspotify;

import java.io.Serializable;

public class Account implements Serializable {

    public String username;
    public byte[] password;

    public Account(String username, byte[] password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
