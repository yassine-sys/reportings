package com.example.backend.services;

import com.example.backend.dao.GroupRepository;
import com.example.backend.entities.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "GroupService")
public class GroupServiceImp implements GroupService{

    @Autowired
    GroupRepository groupRepository;

    @Override
    public Group addGroup(Group group) {
        group.setDateCreation(new Date());
        return groupRepository.save(group);
    }

    @Override
    public List<Group> getListGroup() {
        return groupRepository.findAll();
    }

    @Override
    public void deleteGroup(Long gId) {
        Group group = groupRepository.getOne(gId);
        if (group != null)
        {
            groupRepository.delete(group);
        }

    }

    @Override
    public Group findById(Long gId) {
        return groupRepository.findById(gId).get();
    }

    @Override
    public List<Group> findGroupByModule(Long Id){
        return  groupRepository.findAll().stream().filter
                (x->x.getModule_groups().stream().anyMatch(t->t.getId()==Id)).collect(Collectors.toList());
    }


}
