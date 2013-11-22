package me.messageofdeath.MobLimit;

import java.util.ArrayList;
import java.util.logging.Logger;

import me.messageofdeath.MobLimit.Listener.EntityListener;
import me.messageofdeath.MobLimit.Timer.Timer;
import me.messageofdeath.MobLimit.Utils.MobManager.MobManager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MobLimit extends JavaPlugin {
	
	private Timer timer;
	private MobManager mobManager;

	@Override
	public void onEnable() {
		this.mobManager = new MobManager();
		super.getServer().getPluginManager().registerEvents(new EntityListener(this), this);
		long ticks = super.getServer().getWorlds().get(0).getTicksPerMonsterSpawns() * 2;
		this.timer = new Timer(ticks);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, this.timer, 1L, 1L);
	}
	
	//************************* Logging *****************************
	
	public void log(String log) {
		super.getServer().getLogger().info(log);
	}
	
	public void logError(String topic, String classx, String method, String error) {
		Logger log = super.getServer().getLogger();
		final String space = "                                                             ";
		String text = "Topic";
		log.severe("______________________{MobLimit Error}_____________________");
		log.severe(space.substring((space.length() + text.length()) / 2, space.length()) + text);
		log.severe(space.substring((space.length() + topic.length()) / 2, space.length()) + topic);
		log.severe("");
		for(String s : this.getLines(error, space)) {
			log.severe(space.substring((space.length() + s.length()) / 2, space.length()) + s);
		}
		log.severe("");
		String cl = "Class: " + classx + "   Method: " + method;
		for(String s : this.getLines(cl, space)) {
			log.severe(space.substring((space.length() + s.length()) / 2, space.length()) + s);
		}
		log.severe("");
		log.severe("----------------------{MobLimit Error}---------------------");
	}
	
	private ArrayList<String> getLines(String parse, final String space) {
		ArrayList<String> lines = new ArrayList<String>();
		String s = "";
		String[] split = parse.split(" ");
		final int length = split.length;
		for(int i = 0; i < length; i++) {
			if(s.length() + split[i].length() < space.length()) {
				s += split[i] + " ";
			}else{
				lines.add(s);
				s = split[i] + " ";
			}
			if(i + 1 == length) {
				lines.add(s);
			}
		}
		return lines;
	}
	
	//********************** Getting ************************
	
	public Timer getTimer() {
		return this.timer;
	}
	
	public MobManager getMobManager() {
		return this.mobManager;
	}
}
