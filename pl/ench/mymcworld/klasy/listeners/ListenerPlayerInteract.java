package pl.ench.mymcworld.klasy.listeners;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import pl.ench.mymcworld.klasy.CmdklasyExecuteAdd;
import pl.ench.mymcworld.klasy.CmdklasyExecuteHelp;
import pl.ench.mymcworld.klasy.CmdklasyExecuteShow;
import pl.ench.mymcworld.klasy.ConfigManager;
import pl.ench.mymcworld.klasy.Utils;

public class ListenerPlayerInteract implements Listener {
	
	@EventHandler
	public static void onPlayerInteract(PlayerInteractEvent e){
		if(ConfigManager.debugMode) Utils.sendInfo("Zg�oszono event");
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().getType().equals(Material.WALL_SIGN)){
			Sign s = (Sign) e.getClickedBlock().getState();
			if(s.getLine(0).equalsIgnoreCase("�1[klasy/drop]")){
				if(s.getLine(1).equalsIgnoreCase("list")){
					CmdklasyExecuteHelp.klasyListExecute(e.getPlayer());
				} else if(s.getLine(1).equalsIgnoreCase("show")){
					CmdklasyExecuteShow.klasyShowExecute(e.getPlayer(), e.getPlayer().getName());
				} else if(s.getLine(1).equalsIgnoreCase("add")){
					CmdklasyExecuteAdd.klasyAddExecute(e.getPlayer(), Integer.parseInt(s.getLine(2)));
				}
			}
		}
		return;
	}
}
