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

import java.util.*;

public class Splinters extends SimpleScenario implements ISplinters
{

    private final String[] woodTypes =
            {
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
            };

    private final List<Material> materialsToCheck = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void handler(final Player victim)
    {
        double splinterChance = 0;
        final Inventory inv = victim.getInventory();
        for (final Material mat : materialsToCheck)
        {
            if (inv.contains(mat))
            {
                for (int i = 0; i < inv.getSize(); i++)
                {
                    final ItemStack is = inv.getItem(i);
                    if (is != null && is.getType() == mat)
                    {
                        splinterChance += (0.1 * is.getAmount());
                    }
                }
            }
        }

        if ((random.nextDouble() * 100D) < splinterChance)
        {
            // 2 = one heart total
            victim.damage(2);
            victim.sendMessage(
                    ChatColor.RED
                            + "You just got a splinter!"
                            + ChatColor.ITALIC
                            + " *ouch*"
            );
        }
    }

    @Override
    public void register(final IOmegaLul lul)
    {
        for (final Material mat : Material.values())
        {
            if (StringUtils.startsWithAny(mat.name(), woodTypes))
            {
                materialsToCheck.add(mat);
            }
        }
        materialsToCheck.add(Material.STICK);
        materialsToCheck.add(Material.CARROT_ON_A_STICK);

        materialsToCheck.remove(Material.WARPED_FUNGUS);
        materialsToCheck.remove(Material.CRIMSON_FUNGUS);

        lul.getServer().getScheduler().scheduleSyncRepeatingTask(lul, () ->
        {
            final Collection<? extends Player> players = lul.getServer().getOnlinePlayers();
            for (final Player p : players)
            {
                handler(p);
            }
        }, 0, 20);

        super.register(lul);
    }

    @Override
    public String getAuthor()
    {
        return "Hot Load of Napalm#0666";
    }

}
