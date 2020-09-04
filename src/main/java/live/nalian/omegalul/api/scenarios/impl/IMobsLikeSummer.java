package live.nalian.omegalul.api.scenarios.impl;

import live.nalian.omegalul.api.scenarios.IScenario;
import org.bukkit.event.entity.EntityCombustEvent;

public interface IMobsLikeSummer extends IScenario
{

    /**
     * Prevent mobs from burning.
     * @param event {@link EntityCombustEvent}
     */
    void onEntityCombust(final EntityCombustEvent event);

}
