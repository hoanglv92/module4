package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
@Controller
public class DictionaryController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/translate")
    public String stranslate(HttpServletRequest request, Model model){
        HashMap<String,String>listDic=new HashMap<>();
        listDic.put("hello","xin chao");
        listDic.put("red","mau do");
        listDic.put("bye bye","tam biet");
        listDic.put("crack","vet nut");
        listDic.put("auto","tu dong");
        String input=request.getParameter("input");
        if (listDic.get(input)!=null){
            model.addAttribute("output",listDic.get(input));
        }else {
            model.addAttribute("output","khong tim thay tu voi tu ban nhap");
        }
        return "index";
    }

}
