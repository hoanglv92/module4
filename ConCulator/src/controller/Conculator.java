package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Conculator {
    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }
    @PostMapping("/index")
    public String getResult(@RequestParam int snt, int sth,String orerator, Model model){
        if (orerator.equals("+")){
            int result=resultAdd(snt,sth);
            model.addAttribute("result",result);
        }else if (orerator.equals("-")){
            int result=resultSub(snt,sth);
            model.addAttribute("result",result);
        }else if (orerator.equals("*")){
            int result=resultMultip(snt,sth);
            model.addAttribute("result",result);
        } else if (orerator.equals("/")){
            if (sth==0){
                model.addAttribute("message","khong the chia cho 0");
            }
            else {
                int result = resultDivi(snt, sth);
                model.addAttribute("result", result);
            }
        }

        return "index";
    }
    private int resultAdd(int snt, int sth){
        return snt+sth;
    }
    private int resultSub(int snt, int sth){
        return snt-sth;
    }
    private int resultMultip(int snt, int sth){
        return snt*sth;
    }
    private int resultDivi(int snt, int sth){
        return snt/sth;
    }

}
