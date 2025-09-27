package ZoneProtect;

import org.bukkit.plugin.java.JavaPlugin;

public class ZoneProtectPlugin extends JavaPlugin {

    @Override
    public void onEnable(){
        getLogger().info("¡ZoneProtect ACTIVADO!");
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
    }

    public void onDisable(){
        getLogger().info("¡ZoneProtect DESACTIVADO!");
    }

}
