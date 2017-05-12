package eu.hyfoxkarm.utils;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import eu.hyfoxkarm.Main;

public class menu {

	private Player player;
	private Inventory inv;
	public menu(Player p, int size, String title) {
		   this.player = p;
		   this.inv = Bukkit.createInventory(player, size, title);
		   p.openInventory(inv);
	}
	
	  /*private final Main plugin;
	  
	  public menu(Main plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  public Inventory openGUI(Player p){
		  
		  Inventory inv = Bukkit.createInventory(p, 27, "");
		  
		  return inv;  
	  }*/
	
	  private ItemStack itemname(Material material, int amount, int shrt, String name, List<String> lore){
	    ItemStack item = new ItemStack(material, amount, (short)shrt);
	    ItemMeta meta = item.getItemMeta();
	    meta.setDisplayName(name);
	    meta.setLore(lore);
	    item.setItemMeta(meta);
	    return item;
	  }

}
