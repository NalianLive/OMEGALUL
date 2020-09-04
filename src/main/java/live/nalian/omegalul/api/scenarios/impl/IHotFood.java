package live.nalian.omegalul.api.scenarios.impl;

import live.nalian.omegalul.api.scenarios.IScenario;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public interface IHotFood extends IScenario
{

    /**
     * You can't eat your food for 1-2 minutes, it's too hot!
     * @param event {@link FurnaceSmeltEvent}
     */
    void onSmelt(final FurnaceSmeltEvent event);

    /**
     * Too hot!
     * @param event {@link PlayerItemConsumeEvent}
     */
    void onEat(final PlayerItemConsumeEvent event);

}
