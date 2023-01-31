package com.example.backend.entities;








import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "user")
@Table(schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "u_id", unique = true)
    private Long uId;

    @Column(name = "u_name",unique = true)
    @NotNull
    private String username;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "date_modif")
    private Date dateModif;

    private String etat;
    @Column(name = "id_createur")
    private Long idCreateur;

    @Column(name = "nom_utilisateur")
    private String nomUtilisateur;

    @Column(name = "u_depart")
    private String uDepart;

    @Column(name = "u_login")
    private String uLogin;

    @Column(name = "u_mail",unique = true)
    @NotNull
    private String uMail;

    @Column(name = "u_matricule")
    private String uMatricule;



    @Column(name = "u_pwd")
    @NotNull
    private String password;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "g_id", referencedColumnName = "g_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Group user_group;

    public Group getUser_group() {
        return user_group;
    }

    public void setUser_group(Group user_group) {
        this.user_group = user_group;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
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

    public String getuDepart() {
        return uDepart;
    }

    public void setuDepart(String uDepart) {
        this.uDepart = uDepart;
    }

    public String getuLogin() {
        return uLogin;
    }

    public void setuLogin(String uLogin) {
        this.uLogin = uLogin;
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail;
    }

    public String getuMatricule() {
        return uMatricule;
    }

    public void setuMatricule(String uMatricule) {
        this.uMatricule = uMatricule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String uMail, String password) {
        this.username = username;
        this.uMail = uMail;
        this.password = password;

    }

    public User(){}
}

