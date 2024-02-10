package tsi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tsi.models.Evenement;
import tsi.services.EvenementService;

import java.util.List;

@Controller
public class EvenementController {
    @Autowired
    private EvenementService evenementService;

    @GetMapping("/evenements")
    public String afficherListeEvenements(Model model) {
        //model.addAttribute("evenements", evenementService.getAllEvenements());
		List<Evenement> evenements = evenementService.getAllEvenements();
		model.addAttribute("evenements", evenements);
        return "listeEvenements"; // Créez cette vue Thymeleaf pour afficher la liste des événements
    }

    @GetMapping("/evenements/new")
    public String ajouterEvenement(Model model){
        model.addAttribute("evenement", new Evenement());
        return "newEvenement";
    }

	@PostMapping("/evenements/new")
	public String ajouterEvenement(Evenement evenement, BindingResult result, Model model){
		evenementService.createEvenement(evenement);
		return "redirect:/evenements";
	}

	@GetMapping("/evenements/edit/{id_evenement}")
	public String afficherDetailEvenement(@PathVariable("id_evenement") Long id, Model model) {
		Evenement evenement = evenementService.getEvenementById(id);
		model.addAttribute("evenement", evenement);
		return "detailEvenement";
	}

	@PostMapping("/evenements/edit/{id_evenement}")
	public String modifierEvenement(@PathVariable("id_evenement") Long id, Evenement evenement, Model model) {
		Evenement evenementToUpdate = evenementService.getEvenementById(id);
		model.addAttribute("evenement", evenementToUpdate);
		return "redirect:/evenements";
	}

	@PostMapping("/evenements/delete/{id_evenement}")
	public String supprimerEvenement(@PathVariable("id_evenement") Long id, Model model) {
		evenementService.deleteById(id);
		return "redirect:/evenements";
	}

	@GetMapping("/evenements/add/{id_evenement}/{id_participant}")
	public String inscrireParticipant(@PathVariable("id_evenement") Long id_evenement, @PathVariable("id_participant") Long id_participant, Model model) {
		return "redirect:/evenements";
	}
}
