package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class indexController {

    @RequestMapping({"","/","/index","index.html"})
    public String getIndexPage() {

        System.out.println("hello world");
        return "index";
    }
}
