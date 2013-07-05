package net.shopscore.main;

import java.io.File;
import java.io.IOException;

import net.shopscore.functions.GetStatsPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
  
	public Main plugin;
    public Commands(Main Main) {
    	this.plugin = Main;
    }
    
    public GetStatsPlayer stats = new GetStatsPlayer();
    
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length==0){
			return false;
		}
		
		if(args[0].equalsIgnoreCase("help")){
			if(!sender.hasPermission("ssc.command.help")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.help) to use this command");
				return true;
			}
			
			sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"-=oO Help page 1 of 1 Oo=-");
			sender.sendMessage(ChatColor.GRAY+"/sscore help "+ChatColor.DARK_AQUA+": Display a help page.");
			sender.sendMessage(ChatColor.GRAY+"/sscore version "+ChatColor.DARK_AQUA+": Show version info.");
			sender.sendMessage(ChatColor.GRAY+"/sscore check-update "+ChatColor.DARK_AQUA+": Check new updates for ShopScore.");
			sender.sendMessage(ChatColor.GRAY+"/sscore reload "+ChatColor.DARK_AQUA+":  Reload configuration.");
			sender.sendMessage(ChatColor.GRAY+"/sscore top "+ChatColor.DARK_AQUA+": Show list top.");
			sender.sendMessage(ChatColor.GRAY+"/sscore stats [player] [page] "+ChatColor.DARK_AQUA+": Show player stats.");
			sender.sendMessage(ChatColor.GRAY+"/sscore disable "+ChatColor.DARK_AQUA+": Disable ShopScore.");
			sender.sendMessage(ChatColor.GRAY+"/sscore reset-stats [player] "+ChatColor.DARK_AQUA+": Reset Player Stats.");
			sender.sendMessage(ChatColor.GRAY+"/sscore remove-player [player] "+ChatColor.DARK_AQUA+": Remove a player.");
			sender.sendMessage(ChatColor.GRAY+"/sscore give-points [player] [ammount] "+ChatColor.DARK_AQUA+": Give points.");
			sender.sendMessage(ChatColor.GRAY+"/sscore set-points [player] [ammount] "+ChatColor.DARK_AQUA+": Set points.");
			sender.sendMessage(ChatColor.GRAY+"/sscore remove-points [player] [ammount] "+ChatColor.DARK_AQUA+": Remove points.");
			sender.sendMessage(ChatColor.GRAY+"/sscore debug [true/false] "+ChatColor.DARK_AQUA+": Enable/Disable debug system.");
			sender.sendMessage(ChatColor.GRAY+"/sscore deny-give-points [player] [true/false] "+ChatColor.DARK_AQUA+": Denny system give-points.");
			sender.sendMessage(ChatColor.GRAY+"/sscore ban-player [player] [true/fase]"+ChatColor.DARK_AQUA+": Ban a player.");
			return true;
		}else if(args[0].equalsIgnoreCase("version")){
			if(!sender.hasPermission("ssc.command.version")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.version) to use this command");
				return true;
			}
			
			sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"-=oO INFO Oo=-");
			sender.sendMessage(ChatColor.GRAY+"Running version v"+plugin.getDescription().getVersion());
			sender.sendMessage(ChatColor.GRAY+"Author: drako9095");
			return true;
		}else if(args[0].equalsIgnoreCase("check-update")){
			if(!sender.hasPermission("ssc.command.checkupdates")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.checkupdates) to use this command");
				return true;
			}
			sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Coming soon...");
			return true;
		}else if(args[0].equalsIgnoreCase("reload")){
			if(!sender.hasPermission("ssc.command.reload")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.reload) to use this command");
				return true;
			}
			plugin.reloadConfig();
			sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Configuration reloaded!");
			return true;
		}else if(args[0].equalsIgnoreCase("top")){
			if(!sender.hasPermission("ssc.command.top")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.top) to use this command");
				return true;
			}
			sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Coming Soon...");
			return true;
		}else if(args[0].equalsIgnoreCase("stats")){
			String playername = "";
			int page = 1;
			
			if(args.length==2||args.length==3){
				if(!sender.hasPermission("ssc.command.stats.others")){
					sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.stats.others) to use this command");
					return true;
				}
				
				playername = args[1];
				
				if(args.length==3){
					page = Integer.parseInt(args[2]);
				}else{
					page = 1;
				}
			}else if(args.length==1){
				if(!sender.hasPermission("ssc.command.stats")){
					sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.stats) to use this command");
					return true;
				}
				playername = sender.getName();
			}else{
				return false;
			}
			
			//get stats
			File fileplayer = new File(plugin.getDataFolder()+File.separator+"stats"+File.separator+playername+".yml");
			
			
			if(fileplayer.exists()){
				stats.StatsPlayer(playername, (Player) sender, fileplayer, page);
			}else{
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Error, this player has no statistics.");
			}
			
			return true;
		}else if(args[0].equalsIgnoreCase("disable")){
			if(!sender.hasPermission("ssc.command.disable")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.disable) to use this command");
				return true;
			}
			Bukkit.broadcastMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Score Shop Disabled!");
			return true;
		}else if(args[0].equalsIgnoreCase("reset-stats")){
			if(!sender.hasPermission("ssc.command.resetstats")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.resetstats) to use this command");
				return true;
			}
			
			//reset stats of this player
			if(args.length==2){
				
				stats.reset(args[1], (Player) sender, plugin);
				return true;
				
			}else{
				return false;
			}
		}else if(args[0].equalsIgnoreCase("remove-player")){
			if(args.length==2){
				String playername = args[1];
				File fileplayer = new File(plugin.getDataFolder()+File.separator+"stats"+File.separator+playername+".yml");
			
				if(fileplayer.exists()){
					fileplayer.delete();
					sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Player removed!.");
				}else{
					sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Error, this player no registered.");
				}
				return true;
			}else{
				return false;
			}
		}else if(args[0].equalsIgnoreCase("give-points")){
			
			if(!sender.hasPermission("ssc.command.givepoints")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.givepoints) to use this command");
				return true;
			}
			
			if(args.length==3){
				String playername = args[1];
				int ammount = Integer.parseInt(args[2]);
				
				File fileplayer = new File(plugin.getDataFolder()+File.separator+"stats"+File.separator+playername+".yml");
				
				if(fileplayer.exists()){
					YamlConfiguration pdata = YamlConfiguration.loadConfiguration(fileplayer);
					int current_points = pdata.getInt("points.ammount");
					int total_points = current_points + ammount;
					pdata.set("points.ammount", total_points);
					try {
						pdata.save(fileplayer);
						sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Gave "+ammount+" points for the player "+playername+".");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Error, this player no registered.");
				}
				
				return true;
			}else{
				return false;
			}
		}else if(args[0].equalsIgnoreCase("set-points")){
			
			if(!sender.hasPermission("ssc.command.setpoints")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.setpoints) to use this command");
				return true;
			}
			
			if(args.length==3){
				String playername = args[1];
				int ammount = Integer.parseInt(args[2]);
				
				File fileplayer = new File(plugin.getDataFolder()+File.separator+"stats"+File.separator+playername+".yml");
				
				if(fileplayer.exists()){
					YamlConfiguration pdata = YamlConfiguration.loadConfiguration(fileplayer);
					pdata.set("points.ammount", ammount);
					try {
						pdata.save(fileplayer);
						sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Set "+ammount+" points for the player "+playername+".");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Error, this player no registered.");
				}
				
				return true;
			}else{
				return false;
			}
		}else if(args[0].equalsIgnoreCase("remove-points")){
			
			if(!sender.hasPermission("ssc.command.removepoints")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.removepoints) to use this command");
				return true;
			}
			
			if(args.length==3){
				String playername = args[1];
				int ammount = Integer.parseInt(args[2]);
				
				File fileplayer = new File(plugin.getDataFolder()+File.separator+"stats"+File.separator+playername+".yml");
				
				if(fileplayer.exists()){
					YamlConfiguration pdata = YamlConfiguration.loadConfiguration(fileplayer);
					int current_points = pdata.getInt("points.ammount");
					int total_points = current_points - ammount;
					pdata.set("points.ammount", total_points);
					try {
						pdata.save(fileplayer);
						sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Removed "+ammount+" points for the player "+playername+".");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Error, this player no registered.");
				}
				
				return true;
			}else{
				return false;
			}
		}else if(args[0].equalsIgnoreCase("debug")){
			if(!sender.hasPermission("ssc.command.debug")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.debug) to use this command");
				return true;
			}
			
			sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Coming Soon...");
			return true;
		}else if(args[0].equalsIgnoreCase("deny-give-points")){
			if(!sender.hasPermission("ssc.command.denygivepoints")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.denygivepoints) to use this command");
				return true;
			}
			
			sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Coming Soon...");
			return true;
		}else if(args[0].equalsIgnoreCase("ban-player")){
			if(!sender.hasPermission("ssc.command.banplayer")){
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.RED+"You need permission (ssc.command.banplayer) to use this command");
				return true;
			}
			
			sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Coming Soon...");
			return true;
		}else if(args[0].equalsIgnoreCase("")){
			
		}
		return false;
	}
}
