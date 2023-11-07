package end.aresbackpack.Commands;

import end.aresbackpack.AresBackPack;
import end.aresbackpack.Commands.SubCommands.*;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.Plugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BackPack implements TabExecutor {

    Plugin plugin = AresBackPack.getPlugin(AresBackPack.class);
    private ArrayList<SubCMDS> subCMDS = new ArrayList<>();
    public BackPack(){
        subCMDS.add(new VIP());
        subCMDS.add(new Default());
        subCMDS.add(new Miner());
        subCMDS.add(new LumberJack());
        subCMDS.add(new Wizard());
        subCMDS.add(new Scavenger());
        subCMDS.add(new Fighter());
        subCMDS.add(new Armorer());
        subCMDS.add(new Farmer());
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            boolean found = false;
            if(args.length >0){
                for (int i = 0; i < getSubCMDS().size(); i++) {
                    if(args[0].equalsIgnoreCase(getSubCMDS().get(i).getName())){
                        found = true;
                        if(player.hasPermission(getSubCMDS().get(i).getPerms())){
                            getSubCMDS().get(i).perform(player,args);
                        }else{
                            player.sendMessage(ChatColor.RED+plugin.getConfig().getString("Messages.NotRole"));
                        }
                    }
                    if(i == getSubCMDS().size()-1 && !found){
                        player.sendMessage(ChatColor.RED+ plugin.getConfig().getString("Messages.WrongCMD"));
                    }
                }
            }else{
                player.sendMessage(ChatColor.GOLD+"===========================================");
                for (int i = 0; i < getSubCMDS().size(); i++) {
                    player.sendMessage(ChatColor.GOLD+getSubCMDS().get(i).getSyntax()+ChatColor.DARK_PURPLE+
                            " Description: "+ChatColor.GOLD+ getSubCMDS().get(i).getDescription());
                }
                player.sendMessage(ChatColor.GOLD+"===========================================");
            }

        }else{
            sender.sendMessage(ChatColor.RED + "You need to be online to use this command");
        }
        return true;
    }

    public ArrayList<SubCMDS> getSubCMDS() {
        return subCMDS;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if(args.length == 1){
            for(SubCMDS s: getSubCMDS()){
                list.add(s.getName());
            }
            return list;
        }
        return null;
    }
}
