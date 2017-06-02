package me.chunza2542.BookQuest;

import me.chunza2542.BookQuest.commands.BookCommand;
import me.chunza2542.BookQuest.commands.BookQuestCommand;
import me.chunza2542.BookQuest.versions.BookQuest;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by chunza2542 on 6/2/17.
 */
public class Main extends JavaPlugin{

    BookQuestHelper helper;
    BookQuest book;

    public void onEnable(){
        helper = new BookQuestHelper();

        helper.info("[BookQuest] This plugin created by Chun Rapeepat @chunza2542.");
        helper.info("[BookQuest] You are running on server version " + helper.getVersion());

        if(helper.isVersionSupported("v1_8_R1"
                                    ,"v1_8_R2"
                                    ,"v1_8_R3"
                                    ,"v1_9_R1"
                                    ,"v1_9_R2"
                                    ,"v1_10_R1"
                                    ,"v1_11_R1")) {

            /* Supported Version */
            saveDefaultConfig();

            /* Register Some Command*/
            getCommand("book").setExecutor(new BookCommand(this));
            getCommand("bookquest").setExecutor(new BookQuestCommand(this));

            /* BookQuest NMS */
            try {
                Class<?> subClass = Class.forName("me.chunza2542.BookQuest.versions.BookQuest_" + helper.getVersion());
                try {
                    book = (BookQuest) subClass.getConstructor().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else{
            helper.info("[BookQuest] It seems like you are not running a supported version of server.");
        }
    }

    public BookQuestHelper getHelper(){
        return this.helper;
    }

    public BookQuest getBook() {
        return this.book;
    }

}
