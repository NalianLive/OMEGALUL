package live.nalian.omegalul;

import live.nalian.omegalul.api.IOmegaLul;
import live.nalian.omegalul.scenarios.impl.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class OmegaLul extends JavaPlugin implements IOmegaLul
{

    @Override
    public void onEnable()
    {
        new AustralianCrafting().register(this);
        new CraftDestroyer().register(this);
        new FastBabyZombies().register(this);
        new MobPoison().register(this);
        new MobsLikeSummer().register(this);
        new Splinters().register(this);
    }

}
