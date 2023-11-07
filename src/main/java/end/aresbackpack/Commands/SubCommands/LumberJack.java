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

public class LumberJack extends SubCMDS {
    public static HashMap<String, ItemStack[]> hashMap = new HashMap<>();

    @Override
    public String getName() {
        return "LumberJack";
    }

    @Override
    public String getDescription() {
        return "A BackPack For Those Who Admire Wood Chopping";
    }

    @Override
    public String getSyntax() {
        return "/BackPack LumberJack";
    }

    @Override
    public String getPerms() {
        return "Ares_BackPack.LumberJack";
    }

    @Override
    public void perform(Player player, String[] args) {
        Inventory customInventory = Bukkit.createInventory(player, 18, ChatColor.RED + player.getName() + "'s LumberJack Inventory");
        ItemStack Bottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
        ItemStack SilkAxe = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemStack FortuneAxe = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemStack Shears = new ItemStack(Material.SHEARS, 1);
        /*=======================================================================================*/
        ItemMeta ShearsMeta = Shears.getItemMeta();
        ItemMeta SilkMeta = SilkAxe.getItemMeta();
        ItemMeta FortuneMeta = FortuneAxe.getItemMeta();
        assert ShearsMeta != null;
        assert SilkMeta != null;
        assert FortuneMeta != null;
        /*=======================================================================================*/
        ShearsMeta.setDisplayName(ChatColor.RED + "LumberJack's Shears");
        SilkMeta.setDisplayName(ChatColor.RED + "LumberJack's Silk Axe");
        FortuneMeta.setDisplayName(ChatColor.RED + "LumberJack's Fortune Axe");
        /*=======================================================================================*/
        AddEnchantsToMeta.addUnbreaking(ShearsMeta, 50, true);
        ShearsMeta.addEnchant(Enchantment.MENDING, 1, false);
        /*=======================================================================================*/
        AddEnchantsToMeta.addUnbreaking(SilkMeta, 5 ,true);
        AddEnchantsToMeta.addUnbreaking(FortuneMeta, 5 ,true);
        AddEnchantsToMeta.addToolsEnchants(SilkMeta, 5, true, "Silk", 0);
        AddEnchantsToMeta.addToolsEnchants(FortuneMeta, 5, true, "fortune", 5);
        SilkMeta.addEnchant(Enchantment.MENDING,1 ,false);
        FortuneMeta.addEnchant(Enchantment.MENDING,1 ,false);
        /*=======================================================================================*/
        Shears.setItemMeta(ShearsMeta);
        SilkAxe.setItemMeta(SilkMeta);
        FortuneAxe.setItemMeta(FortuneMeta);
        /*=======================================================================================*/
        ItemStack[] items = new ItemStack[]{Shears, FortuneAxe, SilkAxe, Bottles};
        if(!hashMap.containsKey(player.getUniqueId().toString())) {
            customInventory.setContents(items);
            hashMap.put(player.getUniqueId().toString(), items);
        }else{
            customInventory.setContents(hashMap.get(player.getUniqueId().toString()));
        }
        player.openInventory(customInventory);
    }
}
