package live.nalian.omegalul.scenarios.impl;

import live.nalian.omegalul.api.scenarios.impl.IMobsLikeSummer;
import live.nalian.omegalul.scenarios.SimpleScenario;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityCombustEvent;

public class MobsLikeSummer extends SimpleScenario implements IMobsLikeSummer
{

    @Override
    @EventHandler
    public void onEntityCombust(final EntityCombustEvent event)
    {
        if (event.getEntity() instanceof Monster)
        {
            event.setCancelled(true);
        }
    }

    @Override
    public String getAuthor()
    {
        return "grujo#3992";
    }
}
