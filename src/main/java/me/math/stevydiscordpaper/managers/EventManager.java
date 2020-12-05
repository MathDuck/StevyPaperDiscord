package me.math.stevydiscordpaper.managers;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.managers.paper.listeners.players.*;
import org.bukkit.plugin.PluginManager;

public class EventManager {
    private final Main plugin;

    public EventManager(Main plugin) {
        this.plugin = plugin;
    }

    public void init() {
        registerEvents();
    }

    private void registerEvents() {
        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new PlayerJoinListener(plugin), plugin);
        pm.registerEvents(new PlayerQuitListener(plugin), plugin);
        pm.registerEvents(new PlayerChatListener(plugin), plugin);
        pm.registerEvents(new PlayerDeathListener(plugin), plugin);
        pm.registerEvents(new PlayerSendCommandListener(plugin), plugin);

        pm.registerEvents(new PlayerAdvancementDoneListener(plugin), plugin);


        /*
        pm.registerEvents(new PlayerInteractEntityListener(this), this);
        pm.registerEvents(new PlayerInteractListener(this), this);
        pm.registerEvents(new PlayerBedEnterListener(this), this);
        pm.registerEvents(new PlayerChangedWorldListener(this), this);
        pm.registerEvents(new PlayerEditBookListener(this), this);
        pm.registerEvents(new PlayerDropItemListener(this), this);
        pm.registerEvents(new PlayerAttemptPickupItemListener(this), this);
        pm.registerEvents(new PlayerItemBreakListener(this), this);
        pm.registerEvents(new PlayerShearEntityListener(this), this);
        pm.registerEvents(new PlayerToggleFlightListener(this), this);
        pm.registerEvents(new PlayerToggleSprintListener(this), this);
        pm.registerEvents(new PlayerToggleSneakListener(this), this);
        pm.registerEvents(new PlayerUnleashEntityListener(this), this);
        pm.registerEvents(new PlayerBucketFillListener(this), this);
        pm.registerEvents(new PlayerBucketEmptyListener(this), this);
        pm.registerEvents(new PlayerMoveListener(this), this);

        pm.registerEvents(new FoodLevelChangeListener(this), this);

        pm.registerEvents(new EntityDamageListener(this), this);
        pm.registerEvents(new EntityDamageByEntityListener(this), this);
        pm.registerEvents(new EntityChangeBlockListener(this), this);
        pm.registerEvents(new EntityExplodeListener(this), this);
        pm.registerEvents(new EntityDeathListener(this), this);

        pm.registerEvents(new InventoryListener(this), this);*/
    }

    public void dispose() {

    }
}
