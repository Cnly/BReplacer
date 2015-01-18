package com.github.Cnly.BReplacer.BReplacer;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    
    private static Main instance = null;
    
    @Override
    public void onEnable()
    {
        
        instance = this;
        
        saveDefaultConfig();
        
        getCommand("brp").setExecutor(this);
        
    }
    
    @Override
    public void onDisable()
    {
        // Do nothing.
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args)
    {
        
        List<String> pathList = getConfig().getStringList("pluginPaths");
        
        if (!sender.hasPermission("BReplacer.use"))
        {
            
            sender.sendMessage(ChatColor.RED + "You don't have permission!");
            
            return true;
        }
        
        if (pathList.isEmpty())
        {
            
            getLogger().info("No plugins to be replaced.");
            
            return true;
        }
        
        getLogger().info(
                getDescription().getName() + " "
                        + getDescription().getVersion() + " By Cnly");
        getLogger().info("Replacing started.");
        
        for (String path : pathList)
        {
            
            File f = new File(path);
            File d = new File("plugins/" + f.getName());
            
            if (!f.exists())
            {
                
                getLogger().info("File " + path + "not exists. Skipped.");
                
                continue;
            }
            
            FileUtils.copyFile(f, d);
            
            getLogger().info("Replaced: " + f.getName());
            
        }
        
        getLogger().info("All files replaced. Reloading server...");
        
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reload");
        
        return true;
    }
    
    public static Main getInstance()
    {
        return instance;
    }
    
}
