package end.aresbackpack;

import end.aresbackpack.Commands.BackPack;
import end.aresbackpack.Commands.SubCommands.*;
import end.aresbackpack.CustomClasses.Hash;
import end.aresbackpack.Events.InventoryOff;
import org.bukkit.plugin.java.JavaPlugin;

public final class AresBackPack extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("BackPack is on!");
        getCommand("BackPack").setExecutor(new BackPack());
        this.getServer().getPluginManager().registerEvents(new InventoryOff(), this);
        saveDefaultConfig();
        if(this.getConfig().contains("VIPdata")){
            Hash.restoreHash("VIPdata", VIP.hashMap, this);
        }
        if(this.getConfig().contains("Defaultdata")){
            Hash.restoreHash("Defaultdata", Default.hashMap, this);
        }
        if(this.getConfig().contains("Minerdata")){
            Hash.restoreHash("Minerdata", Miner.hashMap, this);
        }
        if(this.getConfig().contains("LumberJackdata")){
            Hash.restoreHash("LumberJackdata", LumberJack.hashMap, this);
        }
        if(this.getConfig().contains("Wizarddata")){
            Hash.restoreHash("Wizarddata", Wizard.hashMap, this);
        }
        if(this.getConfig().contains("Scavengerdata")){
            Hash.restoreHash("Scavengerdata", Scavenger.hashMap, this);
        }
        if(this.getConfig().contains("Fighterdata")){
            Hash.restoreHash("Fighterdata", Fighter.hashMap, this);
        }
        if(this.getConfig().contains("Armorerdata")){
            Hash.restoreHash("Armorerdata", Armorer.hashMap, this);
        }
        if(this.getConfig().contains("Farmerdata")){
            Hash.restoreHash("Farmerdata", Farmer.hashMap, this);
        }
    }

    @Override
    public void onDisable() {
        System.out.println("BackPack is off!");
        if(!VIP.hashMap.isEmpty()){
            Hash.saveHash("VIPdata", VIP.hashMap, this);
        }
        if(!Default.hashMap.isEmpty()){
            Hash.saveHash("Defaultdata", Default.hashMap, this);
        }
        if(!Miner.hashMap.isEmpty()){
            Hash.saveHash("Minerdata", Miner.hashMap, this);
        }
        if(!LumberJack.hashMap.isEmpty()){
            Hash.saveHash("LumberJackdata", Wizard.hashMap, this);
        }
        if(!Wizard.hashMap.isEmpty()){
            Hash.saveHash("Wizarddata", Wizard.hashMap, this);
        }
        if(!Scavenger.hashMap.isEmpty()){
            Hash.saveHash("Scavengerdata", Scavenger.hashMap, this);
        }
        if(!Fighter.hashMap.isEmpty()){
            Hash.saveHash("Fighterdata", Fighter.hashMap, this);
        }
        if(!Armorer.hashMap.isEmpty()){
            Hash.saveHash("Armorerdata", Fighter.hashMap, this);
        }
        if(!Farmer.hashMap.isEmpty()){
            Hash.saveHash("Farmerdata", Farmer.hashMap, this);
        }
    }

}
