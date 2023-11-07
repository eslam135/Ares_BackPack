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

public class Fighter extends SubCMDS {
    public static HashMap<String, ItemStack[]> hashMap = new HashMap<>();
    @Override
    public String getName() {
        return "Fighter";
    }

    @Override
    public String getDescription() {
        return "A BackPack For All The PvP PLayers On the Server";
    }

    @Override
    public String getSyntax() {
        return "/BackPack Fighter";
    }

    @Override
    public String getPerms() {
        return "Ares_BackPack.Fighter";
    }

    @Override
    public void perform(Player player, String[] args) {
        Inventory customInventory = Bukkit.createInventory(player, 18, ChatColor.DARK_RED+player.getName()+"'s Fighter Inventory");
        ItemStack Sword = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemStack Bow = new ItemStack(Material.BOW,1);
        ItemStack Arrows = new ItemStack(Material.ARROW, 64);
        ItemStack Axe = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemStack Bottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
        /*=======================================================================================*/
        ItemMeta SwordMeta = Sword.getItemMeta();
        ItemMeta BowMeta = Bow.getItemMeta();
        ItemMeta AxeMeta = Axe.getItemMeta();
        /*=======================================================================================*/
        assert SwordMeta != null;
        assert BowMeta != null;
        assert AxeMeta != null;
        /*=======================================================================================*/
        SwordMeta.setDisplayName(ChatColor.DARK_RED+"Fighter Dagger");
        BowMeta.setDisplayName(ChatColor.DARK_RED+"Fighter Sniper");
        AxeMeta.setDisplayName(ChatColor.DARK_RED+"Fighter Hatchet");
        /*=======================================================================================*/
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
        SwordMeta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
        AddEnchantsToMeta.addLooting(SwordMeta, 3, false);
        AddEnchantsToMeta.addKnockback(SwordMeta, 2, false);
        SwordMeta.addEnchant(Enchantment.SWEEPING_EDGE, 4, true);
        Sword.setItemMeta(SwordMeta);
        /*=======================================================================================*/
        AxeMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, false);
        AxeMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
        AddEnchantsToMeta.addLooting(AxeMeta, 1, false);
        AddEnchantsToMeta.addKnockback(AxeMeta, 1, false);
        AxeMeta.addEnchant(Enchantment.SWEEPING_EDGE, 1, false);
        Axe.setItemMeta(AxeMeta);
        /*=======================================================================================*/
        AddEnchantsToMeta.addBowEnchants(BowMeta, 6, false);
        AddEnchantsToMeta.addPunch(BowMeta, 3, false);
        BowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1 , false);
        Bow.setItemMeta(BowMeta);
        /*=======================================================================================*/
        ItemStack[] items = new ItemStack[]{Sword,Axe,Bow,Arrows,Bottles};
        for(ItemStack itemStack: items) {
            if ((itemStack.getType() != Material.ARROW)) {
                ItemMeta meta = itemStack.getItemMeta();
                assert meta != null;
                AddEnchantsToMeta.addUnbreaking(meta, 5, true);
                meta.addEnchant(Enchantment.MENDING,1, false);
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
