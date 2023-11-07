package end.aresbackpack.Commands;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class SubCMDS {
    public static HashMap<String, ItemStack[]> hashMap = new HashMap<>();

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();


    public abstract String getPerms();


    public abstract void perform(Player player, String[] args);
}
