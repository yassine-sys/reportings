package com.example.backend.services;

import com.example.backend.entities.Group;

import java.util.List;


public interface GroupService {

    Group addGroup(Group group) ;
    List<Group> getListGroup() ;
    void deleteGroup(Long gId) ;

    Group findById(Long gId);

    List<Group> findGroupByModule(Long Id);
}
