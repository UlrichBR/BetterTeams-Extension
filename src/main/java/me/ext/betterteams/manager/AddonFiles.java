package me.ext.betterteams.manager;

import java.io.File;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;

import me.ext.betterteams.BetterTeams;
import me.ext.betterteams.EnumFiles.Config;
import me.ulrich.econfig.EnumConfiguration;
import me.ulrich.econfig.EnumConfigurationBuilder;

public class AddonFiles {

	public HashMap<String, Files> files = new HashMap<String, Files>();
	public HashMap<String, EnumConfiguration> server_files = new HashMap<String, EnumConfiguration>();
	public String finalLang = null;
	private final BetterTeams addon;
	
	public AddonFiles(BetterTeams war) {
		this.addon = war;
		
		this.files = new HashMap<String, Files>();
		this.server_files = new HashMap<String, EnumConfiguration>();
	
		setupConfig();
		setupFiles();
	
		
	}
	
	public void setupConfig() {
		
		File config_file = new File(BetterTeams.getExtensionCore().getAddonDataFolder(), "config.yml");
		EnumConfiguration conf = new EnumConfigurationBuilder(config_file, Config.class).build("");
		this.server_files.put("config", conf);


	}

	public void setupFiles() {

		Files server_config = new Files(BetterTeams.getKothCore() ,BetterTeams.getExtensionCore().getAddonDataFolder(), "", "config", "config", "yml"); // FOI
		this.files.put("config", server_config);


	}



	public static boolean mkdir(String path) {
		File f = new File(path);
		if(!f.exists()) {
			if(f.mkdir()) {
				return true;
			}
		} else {
			return true;
		}
		return false;
         
	}
	
	public void clearFiles() {
		getServerFiles().clear();
		getHashFiles().clear();
	}

	public HashMap<String, EnumConfiguration> getServerFiles() {
		return this.server_files;
	}
	
	public HashMap<String, Files> getHashFiles() {
		return this.files;
	}
	
	public FileConfiguration getConfig(){
		return getHashFiles().get("config").get();
	}

	public BetterTeams getAddon() {
		return addon;
	}
	

}
