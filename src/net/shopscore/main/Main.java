package net.shopscore.main;

import net.shopscore.events.EntityDeath;
import net.shopscore.functions.ConsoleFunctions;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
  
	public ConsoleFunctions console = new ConsoleFunctions(this);
	
	@Override
	public void onEnable(){
		console.message(ChatColor.GREEN+"Shop Score Enabled.");
		
		//register events in different class
		getServer().getPluginManager().registerEvents(new EntityDeath(this), this);
		getCommand("sscore").setExecutor(new Commands(this));
	}
	
	@Override
	public void onDisable(){
		console.message(ChatColor.YELLOW+"Shop Score Disabled.");
	}
	
}
