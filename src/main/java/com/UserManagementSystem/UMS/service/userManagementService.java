package com.UserManagementSystem.UMS.service;
import com.UserManagementSystem.UMS.model.userManagementModel;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Service
public class userManagementService {

    private static List<userManagementModel> userList;
    private static Map<Integer, userManagementModel> userDataMap = new HashMap<>();


    public String addToDatabase(userManagementModel usermanagementmodel){
        userDataMap.put(usermanagementmodel.getUserId(), usermanagementmodel);
        userList = new ArrayList<>(userDataMap.values());
        return "New User is added to Database " + usermanagementmodel.getUserName();
    }

    public List<userManagementModel> getAllUser(){
       return userList;
    }

    public List<userManagementModel> getUserByUserId(Integer userId){
        List<userManagementModel> newUserList = new ArrayList<>();
        if(null != userId){
            if(userDataMap.containsKey(userId)){
                newUserList.add(userDataMap.get(userId));
            }
        }
        return newUserList;
    }


    public String updatingUser(Integer userId, userManagementModel usermanagementmodel){
        if(userDataMap.containsKey(userId)){
            userDataMap.put(userId, usermanagementmodel);
            return "User is Updated in the existing Database ";
        }else{
            return "User doesn't exists";
        }
    }


    public static String deleteUserById(Integer userId){
        if(userDataMap.containsKey(userId)){
            userDataMap.remove(userId);
            return userId + "is Deleted from the Database";
        }else{
            return "userId doesn't exist " + userId;
        }

    }

}