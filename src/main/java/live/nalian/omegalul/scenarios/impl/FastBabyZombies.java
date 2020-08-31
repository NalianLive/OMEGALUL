package live.nalian.omegalul.scenarios.impl;

import live.nalian.omegalul.api.scenarios.impl.IFastBabyZombies;
import live.nalian.omegalul.scenarios.SimpleScenario;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class FastBabyZombies extends SimpleScenario implements IFastBabyZombies
{

    @Override
    public void handler(final Entity entity)
    {
        if (entity instanceof Zombie)
        {
            final Zombie zombie = (Zombie) entity;

            zombie.setBaby(true);
            zombie.addPotionEffect(
                new PotionEffect(PotionEffectType.SPEED, 32767, 2, true, true));
        }
    }

    @Override
    @EventHandler
    public void onEntitySpawn(final EntitySpawnEvent event)
    {
        handler(event.getEntity());
    }

    @Override
    public String getAuthor()
    {
        return "Kingl123#0123";
    }

}
