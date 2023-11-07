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

public class Farmer extends SubCMDS {
    public static HashMap<String, ItemStack[]> hashMap = new HashMap<>();
    @Override
    public String getName() {
        return "Farmer";
    }

    @Override
    public String getDescription() {
        return "A BackPack For Old Fighters Who Need Some Relaxing";
    }

    @Override
    public String getSyntax() {
        return "/BackPack Farmer";
    }

    @Override
    public String getPerms() {
        return "Ares_BackPack.Farmer";
    }

    @Override
    public void perform(Player player, String[] args) {
    Inventory customInventory = Bukkit.createInventory(player, 18, ChatColor.GREEN+player.getName()+"'s Farmer Inventory");
    ItemStack Carrot = new ItemStack(Material.CARROT, 64);
    ItemStack GoldenCarrot = new ItemStack(Material.GOLDEN_CARROT, 64);
    ItemStack Potato = new ItemStack(Material.POTATO, 64);
    ItemStack SilkHoe = new ItemStack(Material.NETHERITE_HOE);
    ItemStack FortuneHoe = new ItemStack(Material.NETHERITE_HOE);
    ItemStack Bottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
    ItemStack Composters = new ItemStack(Material.COMPOSTER, 64);
        /*=======================================================================================*/
        ItemMeta SilkMeta = SilkHoe.getItemMeta();
        ItemMeta FortuneMeta = FortuneHoe.getItemMeta();
        assert SilkMeta != null;
        assert FortuneMeta != null;
        /*=======================================================================================*/
        SilkMeta.setDisplayName(ChatColor.GRAY+ " Farmer's SilkTouch Hoe");
        FortuneMeta.setDisplayName(ChatColor.GRAY+ "Farmer's Fortune Hoe");
        /*=======================================================================================*/
        AddEnchantsToMeta.addUnbreaking(SilkMeta, 5, true);
        AddEnchantsToMeta.addUnbreaking(SilkMeta, 5, true);
        SilkMeta.addEnchant(Enchantment.MENDING,1 ,false);
        FortuneMeta.addEnchant(Enchantment.MENDING,1 ,false);
        AddEnchantsToMeta.addToolsEnchants(FortuneMeta, 7, true,"fortune", 10);
        AddEnchantsToMeta.addToolsEnchants(SilkMeta, 7, true,"Silk", 0);
        /*=======================================================================================*/
        SilkHoe.setItemMeta(SilkMeta);
        FortuneHoe.setItemMeta(FortuneMeta);
        /*=======================================================================================*/
        ItemStack[] items = new ItemStack[]{SilkHoe, FortuneHoe, Potato,GoldenCarrot,Carrot, Bottles,Composters};
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
