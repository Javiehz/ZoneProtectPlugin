package ZoneProtect;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

    public void onBlockBuild(BlockPlaceEvent event){
        Player player = event.getPlayer();
        player.sendMessage("INFO :: HAS CONSTRUIDO UN BLOQUE.");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        player.sendMessage("(INFO) :: HAS ROTO UN BLOQUE.");
    }
}
