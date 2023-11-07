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

public class Default extends SubCMDS {
    public static HashMap<String, ItemStack[]> hashMap = new HashMap<>();
    @Override
    public String getName() {
        return "Default";
    }

    @Override
    public String getDescription() {
        return "A Normal BackPack For No-Special-Role Players";
    }

    @Override
    public String getSyntax() {
        return "/BackPack default";
    }

    @Override
    public String getPerms() {
        return "Ares_BackPack.default";
    }

    @Override
    public void perform(Player player, String[] args)  {
        Inventory customInventory = Bukkit.createInventory(player, 9, ChatColor.GREEN+player.getName()+" Default Inventory");
        ItemStack ChestPlate = new ItemStack(Material.IRON_CHESTPLATE,1);
        ItemStack Leggings = new ItemStack(Material.IRON_LEGGINGS,1);
        ItemStack Boots = new ItemStack(Material.IRON_BOOTS,1);
        ItemStack Helmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemStack Sword = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack PickAxe = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemStack Bow = new ItemStack(Material.BOW,1);
        ItemStack Arrows = new ItemStack(Material.ARROW, 64);
        /*=======================================================================================*/
        ItemMeta ChestPlateMeta= ChestPlate.getItemMeta();
        ItemMeta LeggingsMeta = Leggings.getItemMeta();
        ItemMeta HelmetMeta = Helmet.getItemMeta();
        ItemMeta BootsMeta = Boots.getItemMeta();
        ItemMeta SwordMeta = Sword.getItemMeta();
        ItemMeta PickAxeMeta = PickAxe.getItemMeta();
        ItemMeta BowMeta = Bow.getItemMeta();
        /*=======================================================================================*/
        assert HelmetMeta != null;
        assert LeggingsMeta != null;
        assert ChestPlateMeta != null;
        assert BootsMeta != null;
        assert SwordMeta != null;
        assert PickAxeMeta != null;
        assert BowMeta != null;
        /*=======================================================================================*/
        ChestPlateMeta.setDisplayName(ChatColor.AQUA+"ChestPlate");
        LeggingsMeta.setDisplayName(ChatColor.AQUA+"Leggings");
        HelmetMeta.setDisplayName(ChatColor.AQUA+"Helmet");
        BootsMeta.setDisplayName(ChatColor.AQUA+"Boots");
        SwordMeta.setDisplayName(ChatColor.AQUA+"Sword");
        PickAxeMeta.setDisplayName(ChatColor.AQUA+"PickAxe");
        BowMeta.setDisplayName(ChatColor.AQUA+"Bow");
        /*=======================================================================================*/
        ChestPlateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
        ChestPlate.setItemMeta(ChestPlateMeta);
        /*=======================================================================================*/
        LeggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
        Leggings.setItemMeta(LeggingsMeta);
        /*=======================================================================================*/
        HelmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
        Helmet.setItemMeta(HelmetMeta);
        /*=======================================================================================*/
        BootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
        Boots.setItemMeta(BootsMeta);
        /*=======================================================================================*/
        AddEnchantsToMeta.addSwordEnchants(SwordMeta, 2, false);
        Sword.setItemMeta(SwordMeta);
        /*=======================================================================================*/
        AddEnchantsToMeta.addToolsEnchants(PickAxeMeta, 2, false, "fortune", 2);
        PickAxe.setItemMeta(PickAxeMeta);
        /*=======================================================================================*/
        AddEnchantsToMeta.addBowEnchants(BowMeta, 2, false);
        Bow.setItemMeta(BowMeta);
        /*=======================================================================================*/

        ItemStack[] items = new ItemStack[]{ChestPlate, Leggings, Helmet,Boots,Sword,PickAxe,Bow,Arrows};
        for(ItemStack itemStack: items) {
            if ((itemStack.getType() != Material.ARROW)) {
                ItemMeta meta = itemStack.getItemMeta();
                assert meta != null;
                AddEnchantsToMeta.addUnbreaking(meta, 2, false);
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
