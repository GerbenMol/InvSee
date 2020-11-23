package com.InvSeeCreatedByGerben;

import com.InvSeeCreatedByGerben.Commands.InvSeeCommand;
import com.InvSeeCreatedByGerben.Events.InvSeeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable(){
	    getCommand("invsee").setExecutor(new InvSeeCommand());
        getServer().getPluginManager().registerEvents(new InvSeeEvent(), this);
        getLogger().info("[InvSee] InvSee plugin has been enabled!");
    }
    public void onDisable(){
	    getLogger().info("[InvSee] InvSee plugin has been disabled!");
    }
}
