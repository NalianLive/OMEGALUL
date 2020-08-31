package live.nalian.omegalul.api.scenarios.impl;

import org.bukkit.entity.Player;

public interface ISplinters
{

    /**
     * Should give a victim a "splinter".
     * @param victim Victim
     */
    void handler(final Player victim);

}
