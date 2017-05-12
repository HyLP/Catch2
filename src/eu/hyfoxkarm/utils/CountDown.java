package eu.hyfoxkarm.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import eu.hyfoxkarm.Main;

public class CountDown extends BukkitRunnable {

	Main pl;
	
	public CountDown(Main plugin){
		pl = plugin;
	}
	
	public static int i;
	
	@Override
	public void run() {
		if (i == 0) {
			if(Game.canStart() == false){
				pl.restartCountdown();
				Game.broadcast(ChatColor.GRAY + "La partita non puo' iniziare, servono almeno 4 player  (" + ChatColor.GREEN + Bukkit.getOnlinePlayers().size() + ChatColor.GRAY + "/" + ChatColor.GREEN + "8" + ChatColor.GRAY + ")");
				return;
			}
			Game.start();
			pl.stopCountdown();
		}
		
		else {
			if (i==60 || i == 30 || i == 15 || i == 10 || i == 5 || i == 4 || i == 3 || i == 2 || i == 1) {
				Game.broadcast(ChatColor.GRAY + "La partita inizia tra " + ChatColor.GREEN + i + ChatColor.GRAY +" secondi. (" + ChatColor.GREEN + Bukkit.getOnlinePlayers().size() + ChatColor.GRAY + "/" + ChatColor.GREEN + "8" + ChatColor.GRAY + ")");
			}
			i--;
		}
	}
}