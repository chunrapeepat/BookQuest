package me.chunza2542.BookQuest.versions;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by chunza2542 on 6/2/17.
 */
public interface BookQuest {

    void openBook(Player player, ItemStack book);
    ItemStack createBook(String title, String author, String... pages);

}
