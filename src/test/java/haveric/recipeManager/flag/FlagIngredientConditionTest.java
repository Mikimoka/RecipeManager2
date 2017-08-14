package haveric.recipeManager.flag;

import haveric.recipeManager.RecipeProcessor;
import haveric.recipeManager.flag.conditions.ConditionsIngredient;
import haveric.recipeManager.flag.flags.FlagIngredientCondition;
import haveric.recipeManager.recipes.BaseRecipe;
import haveric.recipeManager.recipes.CraftRecipe;
import haveric.recipeManager.recipes.ItemResult;
import haveric.recipeManagerCommon.RMCChatColor;
import haveric.recipeManagerCommon.recipes.RMCRecipeInfo;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlagIngredientConditionTest extends FlagBaseTest {

    @Test
    public void onRecipeParse() {
        File file = new File("src/test/resources/recipes/flagIngredientCondition/");
        RecipeProcessor.reload(null, true, file.getPath(), workDir.getPath());

        Map<BaseRecipe, RMCRecipeInfo> queued = RecipeProcessor.getRegistrator().getQueuedRecipes();

        assertEquals(4, queued.size());
        for (Map.Entry<BaseRecipe, RMCRecipeInfo> entry : queued.entrySet()) {
            CraftRecipe recipe = (CraftRecipe) entry.getKey();
            ItemResult result = recipe.getResults().get(0);
            Material resultType = result.getType();

            FlagIngredientCondition flag = (FlagIngredientCondition) result.getFlag(FlagType.INGREDIENT_CONDITION);
            if (resultType == Material.DIRT) {
                List<ConditionsIngredient> conditions = flag.getIngredientConditions(new ItemStack(Material.DIRT));
                Map<Short, Boolean> values = conditions.get(0).getDataValues();
                assertTrue(values.containsKey((short) 0));
                assertTrue(values.containsKey((short) 1));
                assertTrue(values.containsKey((short) 2));
                assertTrue(values.containsKey((short) 3));
                assertTrue(values.containsKey((short) 4));
                assertTrue(values.containsKey((short) 5));
                assertFalse(values.containsKey((short) 6));
            } else if (resultType == Material.GRAVEL) {
                List<ConditionsIngredient> conditions = flag.getIngredientConditions(new ItemStack(Material.DIAMOND_SPADE));
                ConditionsIngredient cond = conditions.get(0);
                assertEquals(RMCChatColor.COLOR_CHAR + "bHammer", cond.getName());
                assertEquals(RMCChatColor.COLOR_CHAR + "cFoo", cond.getFailMessage());
            } else if (resultType == Material.COBBLESTONE) {
                List<ConditionsIngredient> conditions = flag.getIngredientConditions(new ItemStack(Material.DIRT));
                ConditionsIngredient cond = conditions.get(0);
                assertEquals("One", cond.getName());
                assertEquals("Two", cond.getLores().get(0));
                assertEquals("Three", cond.getFailMessage());
            } else if (resultType == Material.STONE) {
                List<ConditionsIngredient> conditions = flag.getIngredientConditions(new ItemStack(Material.DIRT));
                ConditionsIngredient cond = conditions.get(0);
                assertEquals("   One   ", cond.getName());
                assertEquals("   Two   ", cond.getLores().get(0));
                assertEquals("   Three   ", cond.getFailMessage());
            }
        }

        // TODO: Add more tests
    }
}
