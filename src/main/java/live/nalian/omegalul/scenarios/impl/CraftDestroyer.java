package live.nalian.omegalul.scenarios.impl;

import live.nalian.omegalul.api.scenarios.impl.ICraftDestroyer;
import live.nalian.omegalul.scenarios.SimpleScenario;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;

import java.util.Random;

public class CraftDestroyer extends SimpleScenario implements ICraftDestroyer
{

    private final Random random = new Random();

    @EventHandler
    public void onCraft(final CraftItemEvent event)
    {
        if (random.nextInt(100) < 5)
        {
            event.setCancelled(true);
            event.getInventory().clear();
            event.getWhoClicked().sendMessage(
                ChatColor.RED +
                    "The gods decided you don't deserve that crafting recipe... or its materials."
            );
        }
    }

    @Override
    public String getAuthor()
    {
        return "TopiCx#2752";
    }

}
