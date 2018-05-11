package com.demo.dao;


import java.util.List;

import com.demo.model.UserProfile;
 
 
 
public interface UserProfileDao {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}