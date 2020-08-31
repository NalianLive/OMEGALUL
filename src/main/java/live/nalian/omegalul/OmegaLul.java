package live.nalian.omegalul;

import live.nalian.omegalul.api.IOmegaLul;
import live.nalian.omegalul.scenarios.impl.CraftDestroyer;
import live.nalian.omegalul.scenarios.impl.FastBabyZombies;
import live.nalian.omegalul.scenarios.impl.MobPoison;
import org.bukkit.plugin.java.JavaPlugin;

public final class OmegaLul extends JavaPlugin implements IOmegaLul
{

    @Override
    public void onEnable()
    {
        new MobPoison().register(this);
        new CraftDestroyer().register(this);
        new FastBabyZombies().register(this);
    }

}
