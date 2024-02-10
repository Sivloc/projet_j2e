package tsi.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Evenement {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column
    private Long id;

    @Column
    private String titre;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Column
    private String description;
    @Column
    private Double duree;

    @Column
    private int nbParticipantsMax;

    @OneToMany
    private List<Participant> participants;

    public Evenement(){}

    public Evenement(String titre, Date date, String description, Double duree, int nbParticipantsMax, List<Participant> participants){
        this.titre = titre;
        this.date = date;
        this.description = description;
        this.duree = duree;
        this.nbParticipantsMax = nbParticipantsMax;
        this.participants = participants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDuree() {
        return duree;
    }

    public void setDuree(Double duree) {
        this.duree = duree;
    }

    public int getNbParticipantsMax() {
        return nbParticipantsMax;
    }

    public void setNbParticipantsMax(int nbParticipantsMax) {
        this.nbParticipantsMax = nbParticipantsMax;
    }

    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }
    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
