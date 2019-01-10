package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

public class recipeControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    recipeController controller;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new recipeController(recipeService);
    }

    @Test
    public void recipeList() {

        //given
        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeData);

        //when
        String viewName = controller.recipeList(model);


        //then
        assertEquals("recipe/index", viewName);
        //verificar número de vezes que methodos foram chamados
        verify(recipeService,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),anySet());
    }


}