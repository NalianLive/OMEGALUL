package live.nalian.omegalul.scenarios.impl;

import live.nalian.omegalul.api.IOmegaLul;
import live.nalian.omegalul.api.scenarios.impl.IHotFood;
import live.nalian.omegalul.scenarios.SimpleScenario;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class HotFood extends SimpleScenario implements IHotFood
{

    private IOmegaLul lul;
    private final Random random = new Random();

    @Override
    @EventHandler
    public void onSmelt(final FurnaceSmeltEvent event)
    {
        final ItemStack result = event.getResult();
        final ItemMeta meta = result.getItemMeta();
        meta.setCustomModelData(1);
        result.setItemMeta(meta);
    }

    @Override
    @EventHandler
    public void onEat(final PlayerItemConsumeEvent event)
    {
        if (event.getItem().getItemMeta().getCustomModelData() == 1)
        {
            final Player player = event.getPlayer();
            event.setCancelled(true);
            player.damage(1);
            player.sendMessage(ChatColor.RED + "Too hot! Wait a bit before eating that!");
        }
    }

    private void runSchedule() {
        Bukkit.getScheduler().scheduleSyncDelayedTask(lul, () -> {
            for (final Player ply : lul.getServer().getOnlinePlayers()) {
                for (final ItemStack itemStack : ply.getInventory().getContents()) {
                    final ItemMeta meta = itemStack.getItemMeta();
                    if (meta.getCustomModelData() == 1) {
                        meta.setCustomModelData(0);
                        itemStack.setItemMeta(meta);
                    }
                }
            }
            runSchedule(); // loop the schedule
        }, Math.min(20 * 60, random.nextInt(20 * 120))); // at least 1 minute
    }

    @Override
    public void register(final IOmegaLul lul)
    {
        this.lul = lul;
        runSchedule(); // need to do this since it's recursive
        super.register(lul);
    }

    @Override
    public String getAuthor()
    {
        return "Zerr0#3039";
    }
}
