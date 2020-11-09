package me.math.stevydiscordpaper.managers;

import me.math.stevydiscordpaper.Main;
import me.math.stevydiscordpaper.managers.listeners.PlayerJoinListener;
import org.bukkit.plugin.PluginManager;

public class EventManager {
    private Main main;

    public EventManager(Main plugin) {
        this.main = plugin;
    }

    public void init() {
        registerEvents();
    }

    private void registerEvents() {
        PluginManager pm = main.getServer().getPluginManager();

        pm.registerEvents(new PlayerJoinListener(this.main), this.main);
        /*pm.registerEvents(new PlayerQuitListener(this), this);
        pm.registerEvents(new PlayerChatListener(this), this);
        pm.registerEvents(new PlayerDeathListener(this), this);
        pm.registerEvents(new PlayerSendCommandListener(this), this);

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
        pm.registerEvents(new PlayerAdvancementDoneListener(this), this);

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
