package com.derongan.minecraft.mineinabyss.mapping

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.MapInitializeEvent
import org.bukkit.map.MapView

object MapListener : Listener {
    @EventHandler
    fun onMapInitialize (mapInitializeEvent: MapInitializeEvent) {
        val mapView: MapView = mapInitializeEvent.map
        mapView.scale = MapView.Scale.NORMAL
        mapView.isUnlimitedTracking = true
        if(true){ //TODO add condition using map meta that map must be custom item e.g. CaveMap
            mapView.renderers.clear()
            mapView.addRenderer(CaveMapRenderer(true))
        }
    }
}
