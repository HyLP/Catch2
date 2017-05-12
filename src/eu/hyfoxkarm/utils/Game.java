package eu.hyfoxkarm.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Game {
	
	public static boolean canStart;
	
	public static void start(){
		
	}

	public static void broadcast(String mex) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(mex);
		}
	}
	
	public static boolean canStart(){
		if(Bukkit.getOnlinePlayers().size() >= 1){
			canStart = true;
			return canStart;
		}
		canStart = false;
		return canStart;
	}
}
