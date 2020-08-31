package live.nalian.omegalul.api.scenarios.impl;

import live.nalian.omegalul.api.scenarios.IScenario;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;

public interface IFastBabyZombies extends IScenario
{

    /**
     * Should pass the Entity to {@link IFastBabyZombies#handler(Entity)}
     * @param event {@link EntitySpawnEvent}
     */
    @EventHandler
    void onEntitySpawn(final EntitySpawnEvent event);

    /**
     * Make the zombies fast babies, if applicable
     * @param entity Entity, may not be Zombie
     */
    void handler(final Entity entity);

}
