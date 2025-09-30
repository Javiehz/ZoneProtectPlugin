package ZoneProtect;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

    private final String WORLD = "world";
    private final double X1 = -528, Y1 = 0, Z1 = -533;
    private final double X2 = -411, Y2 = 120, Z2 = -437;

    public boolean insideProtectedZone(Location loc){
        if (loc == null || loc.getWorld() == null) return false;
        if (!loc.getWorld().getName().equals(WORLD)) return false;
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        double minX = Math.min(X1, X2);
        double maxX = Math.max(X1, X2);
        double minZ = Math.min(Z1, Z2);
        double maxZ = Math.max(Z1, Z2);
        double minY = Math.min(Y1, Y2);
        double maxY = Math.max(Y1, Y2);
        if(x>= minX && x<=maxX
        && y>= minY && y<=maxY
        && z>= minZ && z<=maxZ){
            return true;
        } else {
            return false;
        }
    }

    @EventHandler
    public void onBlockBuild(BlockPlaceEvent event){
        if(insideProtectedZone(event.getBlock().getLocation())){
            Player player = event.getPlayer();
            event.setCancelled(true);
            player.sendMessage("§cZona protegida: no puedes destruir bloques aquí.");
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(insideProtectedZone(event.getPlayer().getLocation())){
            Player player = event.getPlayer();
            event.setCancelled(true);
            player.sendMessage("§cZona protegida: no puedes construir bloques aquí.");
        }

    }
}















