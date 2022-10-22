package me.ext.betterteams.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.booksaw.betterTeams.Team;

import me.ulrich.koth.interfaces.GroupAPI;

public class Implementation implements GroupAPI {

	private Plugin clanAPI = null;
	private Plugin plugin;


	public Implementation(Plugin plugin) {
	
		this.plugin = plugin;
		this.clanAPI = plugin;
		
	}
	
	public String getPluginVersion() {
		
		return getPlugin().getDescription().getVersion();
		
	}

	public String getGroupName(Player player) {
		
		if(getClanAPI()!=null) {
			
			Team team = Team.getTeam(player);
			
			if(team!=null) {
				return ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', team.getTag()));
			} 
		}
		
		return me.ext.betterteams.BetterTeams.getExtensionCore().getFiles().getConfig().getString("Language.player no group");
		
	}
	
	public String getGroupName(UUID player) {
		
		if(getClanAPI()!=null) {
			
			try {
				Player online = Bukkit.getPlayer(player);

				if(online.isOnline()) {
					Team team = Team.getTeam(online);
					
					if(team!=null) {
						return ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', team.getTag()));
					} 
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return me.ext.betterteams.BetterTeams.getExtensionCore().getFiles().getConfig().getString("Language.player no group");
		
	}
	

	public boolean playerHasGroup(Player player) {
		
		if(getClanAPI()!=null) {
						
			Team team = Team.getTeam(player);
						
			return (team!=null);
		}
		
		return false;
		
	}
	

	public boolean playerHasGroup(UUID player) {
		
		if(getClanAPI()!=null) {

			try {
				Player online = Bukkit.getPlayer(player);

				if(online.isOnline()) {
					Team team = Team.getTeam(online);
									
					return (team!=null);
				}
			} catch (Exception e) {}
			
			
		}
		
		return false;
		
	}
	

	public List<UUID> getGroupOnlineMembers(Player player) {

		Team team = Team.getTeam(player);
		
		if(team!=null) {
			ArrayList<UUID> onlines = new ArrayList<UUID>();
			
			team.getOnlineMemebers().iterator().forEachRemaining(uuid->{
				onlines.add(uuid.getUniqueId());
			});
		}

		return new ArrayList<UUID>();
	}


	public List<UUID> getGroupOnlineMembers(UUID player) {

		try {
			Player online = Bukkit.getPlayer(player);

			if(online.isOnline()) {
				Team team = Team.getTeam(online);
				
				if(team!=null) {

					ArrayList<UUID> onlines = new ArrayList<UUID>();
					
					team.getOnlineMemebers().iterator().forEachRemaining(uuid->{
						onlines.add(uuid.getUniqueId());
					});
					
				}
			}
		} catch (Exception e) {}
		
		
		
		
		return new ArrayList<UUID>();
	}

	public Plugin getClanAPI() {
		return clanAPI;
	}

	public Plugin getPlugin() {
		return plugin;
	}



}
