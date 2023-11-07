package end.aresbackpack.Events;

import end.aresbackpack.AresBackPack;
import end.aresbackpack.Commands.SubCommands.*;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class InventoryOff implements Listener {
    Plugin plugin = AresBackPack.getPlugin(AresBackPack.class);
    String[] InventoryNames = new String[]{plugin.getConfig().getString("VIPInventoryName"),
            plugin.getConfig().getString("DefaultInventoryName"),
            plugin.getConfig().getString("MinerInventoryName"),
            plugin.getConfig().getString("LumberJackInventoryName"),
            plugin.getConfig().getString("WizardInventoryName"),
            plugin.getConfig().getString("ArmorerInventoryName"),
            plugin.getConfig().getString("FighterInventoryName"),
            plugin.getConfig().getString("ScavengerInventoryName"),
            plugin.getConfig().getString("FarmerInventoryName")};
    @EventHandler
    public void onInventoryInteract(InventoryCloseEvent e){
        for (String inventoryName : InventoryNames) {
            if (ChatColor.stripColor(e.getView().getTitle()).contains(inventoryName)) {
                if (ChatColor.stripColor(e.getView().getTitle()).contains("VIP")) {
                    VIP.hashMap.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
                }
                if(ChatColor.stripColor(e.getView().getTitle()).contains("Default")){
                    Default.hashMap.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
                }
                if(ChatColor.stripColor(e.getView().getTitle()).contains("Miner")){
                        Miner.hashMap.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
                }
                if(ChatColor.stripColor(e.getView().getTitle()).contains("LumberJack")){
                    LumberJack.hashMap.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
                }
                if(ChatColor.stripColor(e.getView().getTitle()).contains("Wizard")){
                    Wizard.hashMap.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
                }
                if(ChatColor.stripColor(e.getView().getTitle()).contains("Scavenger")){
                    Scavenger.hashMap.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
                }
                if(ChatColor.stripColor(e.getView().getTitle()).contains("Armorer")){
                    Armorer.hashMap.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
                }
                if(ChatColor.stripColor(e.getView().getTitle()).contains("Fighter")){
                    Fighter.hashMap.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
                }
                if(ChatColor.stripColor(e.getView().getTitle()).contains("Farmer")){
                    Farmer.hashMap.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
                }
            }
        }
    }
}
