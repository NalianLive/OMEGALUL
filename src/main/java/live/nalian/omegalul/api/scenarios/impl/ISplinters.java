package live.nalian.omegalul.api.scenarios.impl;

import org.bukkit.entity.Player;

public interface ISplinters
{

    /**
     * Should give a victim a "splinter". 0.1% chance for each wooden item in the inventory.
     * @param victim Victim
     */
    void handler(final Player victim);

}
