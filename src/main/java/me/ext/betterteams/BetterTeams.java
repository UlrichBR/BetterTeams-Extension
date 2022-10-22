package me.ext.betterteams;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import me.ext.betterteams.manager.AddonFiles;
import me.ext.betterteams.manager.Implementation;
import me.ulrich.koth.Koth;
import me.ulrich.koth.data.Extension;

public class BetterTeams extends Extension {

	private static BetterTeams extensionCore;
	private static Koth kothCore;
	private Logger logger = null;
	private AddonFiles files;

	@Override
	public void onEnable() {
		extensionCore = this;
		kothCore = (Koth) getInstance();
		this.logger = Logger.getLogger(this.getName());

		this.files = new AddonFiles(this);
		
		if (Bukkit.getPluginManager().isPluginEnabled("BetterTeams")) {

			Plugin clan = Bukkit.getPluginManager().getPlugin("BetterTeams");

			
			if(this.files.getConfig().getBoolean("Config.use_this")) {
				if(clan!=null) {
					if(!kothCore.getKothAPI().hasGroupImplemented()) {
						Implementation impl = new Implementation(clan);
						kothCore.getKothAPI().addGroupImplement(impl);
						kothCore.getLogger().info(" - BetterTeams ("+clan.getDescription().getVersion()+") [USING]");
						kothCore.getExtensionEnabledList().put(this, true);
						return;
					}
				}
			}

			
		}
		
		kothCore.getExtensionEnabledList().put(this, false);

		
	}


	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	public static BetterTeams getExtensionCore() {
		return extensionCore;
	}

	public static Koth getKothCore() {
		return kothCore;
	}


	public Logger getLogger() {
		return logger;
	}


	public AddonFiles getFiles() {
		return files;
	}



}
