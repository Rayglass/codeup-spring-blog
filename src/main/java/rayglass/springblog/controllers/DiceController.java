package rayglass.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDiceAnswer(@PathVariable int n, Model model) {
        Random randomInt = new Random();
        int random = randomInt.nextInt(6) + 1;
        model.addAttribute("random", random);
        model.addAttribute("guess", n);
        return "roll-dice-result";
    }
}