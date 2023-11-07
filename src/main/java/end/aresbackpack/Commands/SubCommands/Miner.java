package end.aresbackpack.Commands.SubCommands;

import end.aresbackpack.Commands.SubCMDS;
import end.aresbackpack.CustomClasses.AddEnchantsToMeta;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class Miner extends SubCMDS {
    public static HashMap<String, ItemStack[]> hashMap = new HashMap<>();
    @Override
    public String getName() {
        return "Miner";
    }

    @Override
    public String getDescription() {
        return "A BackPack Made For Players With The Miner Role";
    }

    @Override
    public String getSyntax() {
        return "/BackPack Miner";
    }

    @Override
    public String getPerms() {
        return "Ares_BackPack.Miner";
    }

    @Override
    public void perform(Player player, String[] args) {
    Inventory customInventory = Bukkit.createInventory(player, 18, ChatColor.GRAY+player.getName()+"'s Miner Inventory");
        ItemStack Bottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
        ItemStack SilkPick = new ItemStack(Material.NETHERITE_PICKAXE, 1);
        ItemStack FortunePick = new ItemStack(Material.NETHERITE_PICKAXE, 1);
        ItemStack Furnaces = new ItemStack(Material.FURNACE, 16);
        ItemStack Coal = new ItemStack(Material.COAL_BLOCK, 16);
        ItemStack Shulker = new ItemStack(Material.SHULKER_BOX);
        /*=======================================================================================*/
        ItemMeta SilkMeta = SilkPick.getItemMeta();
        ItemMeta FortuneMeta = FortunePick.getItemMeta();
        assert SilkMeta != null;
        assert FortuneMeta != null;
        /*=======================================================================================*/
        SilkMeta.setDisplayName(ChatColor.GRAY+ "Miner SilkTouch PickAxe");
        FortuneMeta.setDisplayName(ChatColor.GRAY+ "Miner Fortune PickAxe");
        /*=======================================================================================*/
        AddEnchantsToMeta.addUnbreaking(SilkMeta, 5, true);
        AddEnchantsToMeta.addUnbreaking(SilkMeta, 5, true);
        SilkMeta.addEnchant(Enchantment.MENDING,1 ,false);
        FortuneMeta.addEnchant(Enchantment.MENDING,1 ,false);
        AddEnchantsToMeta.addToolsEnchants(FortuneMeta, 7, true,"fortune", 5);
        AddEnchantsToMeta.addToolsEnchants(SilkMeta, 7, true,"Silk", 0);
        /*=======================================================================================*/
        SilkPick.setItemMeta(SilkMeta);
        FortunePick.setItemMeta(FortuneMeta);
        /*=======================================================================================*/
        ItemStack[] items = new ItemStack[]{SilkPick, FortunePick, Bottles, Furnaces, Coal, Shulker};
        if(!hashMap.containsKey(player.getUniqueId().toString())) {
            customInventory.setContents(items);
            hashMap.put(player.getUniqueId().toString(), items);
        }else{
            customInventory.setContents(hashMap.get(player.getUniqueId().toString()));
        }
        player.openInventory(customInventory);
    }
}
