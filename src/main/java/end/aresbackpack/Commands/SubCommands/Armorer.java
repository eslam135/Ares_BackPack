package end.aresbackpack.Commands.SubCommands;

import end.aresbackpack.Commands.SubCMDS;
import end.aresbackpack.CustomClasses.AddEnchantsToMeta;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.HashMap;

public class Armorer extends SubCMDS  {
    public static HashMap<String, ItemStack[]> hashMap = new HashMap<>();
    @Override
    public String getName() {
        return "Armorer";
    }

    @Override
    public String getDescription() {
        return "A BackPack Made For Those Scared Of Death";
    }

    @Override
    public String getSyntax() {
        return "/BackPack Armorer";
    }

    @Override
    public String getPerms() {
        return "Ares_BackPack.Armorer";
    }

    @Override
    public void perform(Player player, String[] args) {
        Inventory customInventory = Bukkit.createInventory(player, 18, ChatColor.WHITE+player.getName()+"'s Armorer Inventory");
        ItemStack ChestPlate = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        ItemStack Leggings = new ItemStack(Material.LEATHER_LEGGINGS,1);
        ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS,1);
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemStack Bottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
        /*=======================================================================================*/
        LeatherArmorMeta ChestPlateMeta=(LeatherArmorMeta) ChestPlate.getItemMeta();
        LeatherArmorMeta LeggingsMeta = (LeatherArmorMeta)Leggings.getItemMeta();
        LeatherArmorMeta HelmetMeta = (LeatherArmorMeta) Helmet.getItemMeta();
        LeatherArmorMeta BootsMeta = (LeatherArmorMeta) Boots.getItemMeta();
        /*=======================================================================================*/
        assert HelmetMeta != null;
        assert LeggingsMeta != null;
        assert ChestPlateMeta != null;
        assert BootsMeta != null;
        /*=======================================================================================*/
        ChestPlateMeta.setDisplayName(ChatColor.WHITE+"Armored ChestPlate");
        LeggingsMeta.setDisplayName(ChatColor.WHITE+"Armored Leggings");
        HelmetMeta.setDisplayName(ChatColor.WHITE+"Armored Helmet");
        BootsMeta.setDisplayName(ChatColor.WHITE+"Armored Boots");
        /*=======================================================================================*/
        ChestPlate.setItemMeta(ChestPlateMeta);
        Leggings.setItemMeta(LeggingsMeta);
        Helmet.setItemMeta(HelmetMeta);
        Boots.setItemMeta(BootsMeta);
        /*=======================================================================================*/
        ItemStack[] items = new ItemStack[]{ChestPlate, Leggings, Helmet,Boots, Bottles};
        for(ItemStack itemStack: items) {
            if(!(itemStack.getType() == Material.EXPERIENCE_BOTTLE)) {
                LeatherArmorMeta meta = (LeatherArmorMeta) itemStack.getItemMeta();
                assert meta != null;
                AddEnchantsToMeta.addUnbreaking(meta, 10, true);
                meta.addEnchant(Enchantment.MENDING, 1, false);
                meta.setColor(Color.WHITE);
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 15, true);
                meta.addEnchant(Enchantment.PROTECTION_FIRE, 15, true);
                itemStack.setItemMeta(meta);
            }
        }
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
