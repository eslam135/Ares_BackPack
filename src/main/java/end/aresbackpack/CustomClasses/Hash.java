package end.aresbackpack.CustomClasses;

import end.aresbackpack.Commands.SubCommands.VIP;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Hash {
    public static void saveHash(String path, HashMap<String, ItemStack[]> hashMap, Plugin plugin){
        for(Map.Entry<String, ItemStack[]> entry : hashMap.entrySet()){
            plugin.getConfig().set(path+"."+entry.getKey(),entry.getValue());
        }
        plugin.saveConfig();
    }
    public static void restoreHash(String path, HashMap<String, ItemStack[]> hashMap, Plugin plugin){
        plugin.getConfig().getConfigurationSection(path).getKeys(false).forEach(key -> {
            @SuppressWarnings("unchecked")
            ItemStack[] content = ((List<ItemStack>) Objects.requireNonNull(plugin.getConfig().get(path+"." + key))).toArray(new ItemStack[0]);
            hashMap.put(key, content);
        });
    }
}
