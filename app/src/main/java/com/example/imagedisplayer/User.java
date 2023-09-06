package com.example.imagedisplayer;

public class User {
    private String name, email, password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public static boolean validateRegistInfo(String name, String email, String pass, String cfmPass){
        if(name.length() < 5) {
            return false;
        }else if(!email.contains("@") && !email.endsWith(".com")){
            return false;
        }else if(!pass.equals(cfmPass)){
            return false;
        }
        return true;
    }
}
