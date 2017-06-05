package me.chunza2542.BookQuest.commands;

import me.chunza2542.BookQuest.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
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

        if(args.length < 1){
            sender.sendMessage(ChatColor.YELLOW + "[BookQuest] Help BookQuest");
            sender.sendMessage(instance.getHelper().translate("&6/bookquest open <player> <bookname>: &fOpen book!"));
            sender.sendMessage(instance.getHelper().translate("&6/bookquest openall <bookname>: &fOpen all players."));
            sender.sendMessage(instance.getHelper().translate("&6/bookquest reload: &fReload the config."));
            return true;
        }

        if(args[0].equalsIgnoreCase("open")){
            if(args.length < 3){
                sender.sendMessage(ChatColor.RED + "[BookQuest] usage: /bookquest open <player> <bookname>");
                return true;
            }
            Player target = Bukkit.getPlayer(args[1]);
            if(target == null){
                sender.sendMessage(ChatColor.DARK_RED + "Not found this player on the server!");
                return true;
            }
            if(!instance.getConfig().contains(args[2])){
                sender.sendMessage(ChatColor.DARK_RED + "Not found this book name in the config, please check!");
                return true;
            }
            ItemStack book = instance.getBook().createBook("BookQuest", "Chun Rapeepat",
                    instance.getHelper().toBookData((ArrayList<String>) instance.getConfig().getStringList(args[2])));
            instance.getBook().openBook(target, book);
            return true;
        }

        if(args[0].equalsIgnoreCase("openall")){
            if(args.length < 2){
                sender.sendMessage(ChatColor.RED + "[BookQuest] usage: /bookquest openall <bookname>");
                return true;
            }
            if(!instance.getConfig().contains(args[1])){
                sender.sendMessage(ChatColor.DARK_RED + "Not found this book name in the config, please check!");
                return true;
            }
            ItemStack book = instance.getBook().createBook("BookQuest", "Chun Rapeepat",
                    instance.getHelper().toBookData((ArrayList<String>) instance.getConfig().getStringList(args[1])));
            for(Player p : Bukkit.getOnlinePlayers()){
                instance.getBook().openBook(p, book);
            }
            return true;
        }


        if(args[0].equalsIgnoreCase("reload")){
            sender.sendMessage(ChatColor.GREEN + "[BookQuest] Reloaded BookQuest Config!");
            instance.reloadConfig();
            return true;
        }

        return true;
    }

}
