package me.chunza2542.BookQuest.commands;

import me.chunza2542.BookQuest.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by chunza2542 on 6/2/17.
 */
public class BookCommand implements CommandExecutor{

    Main instance;

    public BookCommand(Main plugin){
        this.instance = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
}
