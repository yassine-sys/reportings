package com.example.backend.entities;





import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "group")
@Table(schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "gId")

public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "g_id")
    private Long gId;
    @Column(name = "g_name",unique = true)
    @NotNull
    private String gName;
    @Column(name = "g_description")
    private String gDescription;
    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "date_modif")
    private Date dateModif;
    @Column(name = "id_createur")
    private Long idCreateur;

    @Column(name = "nom_utilisateur")
    private String nomUtilisateur;
    private String etat;

    @OneToMany(mappedBy = "user_group", cascade = CascadeType.ALL)
    private List<User> groupUsers;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "module_groups")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Module> module_groups;

    public List<Module> getModule_groups() {
        return module_groups;
    }

    public void setModule_groups(List<Module> module_groups) {
        this.module_groups = module_groups;
    }

    public List<User> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(List<User> groupUsers) {
        this.groupUsers = groupUsers;
    }

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgDescription() {
        return gDescription;
    }

    public void setgDescription(String gDescription) {
        this.gDescription = gDescription;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModif() {
        return dateModif;
    }

    public void setDateModif(Date dateModif) {
        this.dateModif = dateModif;
    }

    public Long getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(Long idCreateur) {
        this.idCreateur = idCreateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Group(Long gId, String gName, String gDescription, Date dateCreation, Date dateModif, Long idCreateur, String nomUtilisateur, String etat, List<User> groupUsers, List<Module> module_groups) {
        this.gId = gId;
        this.gName = gName;
        this.gDescription = gDescription;
        this.dateCreation = dateCreation;
        this.dateModif = dateModif;
        this.idCreateur = idCreateur;
        this.nomUtilisateur = nomUtilisateur;
        this.etat = etat;
        this.groupUsers = groupUsers;
        this.module_groups = module_groups;
    }

    public Group (){}




}



