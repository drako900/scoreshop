package net.shopscore.events;

import java.io.File;
import java.io.IOException;

import net.shopscore.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener {
  
    Main plugin;
    public EntityDeath(Main Main) {
        this.plugin = Main;
    }
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		
		if(event.getEntity().getKiller()==null){
			return;
		}
		
		Player killer = event.getEntity().getKiller();
		killer.sendMessage(ChatColor.DARK_GREEN + "[SS] " + getEntityNameEN(event.getEntityType(), killer));
		
	}
	
	public String getEntityNameEN(EntityType entity, Player killer){
		
		int points = 0;
		String frase = null;
		frase = ChatColor.DARK_AQUA+"Null description, entity: "+ChatColor.DARK_PURPLE+""+entity;
		
		//animals
		if(entity.equals(EntityType.CHICKEN)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"chicken"+ChatColor.DARK_AQUA+", earned 1 point."; points = 1;}
		if(entity.equals(EntityType.COW)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"cow"+ChatColor.DARK_AQUA+", earned 1 point."; points = 1;}
		if(entity.equals(EntityType.OCELOT)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"ocelot"+ChatColor.DARK_AQUA+", earned 0 points."; points = 0;}
		if(entity.equals(EntityType.PIG)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"pig"+ChatColor.DARK_AQUA+", earned 1 point."; points = 1;}
		if(entity.equals(EntityType.SHEEP)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"sheep"+ChatColor.DARK_AQUA+", earned 1 point."; points = 1;}
		if(entity.equals(EntityType.SQUID)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"squid"+ChatColor.DARK_AQUA+", earned 1 point."; points = 1;}
		if(entity.equals(EntityType.WOLF)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"wolf"+ChatColor.DARK_AQUA+", earned 0 points"; points = 0;}
		
		//mobs (monsters)
		if(entity.equals(EntityType.BLAZE)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"blaze"+ChatColor.DARK_AQUA+", earned 3 points."; points = 3;}
		if(entity.equals(EntityType.CAVE_SPIDER)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"cave spider"+ChatColor.DARK_AQUA+", earned 2 points."; points = 2;}
		if(entity.equals(EntityType.CREEPER)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"creeper"+ChatColor.DARK_AQUA+", earned 3 points."; points = 3;}
		if(entity.equals(EntityType.ENDER_DRAGON)){ frase = ChatColor.DARK_AQUA+"Has matado al "+ChatColor.DARK_PURPLE+"ender dragon"+ChatColor.DARK_AQUA+", earned 500 points"; points = 500;}
		if(entity.equals(EntityType.ENDERMAN)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"enderman"+ChatColor.DARK_AQUA+", earned 10 points"; points = 10;}
		if(entity.equals(EntityType.GHAST)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"ghast"+ChatColor.DARK_AQUA+", earned 5 points"; points = 5;}
		if(entity.equals(EntityType.GIANT)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"giant"+ChatColor.DARK_AQUA+", earned 8 points"; points = 8;}
		if(entity.equals(EntityType.MAGMA_CUBE)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"magma cube"+ChatColor.DARK_AQUA+", earned 1 point"; points = 1;}
		if(entity.equals(EntityType.PIG_ZOMBIE)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"pigman"+ChatColor.DARK_AQUA+", earned 7 points."; points = 7;}
		if(entity.equals(EntityType.SILVERFISH)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"silver fish"+ChatColor.DARK_AQUA+", earned 1 point."; points = 1;}
		if(entity.equals(EntityType.SKELETON)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"skeleton"+ChatColor.DARK_AQUA+", earned 2 points."; points = 2;}
		if(entity.equals(EntityType.SLIME)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"slime"+ChatColor.DARK_AQUA+", earned 1 point."; points = 1;}
		if(entity.equals(EntityType.SNOWMAN)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"snowman"+ChatColor.DARK_AQUA+", earned 0 points."; points = 0;}
		if(entity.equals(EntityType.SPIDER)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"spider"+ChatColor.DARK_AQUA+", earned 2 points."; points = 2;}
		if(entity.equals(EntityType.WITCH)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"witch"+ChatColor.DARK_AQUA+", earned 2 points."; points = 2;}
		if(entity.equals(EntityType.WITHER)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"whither"+ChatColor.DARK_AQUA+", earned 100 points."; points = 100;}
		if(entity.equals(EntityType.ZOMBIE)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"zombie"+ChatColor.DARK_AQUA+", earned 1 point."; points = 1;}
		
		//entity neutrals
		if(entity.equals(EntityType.BAT)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"bat"+ChatColor.DARK_AQUA+", earned 1 point."; points = 1;}
		if(entity.equals(EntityType.PLAYER)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"player"+ChatColor.DARK_AQUA+", earned 15 points."; points = 15;}
		if(entity.equals(EntityType.VILLAGER)){ frase = ChatColor.DARK_AQUA+"You have killed a "+ChatColor.DARK_PURPLE+"villager"+ChatColor.DARK_AQUA+", earned 0 points."; points = 0;}
		
		File fileplayer = new File(plugin.getDataFolder()+File.separator+"stats"+File.separator+killer.getName()+".yml");
		File folderstats = new File(plugin.getDataFolder()+File.separator+"stats");
		
		if(!folderstats.exists()){
			folderstats.mkdir();
		}
		
		YamlConfiguration pdata = YamlConfiguration.loadConfiguration(fileplayer);
		
		int current_points = 0;
		current_points = pdata.getInt("points.ammount");
		int tot = current_points + points;
		pdata.set("points.ammount", tot);
		
		int current_amm_entity = 0;
		current_amm_entity = pdata.getInt("kills."+entity);
		int tot2 = current_amm_entity + 1;
		pdata.set("kills."+entity, tot2);
		
		int tot3 = 0;
		tot3 = pdata.getInt("kills.total");
		pdata.set("kills.total", tot3+1);
		
		try {
			pdata.save(fileplayer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return frase;
	}
	
	//list of mobs
	public String getEntityNameES(EntityType entity, Player killer){
		
		int points = 0;
		String frase = null;
		frase = ChatColor.DARK_AQUA+"Null description, entity: "+ChatColor.DARK_PURPLE+""+entity;
		
		//animals
		if(entity.equals(EntityType.CHICKEN)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"pollo"+ChatColor.DARK_AQUA+", +1 punto."; points = 1;}
		if(entity.equals(EntityType.COW)){ frase = ChatColor.DARK_AQUA+"Has matado una "+ChatColor.DARK_PURPLE+"vaca"+ChatColor.DARK_AQUA+", +1 punto."; points = 1;}
		if(entity.equals(EntityType.OCELOT)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"ocelote"+ChatColor.DARK_AQUA+", +0 puntos."; points = 0;}
		if(entity.equals(EntityType.PIG)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"cerdo"+ChatColor.DARK_AQUA+", +1 punto."; points = 1;}
		if(entity.equals(EntityType.SHEEP)){ frase = ChatColor.DARK_AQUA+"Has matado una "+ChatColor.DARK_PURPLE+"oveja"+ChatColor.DARK_AQUA+", +1 punto."; points = 1;}
		if(entity.equals(EntityType.SQUID)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"calamar"+ChatColor.DARK_AQUA+", +1 punto."; points = 1;}
		if(entity.equals(EntityType.WOLF)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"lobo"+ChatColor.DARK_AQUA+", +0 puntos."; points = 0;}
		
		//mobs (monsters)
		if(entity.equals(EntityType.BLAZE)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"blaze"+ChatColor.DARK_AQUA+", +3 puntos."; points = 3;}
		if(entity.equals(EntityType.CAVE_SPIDER)){ frase = ChatColor.DARK_AQUA+"Has matado una "+ChatColor.DARK_PURPLE+"araña de cueva"+ChatColor.DARK_AQUA+", +2 puntos."; points = 2;}
		if(entity.equals(EntityType.CREEPER)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"creeper"+ChatColor.DARK_AQUA+", +3 puntos."; points = 3;}
		if(entity.equals(EntityType.ENDER_DRAGON)){ frase = ChatColor.DARK_AQUA+"Has matado al "+ChatColor.DARK_PURPLE+"dragón"+ChatColor.DARK_AQUA+", +500 puntos"; points = 500;}
		if(entity.equals(EntityType.ENDERMAN)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"enderman"+ChatColor.DARK_AQUA+", +10 puntos"; points = 10;}
		if(entity.equals(EntityType.GHAST)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"ghast"+ChatColor.DARK_AQUA+", +5 puntos"; points = 5;}
		if(entity.equals(EntityType.GIANT)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"gigante"+ChatColor.DARK_AQUA+", +8 puntos"; points = 8;}
		if(entity.equals(EntityType.MAGMA_CUBE)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"cubo de magma"+ChatColor.DARK_AQUA+", +1 punto"; points = 1;}
		if(entity.equals(EntityType.PIG_ZOMBIE)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"pigman"+ChatColor.DARK_AQUA+", +7 puntos."; points = 7;}
		if(entity.equals(EntityType.SILVERFISH)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"pecesillo de plata"+ChatColor.DARK_AQUA+", +1 punto."; points = 1;}
		if(entity.equals(EntityType.SKELETON)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"arquero"+ChatColor.DARK_AQUA+", +2 puntos."; points = 2;}
		if(entity.equals(EntityType.SLIME)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"slime"+ChatColor.DARK_AQUA+", +1 punto."; points = 1;}
		if(entity.equals(EntityType.SNOWMAN)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"muñeco de nieve"+ChatColor.DARK_AQUA+", +0 puntos."; points = 0;}
		if(entity.equals(EntityType.SPIDER)){ frase = ChatColor.DARK_AQUA+"Has matado una "+ChatColor.DARK_PURPLE+"araña"+ChatColor.DARK_AQUA+", +2 puntos."; points = 2;}
		if(entity.equals(EntityType.WITCH)){ frase = ChatColor.DARK_AQUA+"Has matado una "+ChatColor.DARK_PURPLE+"bruja"+ChatColor.DARK_AQUA+", +2 puntos."; points = 2;}
		if(entity.equals(EntityType.WITHER)){ frase = ChatColor.DARK_AQUA+"Has matado al "+ChatColor.DARK_PURPLE+"whither"+ChatColor.DARK_AQUA+", +100 puntos."; points = 100;}
		if(entity.equals(EntityType.ZOMBIE)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"zombie"+ChatColor.DARK_AQUA+", +1 punto."; points = 1;}
		
		//entity neutrals
		if(entity.equals(EntityType.BAT)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"murciélago"+ChatColor.DARK_AQUA+", +1 punto."; points = 1;}
		if(entity.equals(EntityType.PLAYER)){ frase = ChatColor.DARK_AQUA+"Has matado a un "+ChatColor.DARK_PURPLE+"jugador"+ChatColor.DARK_AQUA+", +15 puntos."; points = 15;}
		if(entity.equals(EntityType.VILLAGER)){ frase = ChatColor.DARK_AQUA+"Has matado un "+ChatColor.DARK_PURPLE+"aldeano"+ChatColor.DARK_AQUA+", +0 puntos."; points = 0;}
		
		File fileplayer = new File(plugin.getDataFolder()+File.separator+"stats"+File.separator+killer.getName()+".yml");
		File folderstats = new File(plugin.getDataFolder()+File.separator+"stats");
		
		if(!folderstats.exists()){
			folderstats.mkdir();
		}
		
		YamlConfiguration pdata = YamlConfiguration.loadConfiguration(fileplayer);
		
		int current_points = 0;
		current_points = pdata.getInt("points.ammount");
		int tot = current_points + points;
		pdata.set("points.ammount", tot);
		
		int current_amm_entity = 0;
		current_amm_entity = pdata.getInt("kills."+entity);
		int tot2 = current_amm_entity + 1;
		pdata.set("kills."+entity, tot2);
		
		int tot3 = 0;
		tot3 = pdata.getInt("kills.total");
		pdata.set("kills.total", tot3+1);
		
		try {
			pdata.save(fileplayer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return frase;
	}
}
