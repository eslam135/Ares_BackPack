package end.aresbackpack.Commands.SubCommands;

import end.aresbackpack.Commands.SubCMDS;
import end.aresbackpack.CustomClasses.AddEnchantsToMeta;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.data.type.Fire;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class Scavenger extends SubCMDS {
    public static HashMap<String, ItemStack[]> hashMap = new HashMap<>();
    @Override
    public String getName() {
        return "Scavenger";
    }

    @Override
    public String getDescription() {
        return "A BackPack For Those Who Like Exploring The World";
    }

    @Override
    public String getSyntax() {
        return "/BackPack Scavenger";
    }

    @Override
    public String getPerms() {
        return "Ares_BackPack.Scavenger";
    }

    @Override
    public void perform(Player player, String[] args) {
        Inventory customInventory = Bukkit.createInventory(player, 18, ChatColor.GOLD+player.getName()+"'s Scavenger Inventory");
        ItemStack Bottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
        ItemStack Elytra = new ItemStack(Material.ELYTRA, 1);
        ItemStack FireWorks = new ItemStack(Material.FIREWORK_ROCKET, 64);
        /*=======================================================================================*/
        FireworkMeta FireWorkMeta = (FireworkMeta) FireWorks.getItemMeta();
        assert FireWorkMeta != null;
        FireWorkMeta.setPower(5);
        FireWorkMeta.setDisplayName(ChatColor.GOLD+"Enhanced Fireworks");
            FireWorks.setItemMeta(FireWorkMeta);
        /*=======================================================================================*/
        ItemMeta ElytraMeta = Elytra.getItemMeta();
        ElytraMeta.setDisplayName(ChatColor.GOLD+"Scavenger Wings");
        AddEnchantsToMeta.addUnbreaking(ElytraMeta, 5, true);
        ElytraMeta.addEnchant(Enchantment.MENDING, 1, false);
        Elytra.setItemMeta(ElytraMeta);
        /*=======================================================================================*/
        ItemStack[] items = new ItemStack[]{Elytra, Elytra, Bottles, Bottles, FireWorks, FireWorks, FireWorks};
        if(!hashMap.containsKey(player.getUniqueId().toString())) {
            customInventory.setContents(items);
            hashMap.put(player.getUniqueId().toString(), items);
        }else{
            customInventory.setContents(hashMap.get(player.getUniqueId().toString()));
        }
        player.openInventory(customInventory);
    }
}
