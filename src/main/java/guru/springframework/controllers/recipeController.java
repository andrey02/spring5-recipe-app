package guru.springframework.controllers;

import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequestMapping("/recipe")
@Controller
public class recipeController {

    RecipeService recipeService;

    public recipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("")
    public String recipeList(Model model) {

        model.addAttribute("recipes",recipeService.getRecipes());
        log.debug("accessing /recipe page");
        return "recipe/index";
    }
}
