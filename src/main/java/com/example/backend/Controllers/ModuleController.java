package com.example.backend.Controllers;

import com.example.backend.entities.Group;
import com.example.backend.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.example.backend.entities.Module;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value="/add",method= RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addModule(@RequestBody Module module) {
        moduleService.addModule(module);
    }

    @RequestMapping(value = "/list")
    public List<Module> getModule(){
        return moduleService.getListModule();
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        moduleService.deleteModule(id);
    }

    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public Module findById(@PathVariable Long id){
        return moduleService.findById(id);
    }

    @RequestMapping(value = "/group/{Id}",method=RequestMethod.GET)
    public List<Module> findModuleByGroup(@PathVariable Long Id){
        return moduleService.findModuleByGroup(Id);
    }

}
