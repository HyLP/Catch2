package eu.hyfoxkarm;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import eu.hyfoxkarm.commands.catchc;
import eu.hyfoxkarm.commands.test;
import eu.hyfoxkarm.events.OnJoin;
import eu.hyfoxkarm.utils.ConfigFile;
import eu.hyfoxkarm.utils.CountDown;

public class Main extends JavaPlugin{
	
	public static int startCountdownId;
	private static ConfigFile menu;
	
	@Override
	public void onEnable(){
		menu = new ConfigFile(this, "menu");
		registerCommands();
		registerEvents();
		System.out.println("Plugin now enabled!");
	}
	
	@Override
	public void onDisable(){
		
	}
	
	public void registerCommands(){
		getCommand("catch").setExecutor(new catchc());
		getCommand("test").setExecutor(new test(this));
	}
	
	public void registerEvents(){
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new OnJoin(this), this);
	}
	
    public static ConfigFile getMenu() {
        return menu;
    }
	
	@SuppressWarnings("deprecation")
	public void startCountdown(){
		CountDown.i = 60;
		startCountdownId = getServer()
				.getScheduler()
				.scheduleSyncRepeatingTask(this, new CountDown(this), 20l, 20l);
	}
	
	public void stopCountdown(){
		getServer().getScheduler().cancelTask(startCountdownId);
	}
	
	public void restartCountdown(){
		stopCountdown();
		startCountdown();
	}
}
