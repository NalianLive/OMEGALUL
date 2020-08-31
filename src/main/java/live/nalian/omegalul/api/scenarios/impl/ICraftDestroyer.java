package live.nalian.omegalul.api.scenarios.impl;

import live.nalian.omegalul.api.scenarios.IScenario;
import org.bukkit.event.inventory.CraftItemEvent;

public interface ICraftDestroyer extends IScenario
{

    /**
     * Delete the result 10% of the time.
     * @param event {@link CraftItemEvent}
     */
    void onCraft(final CraftItemEvent event);

}
