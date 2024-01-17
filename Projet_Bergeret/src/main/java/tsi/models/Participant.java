package tsi.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "num_pers")
    private int numpers;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "prenom", nullable = false)
    private String prenom;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "date_naiss", nullable = false)
    private String date_naiss;
    @Column(name = "organisation", nullable = false)
    private String organisation;
    @Column(name = "observations", nullable = false)
    private String observaions;

    @ManyToOne
    private Evenement evenement;

    public Participant(){}

    public Participant(String nom, String prenom, String email,
                       String date_naiss, String organisation, String observations){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisation = organisation;
        this.observaions = observations;
    }
}
