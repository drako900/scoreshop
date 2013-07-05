package net.shopscore.functions;

import java.io.File;
import java.io.IOException;

import net.shopscore.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class GetStatsPlayer {

  public void StatsPlayer(String player, Player sender, File fileplayer, int page){
		YamlConfiguration pdata = YamlConfiguration.loadConfiguration(fileplayer);
		int points = 0;
		int killsmob = 0;
		
		points = pdata.getInt("points.ammount");
		killsmob = pdata.getInt("kills.total");
		
		switch (page){
		case 1:
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"-=oO Stats ("+player+") Page 1 of 3 Oo=-");
				sender.sendMessage(ChatColor.DARK_AQUA+"Points: "+ChatColor.AQUA+points);
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed Mobs: "+ChatColor.AQUA+killsmob);
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed CHICKEN: "+ChatColor.AQUA+pdata.getInt("kills.CHICKEN"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed COW: "+ChatColor.AQUA+pdata.getInt("kills.COW"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed OCELOT: "+ChatColor.AQUA+pdata.getInt("kills.OCELOT"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed PIG: "+ChatColor.AQUA+pdata.getInt("kills.PIG"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed SHEEP: "+ChatColor.AQUA+pdata.getInt("kills.SHEEP"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed SQUID: "+ChatColor.AQUA+pdata.getInt("kills.SQUID"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed WOLF: "+ChatColor.AQUA+pdata.getInt("kills.WOLF"));
				sender.sendMessage(ChatColor.DARK_PURPLE+"Use "+ChatColor.GRAY+"/sscore stats yayito21 2"+ChatColor.DARK_PURPLE+" to display a second page...");
			break;
		case 2:
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"-=oO Stats ("+player+") Page 2 of 3 Oo=-");
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed BLAZE: "+ChatColor.AQUA+pdata.getInt("kills.BLAZE"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed CAVE_SPIDER: "+ChatColor.AQUA+pdata.getInt("kills.CAVE_SPIDER"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed CREEPER: "+ChatColor.AQUA+pdata.getInt("kills.CREEPER"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed ENDER_DRAGON: "+ChatColor.AQUA+pdata.getInt("kills.ENDER_DRAGON"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed ENDERMAN: "+ChatColor.AQUA+pdata.getInt("kills.ENDERMAN"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed GHAST: "+ChatColor.AQUA+pdata.getInt("kills.GHAST"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed GIANT: "+ChatColor.AQUA+pdata.getInt("kills.GIANT"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed MAGMA_CUBE: "+ChatColor.AQUA+pdata.getInt("kills.MAGMA_CUBE"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed PIG_ZOMBIE: "+ChatColor.AQUA+pdata.getInt("kills.PIG_ZOMBIE"));
				sender.sendMessage(ChatColor.DARK_PURPLE+"Use "+ChatColor.GRAY+"/sscore stats yayito21 3"+ChatColor.DARK_PURPLE+" to display a third page...");
			break;
		case 3:
				sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"-=oO Stats ("+player+") Page 3 of 3 Oo=-");
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed SILVERFISH: "+ChatColor.AQUA+pdata.getInt("kills.SILVERFISH"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed SKELETON: "+ChatColor.AQUA+pdata.getInt("kills.SKELETON"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed SLIME: "+ChatColor.AQUA+pdata.getInt("kills.SLIME"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed SNOWMAN: "+ChatColor.AQUA+pdata.getInt("kills.SNOWMAN"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed SPIDER: "+ChatColor.AQUA+pdata.getInt("kills.SPIDER"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed WITCH: "+ChatColor.AQUA+pdata.getInt("kills.WITCH"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed WITHER: "+ChatColor.AQUA+pdata.getInt("kills.WITHER"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed ZOMBIE: "+ChatColor.AQUA+pdata.getInt("kills.ZOMBIE"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed PLAYERS: "+ChatColor.AQUA+pdata.getInt("kills.PLAYER"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed BAT: "+ChatColor.AQUA+pdata.getInt("kills.BAT"));
				sender.sendMessage(ChatColor.DARK_AQUA+"Killed VILLAGER: "+ChatColor.AQUA+pdata.getInt("kills.VILLAGER"));
			
			break;
		}
	}
	
	public void reset(String player, Player sender, Main plugin){
		File fileplayer = new File(plugin.getDataFolder()+File.separator+"stats"+File.separator+player+".yml");
		if(fileplayer.exists()){
			YamlConfiguration pdata = YamlConfiguration.loadConfiguration(fileplayer);
			//reseting stats of this player...
			pdata.set("kills.total", 0);
			pdata.set("kills.CHICKEN", 0);
			pdata.set("kills.COW", 0);
			pdata.set("kills.OCELOT", 0);
			pdata.set("kills.PIG", 0);
			pdata.set("kills.SHEEP", 0);
			pdata.set("kills.SQUID", 0);
			pdata.set("kills.WOLF", 0);
			pdata.set("kills.BLAZE", 0);
			pdata.set("kills.CAVE_SPIDER", 0);
			pdata.set("kills.CREEPER", 0);
			pdata.set("kills.ENDER_DRAGON", 0);
			pdata.set("kills.ENDERMAN", 0);
			pdata.set("kills.GHAST", 0);
			pdata.set("kills.GIANT", 0);
			pdata.set("kills.MAGMA_CUBE", 0);
			pdata.set("kills.PIG_ZOMBIE", 0);
			pdata.set("kills.SILVERFISH", 0);
			pdata.set("kills.SKELETON", 0);
			pdata.set("kills.SLIME", 0);
			pdata.set("kills.SNOWMAN", 0);
			pdata.set("kills.SPIDER", 0);
			pdata.set("kills.WITCH", 0);
			pdata.set("kills.WITHER", 0);
			pdata.set("kills.ZOMBIE", 0);
			pdata.set("kills.PLAYERS", 0);
			pdata.set("kills.BAT", 0);
			pdata.set("kills.VILLAGER", 0);
			try {
				pdata.save(fileplayer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Statistics have been reset for the player "+player+".");
		}else{
			sender.sendMessage(ChatColor.DARK_GREEN+"[SS] "+ChatColor.GOLD+"Error, this player has no statistics.");
		}
	}
}
