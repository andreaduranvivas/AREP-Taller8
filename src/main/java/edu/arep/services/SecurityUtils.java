package edu.arep.services;

public class SecurityUtils {

    public static User login(User u) {
        System.out.println("Username: " + u.getUsername());
        System.out.println("Password: " + u.getPassword());
        u.setPassword("");

        return u;
    }
}
