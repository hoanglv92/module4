package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class sandwich {
    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }
    @PostMapping("/index")
    public  String getCondimets(@RequestParam String lettuce, String tomato, String mustard,
                                String sprouts, Model model){
        if (lettuce!=null){
            model.addAttribute("lettuce",lettuce);
        }
        if (tomato!=null){
            model.addAttribute("tomato",tomato);
        }
        if (mustard!=null){
            model.addAttribute("mustard",mustard);
        }
        if (sprouts!=null){
            model.addAttribute("sprouts",sprouts);
        }

        return"showCondiments";
    }


}
