/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.mcbang.items.basic;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tk.gjz010.mcbang.BangPlayer;
import tk.gjz010.mcbang.MCBang;
import tk.gjz010.mcbang.items.BangItem;

/**
 *
 * @author Administrator
 */
public class BangCard implements BangItem{

    @Override
    public String getName() {
        return "Bang!";
    }

    @Override
    public List<String> getLore() {
        List<String> lores=new ArrayList<>();
        lores.add(MCBang.randomPoker());
        lores.add(ChatColor.WHITE+"Hit somebody who is in your range.");
        return lores;
    }

    @Override
    public String getPoker() {
        return MCBang.randomPoker();
    }

    @Override
    public ItemStack getItemStack() {
        ItemStack is=new ItemStack(Material.ARROW,1);
        ItemMeta meta=is.getItemMeta();
        meta.setDisplayName(getName());
        meta.setLore(getLore());
        is.setItemMeta(meta);
        return is;
    }

    @Override
    public void onAction(BangPlayer from, BangPlayer target) {
        from.getSession().bang(from, target);
    }
}
