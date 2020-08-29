package live.nalian.omegalul.api.scenarios.impl;

import live.nalian.omegalul.api.scenarios.IScenario;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public interface IMobPoison extends IScenario
{

    /**
     * Should pass on the work to {@link IMobPoison#handler(Entity, Entity)}
     * @param event {@link EntityDamageByEntityEvent}
     */
    @EventHandler
    void onEntityDamageByEntity(final EntityDamageByEntityEvent event);

    /**
     * Should poison the victim when applicable.
     * @param victim Victim
     * @param attacker Attacker
     */
    void handler(final Entity victim, final Entity attacker);

}
