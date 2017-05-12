package eu.hyfoxkarm.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class catchc implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("help")){
				p.sendMessage("Ciao!");
			}
			if(args[0].equalsIgnoreCase("setspawn")){
				if (p.hasPermission("catch.setlobby"))
			    {
			      File spawn = new File("plugins//Catch//spawn.yml");
			      if (!spawn.exists()) {
			        try
			        {
			          spawn.createNewFile();
			        }
			        catch (IOException e)
			        {
			          p.sendMessage("Non riesco a creare il file!");
			        }
			      }
			      YamlConfiguration cf = YamlConfiguration.loadConfiguration(spawn);
			      Location lobby = p.getLocation();
			      
			      double x = lobby.getX();
			      double y = lobby.getY();
			      double z = lobby.getZ();
			      double yaw = lobby.getYaw();
			      double pitch = lobby.getPitch();
			      String mondo = lobby.getWorld().getName();
			      
			      cf.set("X", Double.valueOf(x));
			      cf.set("Y", Double.valueOf(y));
			      cf.set("Z", Double.valueOf(z));
			      cf.set("Yaw", Double.valueOf(yaw));
			      cf.set("Pitch", Double.valueOf(pitch));
			      cf.set("Mondo", mondo);
			      try
			      {
			        cf.save(spawn);
			      }
			      catch (IOException e)
			      {
			        e.printStackTrace();
			      }
			      p.sendMessage("§aCatch >§7 Spawn setted!");
			    }
			    return false;
			}
		    if(args[0].equalsIgnoreCase("spawn")){
		    	if (p.hasPermission("catch.spawn"))
			    {
			      File spawn = new File("plugins//Catch//spawn.yml");
			      if (!spawn.exists())
			      {
			        try
			        {
			          spawn.createNewFile();
			        }
			        catch (IOException e)
			        {
			          p.sendMessage("§7Unable to create the file!");
			        }
			        p.sendMessage("§7The spawn has been §csetted§7!");
			        return true;
			      }
			      Location lobby = p.getLocation();
			      YamlConfiguration cf = YamlConfiguration.loadConfiguration(spawn);
			      
			      double x = cf.getDouble("X");
			      double y = cf.getDouble("Y");
			      double z = cf.getDouble("Z");
			      double yaw = cf.getDouble("Yaw");
			      double pitch = cf.getDouble("Pitch");
			      String mondo = cf.getString("Mondo");
			      
			      World mappa = Bukkit.getWorld(mondo);
			      
			      lobby.setX(x);
			      lobby.setY(y);
			      lobby.setZ(z);
			      lobby.setYaw((float)yaw);
			      lobby.setPitch((float)pitch);
			      lobby.setWorld(mappa);
			      
			      p.teleport(lobby);
			      
			      return true;
			    }
		    }
		}
		return false;
	}

}
