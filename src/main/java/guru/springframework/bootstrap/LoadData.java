package guru.springframework.bootstrap;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.utils.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;

@Slf4j
@Component
public class LoadData implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public LoadData(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //INPUT RECIPE
        Recipe recipe = new Recipe();
        recipe.setName("Guacamole");
        recipe.setDescription("Guacamole, a dip made from avocados, is originally from Mexico. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce)");
        recipe.setCookTime(0);
        recipe.setPrepTime(10);

        try {
            recipe.setImage(Image.generateBytes("C:\\Users\\Matheus-pc\\Desktop\\imagens\\guacamole.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        recipe.setDirections("1 Cut avocado, remove flesh;2 Mash with a fork;3 Add salt, lime juice, and the rest;4 Cover with plastic and chill to store");
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setServings(3);
        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        //category
        if(categoryRepository.findByDescription("Mexican").isPresent()) {
            recipe.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        }
        if(categoryRepository.findByDescription("dip").isPresent()) {
            recipe.getCategories().add(categoryRepository.findByDescription("dip").get());
        }
        if(categoryRepository.findByDescription("vegan").isPresent()) {
            recipe.getCategories().add(categoryRepository.findByDescription("vegan").get());
        }
        if(categoryRepository.findByDescription("avocado").isPresent()) {
            recipe.getCategories().add(categoryRepository.findByDescription("avocado").get());
        }

        //ingredients
        Ingredient ingredient = new Ingredient("avocados",new BigDecimal("2"));
        ingredient.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("ripe").get());

        Ingredient ingredient1 = new Ingredient("Kosher Salt",new BigDecimal("0.5"));
        ingredient1.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Ingredient ingredient2 = new Ingredient("Fresh lime juice or Lemon juice",new BigDecimal("1"));
        ingredient2.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient ingredient3 = new Ingredient("1/4 cup of minced red onion or thinly sliced green onion",new BigDecimal("2"));
        ingredient3.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient ingredient4 = new Ingredient("serrano chiles, stems and seeds removed, minced",new BigDecimal("2"));

        Ingredient ingredient5 = new Ingredient("cilantro (leaves and tender stems), finely chopped",new BigDecimal("2"));
        ingredient5.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient ingredient6 = new Ingredient("A dash of freshly grated black pepper",new BigDecimal("1"));

        Ingredient ingredient7 = new Ingredient("tomato, seeds and pulp removed, chopped",new BigDecimal("0.5"));
        ingredient5.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("ripe").get());

        //add to recipe
        recipe.addIngredients(ingredient);
        recipe.addIngredients(ingredient1);
        recipe.addIngredients(ingredient2);
        recipe.addIngredients(ingredient3);
        recipe.addIngredients(ingredient4);
        recipe.addIngredients(ingredient5);
        recipe.addIngredients(ingredient6);
        recipe.addIngredients(ingredient7);

        //notes
        Notes notes = new Notes();
        notes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");

        //add notes to recipe
        recipe.setNotes(notes);

        //save Recipe to database
        recipeRepository.save(recipe);
        log.debug("saved recipe: " + recipe.getName());


        //INPUT RECIPES 2
        Recipe recipe2 = new Recipe();
        recipe2.setName("Spicy Grilled Chicken Tacos");
        recipe2.setDescription("Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        recipe2.setCookTime(15);
        recipe2.setPrepTime(20);

        try {
            recipe2.setImage(Image.generateBytes("C:\\Users\\Matheus-pc\\Desktop\\imagens\\GrilledChickenTacos.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        recipe2.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat;2 Make the marinade and coat the chicken;3 Grill the chicken;4 Warm the tortillas;5 Assemble the tacos");
        recipe2.setDifficulty(Difficulty.MODERATE);
        recipe2.setServings(5);
        recipe2.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");

        //category
        if(categoryRepository.findByDescription("Dinner").isPresent())
            recipe2.getCategories().add(categoryRepository.findByDescription("Dinner").get());
        if(categoryRepository.findByDescription("Grill").isPresent())
            recipe2.getCategories().add(categoryRepository.findByDescription("Grill").get());
        if(categoryRepository.findByDescription("Quick and Easy").isPresent())
            recipe2.getCategories().add(categoryRepository.findByDescription("Quick and Easy").get());
        if(categoryRepository.findByDescription("Chicken").isPresent())
            recipe2.getCategories().add(categoryRepository.findByDescription("Chicken").get());

        //ingredients
        Ingredient ingredient8 = new Ingredient(" ancho chili powder",new BigDecimal("2"));
        ingredient8.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient ingredient9 = new Ingredient("dried oregano",new BigDecimal("1"));
        ingredient9.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Ingredient ingredient10 = new Ingredient("dried cumin",new BigDecimal("1"));
        ingredient10.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Ingredient ingredient11 = new Ingredient("sugar",new BigDecimal("1"));
        ingredient11.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Ingredient ingredient12 = new Ingredient("salt",new BigDecimal("0.5"));
        ingredient12.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Ingredient ingredient13 = new Ingredient("clove garlic, finely chopped",new BigDecimal("1"));

        Ingredient ingredient14 = new Ingredient("finely grated orange zest",new BigDecimal("1"));
        ingredient14.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        Ingredient ingredient15 = new Ingredient("fresh-squeezed orange juice",new BigDecimal("3"));
        ingredient15.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Tablespoon").get());

        //add to recipe2
        recipe2.addIngredients(ingredient8);
        recipe2.addIngredients(ingredient9);
        recipe2.addIngredients(ingredient10);
        recipe2.addIngredients(ingredient11);
        recipe2.addIngredients(ingredient12);
        recipe2.addIngredients(ingredient13);
        recipe2.addIngredients(ingredient14);
        recipe2.addIngredients(ingredient15);

        //notes
        Notes notes2 = new Notes();

        notes2.setRecipeNotes("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        //add notes to recipe2
        recipe2.setNotes(notes2);

        //save recipe2 to database
        recipeRepository.save(recipe2);

        log.debug("saved recipe: " + recipe2.getName());
        System.out.println("Data loaded ...");
    }


}
