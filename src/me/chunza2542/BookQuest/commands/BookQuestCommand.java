package me.chunza2542.BookQuest.commands;

import me.chunza2542.BookQuest.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

/**
 * Created by chunza2542 on 6/2/17.
 */
public class BookQuestCommand implements CommandExecutor{

    Main instance;

    public BookQuestCommand(Main plugin){
        this.instance = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            if(!sender.isOp()){
                sender.sendMessage(ChatColor.DARK_RED + "[BookQuest] You have no permission to access this command!");
                return true;
            }
        }
        instance.getHelper().openBook(instance.getHelper().book("TILE","CHUN", "aasd", "asdasd"), (Player) sender);
        return true;
    }
}
