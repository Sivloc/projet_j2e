package tsi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tsi.services.ParticipantService;
import tsi.models.Participant;

import java.util.List;

@Controller
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @GetMapping("/participants")
    public String list(Model model) {
        List<Participant> participants = participantService.getAllParticipants();
        model.addAttribute("participants", participants);
        return "listeParticipants";
    }

    @GetMapping("/participants/new")
    public String ajouterParticipant(Model model, Participant participant){
        Participant OldParticipant = participantService.findByEmail(participant.getEmail());
        if(OldParticipant != null) {
            model.addAttribute("error", "Participant already exists");
            return "newParticipant";
        }
        model.addAttribute("participant", new Participant());
        return "newParticipant";
    }

    @PostMapping("/participants/new")
    public String ajouterParticipant(Participant participant, Model model){
        participantService.createParticipant(participant);
        return "redirect:/participants";
    }

    @GetMapping("/participants/edit/{id}")
    public String afficherFormulaireModification(@PathVariable("id") Long id, Model model) {
        Participant participant = participantService.findById(id);
        model.addAttribute("participant", participant);
        return "detailParticipant"; // Vue Thymeleaf pour le formulaire de modification de l'utilisateur
    }

    @PostMapping("/participants/edit/{id}")
    public String modifierParticipant(@PathVariable("id") Long id, Participant participantModifie, Model model) {
        Participant ParticipantToUpdate = participantService.findById(id);
        ParticipantToUpdate.setNom(participantModifie.getNom());
        ParticipantToUpdate.setPrenom(participantModifie.getPrenom());
        ParticipantToUpdate.setEmail(participantModifie.getEmail());
        ParticipantToUpdate.setDate_naiss(participantModifie.getDate_naiss());
        ParticipantToUpdate.setOrganisation(participantModifie.getOrganisation());
        ParticipantToUpdate.setObservations(participantModifie.getObservations());
        return "redirect:/participants"; // Redirection vers la liste des utilisateurs après la modification
    }

    @PostMapping("/participants/delete/{id}")
    public String supprimerParticipant(@PathVariable("id") Long id, Model model) {
        participantService.deletebyId(id);
        return "redirect:/participants"; // Redirection vers la liste des utilisateurs après la suppression
    }
}
