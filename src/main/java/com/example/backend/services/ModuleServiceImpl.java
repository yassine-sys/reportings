package com.example.backend.services;

import com.example.backend.dao.ModuleRepository;
import com.example.backend.entities.Group;
import com.example.backend.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service(value = "ModuleService")

public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Override
    public Module addModule(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public List<Module> getListModule() {
        return moduleRepository.findAll();
    }

    @Override
    public void deleteModule(Long Id) {
        Module module = moduleRepository.getOne(Id);
        if (module != null)
        {
            moduleRepository.delete(module);
        }

    }



    @Override
    public Module findById(Long Id) {
        return moduleRepository.getOne(Id);
    }

    @Override
    public List<Module> findModuleByGroup(Long Id) {
        return moduleRepository.findAll().stream().filter
                (x -> x.getGroup_module().stream().anyMatch(t -> t.getgId() == Id)).collect(Collectors.toList());
    }
}


