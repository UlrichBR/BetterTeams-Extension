package me.ext.betterteams.EnumFiles;

import me.ulrich.econfig.interfaces.ConfigurationEnum;

public enum Config implements ConfigurationEnum {

    CONFIG_date_format("Config.use_this", false, "#"),
    CONFIG_LANGUAGE_player_no_group("Language.player no group","<red>No Team"),

    ;
	
	private String path;
    private Object defaultValue;
    private String[] comments;

    Config(String path, Object defaultValue, String... comments) {
        this.path = path;
        this.defaultValue = defaultValue;
        this.comments = comments;
    }

    public String getPath() {
    	
        return path;
    }

 
    public Object getDefaultValue() {
        return defaultValue;
    }

    
    public String[] getComments() {
        return comments;
    }
}
