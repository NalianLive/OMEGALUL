package live.nalian.omegalul.api.scenarios;

import live.nalian.omegalul.api.IOmegaLul;
import org.bukkit.event.Listener;

public interface IScenario extends Listener
{

    /**
     * Register the scenario.
     * @param lul OmegaLUL instance
     */
    void register(final IOmegaLul lul);

    /**
     * @return The author of the scenario (the suggester)'s Discord tag. <b>Example: </b>
     * violet#3993
     */
    String getAuthor();

}
