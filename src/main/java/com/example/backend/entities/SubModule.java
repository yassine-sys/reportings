package com.example.backend.entities;

import javax.persistence.*;

@Entity(name = "sub_module")
@Table(schema = "public")
public class SubModule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String SubModuleName;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id",referencedColumnName="id")
    private Module Module;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubModuleName() {
        return SubModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        SubModuleName = subModuleName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public com.example.backend.entities.Module getModule() {
        return Module;
    }

    public void setModule(com.example.backend.entities.Module module) {
        Module = module;
    }
}
