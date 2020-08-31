package live.nalian.omegalul.scenarios.impl;

import live.nalian.omegalul.api.IOmegaLul;
import live.nalian.omegalul.api.scenarios.impl.ISplinters;
import live.nalian.omegalul.scenarios.SimpleScenario;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.*;

public class Splinters extends SimpleScenario implements ISplinters
{

    private final List<String> woodTypes = Arrays.asList(
            "ACACIA",
            "BIRCH",
            "DARK_OAK",
            "JUNGLE",
            "OAK",
            "SPRUCE",
            "WOODEN",
            "CRIMSON",
            "WARPED",
            "STRIPPED"
            );

    private final List<Material> materialsToCheck = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void register(final IOmegaLul lul)
    {
        for (Material m: Material.values())
        {
            if (StringUtils.startsWithAny(m.name(), (String[]) woodTypes.toArray()))
            {
                materialsToCheck.add(m);
            }
        }
        materialsToCheck.add(Material.STICK);
        materialsToCheck.add(Material.CARROT_ON_A_STICK);
        materialsToCheck.add(Material.WARPED_FUNGUS_ON_A_STICK);

        materialsToCheck.remove(Material.WARPED_FUNGUS);
        materialsToCheck.remove(Material.CRIMSON_FUNGUS);

        final BukkitScheduler scheduler = lul.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(lul, () ->
        {
            final Collection<? extends Player> players = lul.getServer().getOnlinePlayers();
            for (Player p: players)
            {
                double splinterChance = 0;
                final Inventory inv = p.getInventory();
                for (Material m: materialsToCheck)
                {
                    if (inv.contains(m))
                    {
                        for (int i = 0; i < inv.getSize(); i++)
                        {
                            final ItemStack is = inv.getItem(i);
                            if (is != null && is.getType() == m)
                            {
                                splinterChance += (0.1 * is.getAmount());
                            }
                        }
                    }
                }

                if (random.nextInt(100) < splinterChance)
                {
                    // 2 = one heart total
                    p.damage(2);
                    p.sendMessage(
                            ChatColor.RED
                                + "You just got a splinter!"
                                + ChatColor.ITALIC
                                + " *ouch*"
                    );
                }
            }
        }, 0, 20);

        super.register(lul);
    }

    @Override
    public String getAuthor()
    {
        return "Hot Load of Napalm#0666";
    }

    @Override
    public void handler(final Player victim)
    {

    }
}
