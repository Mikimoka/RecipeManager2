package haveric.recipeManager.flag;

import haveric.recipeManager.RecipeProcessor;
import haveric.recipeManager.flag.args.ArgBuilder;
import haveric.recipeManager.flag.args.Args;
import haveric.recipeManager.recipes.*;
import haveric.recipeManagerCommon.recipes.RMCRecipeInfo;
import org.bukkit.Material;
import org.junit.Test;

import java.io.File;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class NamingTest extends FlagBaseTest {
    @Test
    public void testNamingCraft() {
        File file = new File("src/test/resources/recipes/naming/namingCraft.txt");
        RecipeProcessor.reload(null, true, file.getPath(), workDir.getPath());

        Map<BaseRecipe, RMCRecipeInfo> queued = RecipeProcessor.getRegistrator().getQueuedRecipes();

        assertEquals(2, queued.size());

        for (Map.Entry<BaseRecipe, RMCRecipeInfo> entry : queued.entrySet()) {
            CraftRecipe recipe = (CraftRecipe) entry.getKey();

            Args a = ArgBuilder.create().recipe(recipe).player(testUUID).build();

            ItemResult result = recipe.getResult(a);

            String name = recipe.getName();

            Material resultType = result.getType();
            if (resultType == Material.STONE_SWORD) {
                assertTrue(recipe.hasCustomName());
                assertEquals("Boomstick", name);
            } else if (resultType == Material.IRON_SWORD) {
                assertFalse(recipe.hasCustomName());
            }
        }
    }

    @Test
    public void testNamingCombine() {
        File file = new File("src/test/resources/recipes/naming/namingCombine.txt");
        RecipeProcessor.reload(null, true, file.getPath(), workDir.getPath());

        Map<BaseRecipe, RMCRecipeInfo> queued = RecipeProcessor.getRegistrator().getQueuedRecipes();

        assertEquals(2, queued.size());

        for (Map.Entry<BaseRecipe, RMCRecipeInfo> entry : queued.entrySet()) {
            CombineRecipe recipe = (CombineRecipe) entry.getKey();

            Args a = ArgBuilder.create().recipe(recipe).player(testUUID).build();

            ItemResult result = recipe.getResult(a);

            String name = recipe.getName();

            Material resultType = result.getType();
            if (resultType == Material.STONE_SWORD) {
                assertTrue(recipe.hasCustomName());
                assertEquals("Random Stuff", name);
            } else if (resultType == Material.IRON_SWORD) {
                assertFalse(recipe.hasCustomName());
            }
        }
    }

    @Test
    public void testNamingSmelt() {
        File file = new File("src/test/resources/recipes/naming/namingSmelt.txt");
        RecipeProcessor.reload(null, true, file.getPath(), workDir.getPath());

        Map<BaseRecipe, RMCRecipeInfo> queued = RecipeProcessor.getRegistrator().getQueuedRecipes();

        assertEquals(2, queued.size());

        for (Map.Entry<BaseRecipe, RMCRecipeInfo> entry : queued.entrySet()) {
            SmeltRecipe recipe = (SmeltRecipe) entry.getKey();

            Args a = ArgBuilder.create().recipe(recipe).player(testUUID).build();

            ItemResult result = recipe.getResult(a);

            String name = recipe.getName();

            Material resultType = result.getType();
            if (resultType == Material.STONE_SWORD) {
                assertTrue(recipe.hasCustomName());
                assertEquals("Diamond Sword", name);
            } else if (resultType == Material.IRON_SWORD) {
                assertFalse(recipe.hasCustomName());
            }
        }
    }
}
