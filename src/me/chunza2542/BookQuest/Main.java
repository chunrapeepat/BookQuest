package me.chunza2542.BookQuest;

import me.chunza2542.BookQuest.commands.BookCommand;
import me.chunza2542.BookQuest.commands.BookQuestCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by chunza2542 on 6/2/17.
 */
public class Main extends JavaPlugin{

    BookQuestHelper helper;

    public void onEnable(){
        Bukkit.getServer().getLogger().info("[BookQuest] This plugin created by Chun Rapeepat @chunza2542");
        /* Save default config */
        saveDefaultConfig();
        /* Register some commands */
        getCommand("book").setExecutor(new BookCommand(this));
        getCommand("bookquest").setExecutor(new BookQuestCommand(this));
        /* BookQuestHelper */
        helper = new BookQuestHelper();
    }

    public BookQuestHelper getHelper(){
        return this.helper;
    }

}
