package tsi.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "evenement")
public class Evenement {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "num_even")
    private int numeven;

    @Column(name = "intitule", nullable = false)
    private String intitule;

    @Column(name = "theme", nullable = false)
    private String theme;

    @Column(name = "date_debut", nullable = false)
    private String date_debut;

    @Column(name = "duree", nullable = false)
    private String duree;

    @Column(name = "nb_part_max",nullable = false)
    private String nb_part_max;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "organisateur", nullable = false)
    private String organisateur;

    @Column(name = "type_even", nullable = false)
    private String type_even;

    @OneToMany(mappedBy = "evenement")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Participant> participants;
    public Evenement() {}

    public Evenement(String intitule, String theme, String date_debut, String duree,
                     String nb_part_max, String description, String organisateur, String type_even){
        this.intitule = intitule;
        this.theme = theme;
        this.date_debut = date_debut;
        this.duree = duree;
        this.nb_part_max = nb_part_max;
        this.description = description;
        this.organisateur = organisateur;
        this.type_even = type_even;
        this.participants = new ArrayList<>();
    }
    public void addParticipant(Participant participant){
        participants.add(participant);
    }
}
