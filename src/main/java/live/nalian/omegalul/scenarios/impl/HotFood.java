package live.nalian.omegalul.scenarios.impl;

import live.nalian.omegalul.api.IOmegaLul;
import live.nalian.omegalul.api.scenarios.impl.IHotFood;
import live.nalian.omegalul.scenarios.SimpleScenario;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class HotFood extends SimpleScenario implements IHotFood
{

    private IOmegaLul lul;
    private final Random random = new Random();

    @Override
    public void onSmelt(final FurnaceSmeltEvent event)
    {
        final ItemStack result = event.getResult();
        result.getItemMeta().setCustomModelData(1);
        Bukkit.getScheduler().scheduleSyncDelayedTask(lul, () ->
                result.getItemMeta().setCustomModelData(0), Math.min(20 * 60, random.nextInt(20 * 120))); // at least 1 minute
    }

    @Override
    public void onEat(PlayerItemConsumeEvent event)
    {
        if (event.getItem().getItemMeta().getCustomModelData() == 1)
        {
            final Player player = event.getPlayer();
            event.setCancelled(true);
            player.damage(1);
            player.sendMessage(ChatColor.RED + "Too hot! Wait a bit before eating that!");
        }
    }

    @Override
    public void register(final IOmegaLul lul)
    {
        this.lul = lul;
        super.register(lul);
    }

    @Override
    public String getAuthor()
    {
        return "Zerr0#3039";
    }
}
