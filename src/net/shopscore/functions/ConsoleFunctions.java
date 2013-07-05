package net.shopscore.functions;

import org.bukkit.Bukkit;

import net.shopscore.main.Main;

public class ConsoleFunctions {
    Main plugin;
    public ConsoleFunctions(Main Main) {
        this.plugin = Main;
    }
    
    public void message(String message){
      Bukkit.getConsoleSender().sendMessage(message);
    }
}
