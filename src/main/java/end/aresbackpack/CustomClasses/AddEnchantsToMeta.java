package end.aresbackpack.CustomClasses;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

public class AddEnchantsToMeta {
    public static void addProt(ItemMeta meta, int lvl, boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,lvl,ignoreLevelRestriction);
        meta.addEnchant(Enchantment.PROTECTION_FIRE,lvl,ignoreLevelRestriction);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE,lvl,ignoreLevelRestriction);
        meta.addEnchant(Enchantment.THORNS, lvl, ignoreLevelRestriction);

    }
    public static void addUnbreaking(ItemMeta meta, int lvl, boolean ignoreLevelRestriction ){
        meta.addEnchant(Enchantment.DURABILITY, lvl, ignoreLevelRestriction);
    }
    public static void addSwordEnchants(ItemMeta meta, int lvl,  boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.DAMAGE_ALL, lvl, ignoreLevelRestriction);
        meta.addEnchant(Enchantment.FIRE_ASPECT, lvl, ignoreLevelRestriction);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, lvl, ignoreLevelRestriction);

    }
    public static void addLooting(ItemMeta meta, int lvl, boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, lvl , ignoreLevelRestriction);

    }
    public static void addHelmetEnchatns(ItemMeta meta, int lvl, boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.WATER_WORKER, lvl, ignoreLevelRestriction);
        meta.addEnchant(Enchantment.OXYGEN, lvl , ignoreLevelRestriction);

    }
    public static void addBootsEnchants(ItemMeta meta, int lvl, boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.DEPTH_STRIDER, lvl, ignoreLevelRestriction);
        meta.addEnchant(Enchantment.SOUL_SPEED, lvl , ignoreLevelRestriction);

    }
    public static void addVanishing(ItemMeta meta, boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, ignoreLevelRestriction);

    }
    public static void addSwiftSneak(ItemMeta meta, int lvl, boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.SWIFT_SNEAK, lvl, ignoreLevelRestriction);

    }
    public static void addFrostWalker(ItemMeta meta, int lvl, boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.FROST_WALKER, lvl, ignoreLevelRestriction);

    }
    public static void addKnockback(ItemMeta meta, int lvl, boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.KNOCKBACK, lvl, ignoreLevelRestriction);
    }
    public static void addBowEnchants(ItemMeta meta, int lvl, boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.ARROW_FIRE,1,ignoreLevelRestriction);
        meta.addEnchant(Enchantment.ARROW_DAMAGE,lvl,ignoreLevelRestriction);
    }
    public static void addPunch(ItemMeta meta, int lvl, boolean ignoreLevelRestriction){
        meta.addEnchant(Enchantment.ARROW_KNOCKBACK,lvl,ignoreLevelRestriction);
    }
    public static void addToolsEnchants(ItemMeta meta, int lvl,boolean ignoreLevelRestriction, String s, int fortuneLVL ){
        meta.addEnchant(Enchantment.DIG_SPEED, lvl, ignoreLevelRestriction);
        if(s.equalsIgnoreCase("Silk")){
            meta.addEnchant(Enchantment.SILK_TOUCH, 1, ignoreLevelRestriction);
        }else if(s.equalsIgnoreCase("Fortune")){
            meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, fortuneLVL, ignoreLevelRestriction);
        }
    }
}
