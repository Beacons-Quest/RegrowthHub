package org.lushplugins.regrowthhub.hook.listener;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.lushplugins.lushlib.listener.EventListener;

import java.util.Collection;
import java.util.List;

public class PlayerListener implements EventListener {
    private static final Collection<Material> HORSE_ARMOR = List.of(
        Material.LEATHER_HORSE_ARMOR,
        Material.IRON_HORSE_ARMOR,
        Material.GOLDEN_HORSE_ARMOR,
        Material.DIAMOND_HORSE_ARMOR
    );

    @EventHandler
    public void onPlayerSwapHandItems(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.OFF_HAND) {
            return;
        }

        ItemStack item = event.getItem();
        if (item != null && HORSE_ARMOR.contains(item.getType())) {
            event.setUseItemInHand(Event.Result.DENY);
        }
    }
}
