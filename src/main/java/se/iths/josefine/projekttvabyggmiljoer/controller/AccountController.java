package se.iths.josefine.projekttvabyggmiljoer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.iths.josefine.projekttvabyggmiljoer.model.ATMService;

@Controller
@RequestMapping("/balance")
public class AccountController {

    private ATMService atmService;

    public AccountController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping
    public String getBalance(Model model) {
        model.addAttribute("balance", atmService.getBalance());
        return "balance";
    }
}
