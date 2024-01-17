package tsi.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tsi.models.Participant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParticipantController {
    @GetMapping("/participants")
    public String Participant(Model model){
        return "participants";
    }
}

