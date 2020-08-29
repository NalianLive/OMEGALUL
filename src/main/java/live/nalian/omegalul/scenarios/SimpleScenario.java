package live.nalian.omegalul.scenarios;

import live.nalian.omegalul.api.IOmegaLul;
import live.nalian.omegalul.api.scenarios.IScenario;

public abstract class SimpleScenario implements IScenario
{

    public void register(final IOmegaLul lul)
    {
        lul.getServer().getPluginManager().registerEvents(this, lul);
    }

}
