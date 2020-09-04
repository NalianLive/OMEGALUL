package live.nalian.omegalul.scenarios.impl;

import live.nalian.omegalul.api.IOmegaLul;
import live.nalian.omegalul.api.scenarios.impl.IAustralianCrafting;
import live.nalian.omegalul.scenarios.SimpleScenario;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

import java.util.*;

public class AustralianCrafting extends SimpleScenario implements IAustralianCrafting
{
    @Override
    public void register(final IOmegaLul lul)
    {
        final Iterator<Recipe> recipeIterator = lul.getServer().recipeIterator();
        final List<Recipe> toAdd = new ArrayList<>();

        while (recipeIterator.hasNext())
        {
            final Recipe recipe = recipeIterator.next();
            if (recipe instanceof ShapedRecipe)
            {
                final ShapedRecipe shapedRecipe = (ShapedRecipe) recipe;
                final String[] oldShape = shapedRecipe.getShape();
                final String[] shape = shapedRecipe.getShape();
                Collections.reverse(Arrays.asList(shape));
                recipeIterator.remove();

                //noinspection deprecation
                final ShapedRecipe replacementRecipe = new ShapedRecipe(shapedRecipe.getResult());
                replacementRecipe.shape(shape);

                for (final Map.Entry<Character, ItemStack> ingredient : shapedRecipe.getIngredientMap().entrySet())
                {
                    if (ingredient.getKey() == null || ingredient.getValue() == null) continue;
                    replacementRecipe.setIngredient(ingredient.getKey(), ingredient.getValue());
                }

                toAdd.add(replacementRecipe);
            }
            else
            {
                recipeIterator.remove();
                toAdd.add(recipe);
            }
        }

        for (final Recipe recipe : toAdd)
        {
            lul.getServer().addRecipe(recipe);
        }

        super.register(lul);
    }

    @Override
    public String getAuthor()
    {
        return "LewisTehMinerz#1337";
    }
}
