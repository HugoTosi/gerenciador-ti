package gestao_ti.gestao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PageController {
    @GetMapping("/")
    public RedirectView inicio(){
        return new RedirectView("/inicio.html");
    }
}
