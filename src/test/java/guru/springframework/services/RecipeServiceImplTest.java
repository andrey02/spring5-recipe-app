package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    RecipeService recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);

    }


    //testar se o retorno do getRecipes é correto e quantas vezes a lógica do repositorio foi invocada.
    @Test
    public void getRecipes() throws Exception {

        //criando dados falsos para serem devolvidos no mock
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        //simulando um retorno do mock
        when(recipeRepository.findAll()).thenReturn(recipeData); //não quero testar o repositorio e sim a lógica
        // do service


        //saber se o retorno da função getRecipe do Service está de acordo
        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll();

    }

}