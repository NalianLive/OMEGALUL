package live.nalian.omegalul.scenarios.impl;

import live.nalian.omegalul.api.scenarios.impl.IMobPoison;
import live.nalian.omegalul.scenarios.SimpleScenario;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public final class MobPoison extends SimpleScenario implements IMobPoison
{

    private final Random random = new Random();

    @Override
    public void handler(final Entity victim, final Entity attacker)
    {
        if (victim instanceof Player && !(attacker instanceof Player))
        {
            if (shouldPoison())
            {
                ((Player) victim).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5, 0));
            }
        }
    }

    /** Returns true 10% of the time */
    private boolean shouldPoison()
    {
        return random.nextInt(10) == 0;
    }

    @Override
    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event)
    {
        handler(event.getEntity(), event.getDamager());
    }

    @Override
    public String getAuthor()
    {
        return "grujo#3992";
    }

}
