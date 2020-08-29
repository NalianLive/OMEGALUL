package live.nalian.omegalul;

import live.nalian.omegalul.api.IOmegaLul;
import live.nalian.omegalul.scenarios.impl.MobPoison;
import org.bukkit.plugin.java.JavaPlugin;

public final class OmegaLul extends JavaPlugin implements IOmegaLul
{

    @Override
    public void onEnable()
    {
        new MobPoison().register(this);
    }

}
