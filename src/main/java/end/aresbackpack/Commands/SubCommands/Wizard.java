package end.aresbackpack.Commands.SubCommands;

import end.aresbackpack.Commands.SubCMDS;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.HashMap;

public class Wizard extends SubCMDS {
    public static HashMap<String, ItemStack[]> hashMap = new HashMap<>();
    @Override
    public String getName() {
        return "Wizard";
    }

    @Override
    public String getDescription() {
        return "A Role For Those Who Are Really Into Enchants ";
    }

    @Override
    public String getSyntax() {
        return "/BackPack Wizard";
    }

    @Override
    public String getPerms() {
        return "Ares_BackPack.Wizard";
    }

    @Override
    public void perform(Player player, String[] args) {
        Inventory customInventory = Bukkit.createInventory(player, 18, ChatColor.DARK_PURPLE+player.getName()+"'s Wizard Inventory");
        /*=======================================================================================*/
        ItemStack EnhancedUnBreaking = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemStack EnhancedProtection = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemStack EnhancedFortune = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemStack Bottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
        ItemStack Anvil = new ItemStack(Material.ANVIL, 32);
        ItemStack Books = new ItemStack(Material.BOOKSHELF, 32);
        ItemStack EnchantedTable = new ItemStack(Material.ENCHANTING_TABLE, 8);
        /*=======================================================================================*/
        EnchantmentStorageMeta UnBreakingMeta = (EnchantmentStorageMeta) EnhancedUnBreaking.getItemMeta();
        EnchantmentStorageMeta EnhancedProtectionMeta = (EnchantmentStorageMeta) EnhancedProtection.getItemMeta();
        EnchantmentStorageMeta EnhancedFortuneMeta = (EnchantmentStorageMeta) EnhancedFortune.getItemMeta();
        assert UnBreakingMeta != null;
        assert EnhancedProtectionMeta != null;
        assert EnhancedFortuneMeta != null;
        /*=======================================================================================*/
        UnBreakingMeta.setDisplayName(ChatColor.DARK_PURPLE+"Enhanced Unbreaking");
        EnhancedProtectionMeta.setDisplayName(ChatColor.DARK_PURPLE+"Enhanced Protection");
        EnhancedFortuneMeta.setDisplayName(ChatColor.DARK_PURPLE+"Enhanced Fortune");
        /*=======================================================================================*/
        EnhancedProtectionMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
        UnBreakingMeta.addStoredEnchant(Enchantment.DURABILITY, 6, true);
        EnhancedFortuneMeta.addStoredEnchant(Enchantment.LOOT_BONUS_BLOCKS, 7, true);
        /*=======================================================================================*/
        EnhancedFortune.setItemMeta(EnhancedFortuneMeta);
        EnhancedProtection.setItemMeta(EnhancedProtectionMeta);
        EnhancedUnBreaking.setItemMeta(UnBreakingMeta);
        /*=======================================================================================*/
        ItemStack[] items = new ItemStack[]{EnhancedProtection, EnhancedFortune, EnhancedUnBreaking, Bottles, Bottles, Anvil, Books, EnchantedTable};
        /*=======================================================================================*/
        if(!hashMap.containsKey(player.getUniqueId().toString())) {
            customInventory.setContents(items);
            hashMap.put(player.getUniqueId().toString(), items);
        }else{
            customInventory.setContents(hashMap.get(player.getUniqueId().toString()));
        }
        player.openInventory(customInventory);
    }
}
