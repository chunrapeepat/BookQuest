package me.chunza2542.BookQuest;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.server.v1_11_R1.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chunza2542 on 6/2/17.
 */
public class BookQuestHelper {

    public ArrayList<String> toBookData(ArrayList<String> olddata){
        ArrayList<String> data = new ArrayList<String>();
        for(String each : olddata){
            data.add(translate(each).replaceAll("\\#", "\n"));
        }
        return data;
    }

    public String translate(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public void info(String msg){
        Bukkit.getServer().getLogger().info(translate(msg));
    }

    public Boolean isVersionSupported(String... versions) {
        for(String version : versions){
            if(version.equalsIgnoreCase(getVersion())){
                return true;
            }
        }
        return false;
    }

    public String getVersion(){
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    }

    public Class<?> getNMSClass(String name) {
        try {
            return Class.forName("net.minecraft.server." + getVersion() + "." + name);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
