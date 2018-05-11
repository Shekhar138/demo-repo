package com.demo.service;


import java.util.List;

import com.demo.model.UserProfile;
 
 
 
public interface UserProfileService {
 
    UserProfile findById(int id);
 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
     
}