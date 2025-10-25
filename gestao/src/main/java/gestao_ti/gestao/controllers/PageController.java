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

    @GetMapping("/colaboradores")
    public RedirectView colaboradores(){
        return new RedirectView("/colaboradores.html");
    }
    @GetMapping("/colaboradores/form")
    public RedirectView novoColaborador(){
        return new RedirectView("/colaborador-form.html");
    }
}
