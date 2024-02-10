package tsi.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table
public class Participant {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment")
    @Column
    private long id;

    @Column
    private String prenom;
    @Column
    private String nom;
    @Column
    private String email;
    @Column
    private String date_naiss;
    @Column
    private String organisation;
    @Column
    private String observations;
    @OneToMany
    private List<Evenement> evenements;

    public Participant(){}

    public Participant(String prenom, String nom, String email, String date_naiss, String organisation, String observations, List<Evenement> evenements){
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisation = organisation;
        this.observations = observations;
        this.evenements = evenements;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
}
