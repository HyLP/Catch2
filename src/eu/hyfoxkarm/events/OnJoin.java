package eu.hyfoxkarm.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import eu.hyfoxkarm.Main;

public class OnJoin implements Listener{
	
	  private final Main plugin;
	  
	  public OnJoin(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		plugin.getConfig().set("Message-On-Join", "Benvenuto");
		p.sendMessage(plugin.getConfig().getString("Message-On-Join"));
	}

}
