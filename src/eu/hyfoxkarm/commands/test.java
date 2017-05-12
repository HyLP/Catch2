package eu.hyfoxkarm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import eu.hyfoxkarm.Main;
import eu.hyfoxkarm.utils.menu;

public class test implements CommandExecutor{

	menu m;
	
	  private final Main plugin;
	  
	  public test (Main plugin)
	  {
	    this.plugin = plugin;
	  }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		plugin.getMenu().set("Inventory-Title", "Benvenuto");
		m = new menu(p, 27, plugin.getMenu().getString("Inventory-Title"));
		return false;
	}

}
