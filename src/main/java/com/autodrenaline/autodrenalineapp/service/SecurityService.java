package com.autodrenaline.autodrenalineapp.service;

public interface SecurityService {

    boolean isAuthenticated();

    void autoLogin(String username, String password);

}
