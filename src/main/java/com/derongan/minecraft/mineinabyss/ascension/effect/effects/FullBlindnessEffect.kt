package com.derongan.minecraft.mineinabyss.ascension.effect.effects

import com.derongan.minecraft.mineinabyss.ascension.effect.AbstractAscensionEffect
import com.mineinabyss.idofront.destructure.component1
import com.mineinabyss.idofront.destructure.component2
import com.mineinabyss.idofront.destructure.component3
import com.mineinabyss.idofront.time.TimeSpan
import com.mineinabyss.idofront.time.ticks
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.bukkit.Color
import org.bukkit.Particle
import org.bukkit.entity.FallingBlock
import org.bukkit.entity.Player
//import com.comphenix.protocol
import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.ProtocolManager
import com.comphenix.protocol.PacketStream
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.events.PacketEvent
import com.comphenix.protocol.wrappers.WrappedDataWatcher
import com.derongan.minecraft.mineinabyss.MineInAbyss
import org.bukkit.Bukkit.createBlockData
import org.bukkit.Bukkit.getEntity
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.block.data.BlockData
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.jetbrains.exposed.sql.castTo
import org.jetbrains.exposed.sql.floatLiteral

@Serializable
@SerialName("fullBlind")
data class FullBlindnessEffect constructor(
        //val addMaxHealth: Double,
        override val offset: TimeSpan = 0.ticks,
        override val duration: TimeSpan,
        override val iterations: Int = 1,
        /*val blinders: List<Material>*/
        //val mazeBlocks: List<Block>
) : AbstractAscensionEffect() {
    //private val protocolManager: ProtocolManager = ProtocolLibrary.getProtocolManager()
/*    var blocks: List<FallingBlock> = emptyList() //stores real Falling Blocks
    var spoofs: Array<Int> = emptyArray() //stores entity IDs of spoofed Falling Blocks*/
    override fun cleanUp(player: Player) {
        MineInAbyss.instance?.protocolManager?.removePacketListeners(MineInAbyss.instance)
/*        for(block in blocks) {
            block.remove()
        }
        destroy(player,spoofs) //remove spoofed Falling Blocks*/
    }
    /*private fun destroy(player: Player, spoofIDs: Array<Int>){
        val destroyer: PacketContainer = PacketContainer(PacketType.Play.Server.ENTITY_DESTROY)
        destroyer.integers
                .write(0,spoofs.size)
        destroyer.integerArrays
                .write(0,spoofIDs.toIntArray())
        MineInAbyss.instance?.protocolManager?.sendServerPacket(player, destroyer)
    }*/

    override fun applyEffect(player: Player) {
        MineInAbyss.instance?.protocolManager?.addPacketListener( //gives an error java.lang.IllegalArgumentException: No suitable constructor could be found. at com.comphenix.protocol.injector.PacketConstructor.withPacket(PacketConstructor.java:163) ... Caused by: java.lang.NullPointerException at com.comphenix.protocol.wrappers.BukkitConverters.lambda$asUnwrapper$0(BukkitConverters.java:1058) at com.comphenix.protocol.injector.PacketConstructor.withPacket(PacketConstructor.java:127)
                object : PacketAdapter(MineInAbyss.instance, ListenerPriority.NORMAL, //Not sure why the error occurs - see the logs for full stack trace
                        PacketType.Play.Server.LIGHT_UPDATE) {
                    override fun onPacketSending(event: PacketEvent) {
                        // Update Light packets (id: 0x23)
                        if (event.packetType ===
                                PacketType.Play.Server.LIGHT_UPDATE) {
                            //event.isCancelled = true
                            val container1: PacketContainer = PacketContainer(PacketType.Play.Server.LIGHT_UPDATE)
                            container1.integers
                                    .write(0,event.packet.integers.read(0))
                                    .write(1,event.packet.integers.read(1))
                                    .write(2,0) //Probably type Long in 1.16.4
                                    .write(3,0) //Probably type Long in 1.16.4
                                    .write(4,0) //Probably type Long in 1.16.4
                                    .write(5,0) //Probably type Long in 1.16.4
                            container1.booleans.write(0,event.packet.booleans.read(0))
                            event.packet = container1
                        }
                    }
                })
        /*//while(!this.isDone) {
            val positions: Array<IntArray> = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 1, -1), intArrayOf(1, 0, 1), intArrayOf(1, 0, 0), intArrayOf(1, 0, -1), intArrayOf(0, 1, 1), intArrayOf(0, 1, 0), intArrayOf(0, 1, -1), intArrayOf(0, 0, 1), intArrayOf(0, 0, 0), intArrayOf(0, 0, -1), intArrayOf(-1, 1, 1), intArrayOf(-1, 1, 0), intArrayOf(-1, 1, -1), intArrayOf(-1, 0, 1), intArrayOf(-1, 0, 0), intArrayOf(-1, 0, -1))
            for (position: IntArray in positions) {
                blinders.forEach { addObstructionsToView(player, position, it) }
            }
        //}*/
    }

    /*private fun addObstructionsToView(player: Player, position:IntArray, blinder: Material) {
        //This currently requires CraftBukkit for the CraftPlayer, PlayerConnection and PacketPlayOutEntity classes
        //val conn: PlayerConnection = ((CraftPlayer) player).getHandle().playerConnection
        val loc = player.eyeLocation
        val below: Location = player.location.block.getRelative(BlockFace.DOWN).location
        val container1: PacketContainer = PacketContainer(PacketType.Play.Server.SPAWN_ENTITY)
        //val container2: PacketContainer = PacketContainer(PacketType.Play.Server.ENTITY_METADATA)
        //val watcher: WrappedDataWatcher = WrappedDataWatcher(container2.getMetadata())
        //EntityItem blinder = new EntityItem(((CraftWorld)player.getWorld()).getHandle(), loc.x, loc.y, loc.z, CraftItemStack.asNMSCopy(item))
        //blinder.teleport(player.eyeLocation)
        val data: BlockData = createBlockData(blinder)
        //below.world?.spawnFallingBlock(below, data)
        val falling: FallingBlock? = below.world?.spawnFallingBlock(below, data)
        blocks = blocks + falling!!
        if (falling != null) {
            falling.dropItem = false
            falling.setGravity(false)
        }
        //blinder.teleport(player.eyeLocation.clone().add(1, 0, 1))
        //((CraftPlayer) player).getHandle().playerConnection.sendPacket(spawnPacket)
        //conn.sendPacket(PacketPlayOutEntity(blinder.getId(), blinder.getUniqueID(), loc.x, loc.y, loc.z, 0f, 0f, blinder.getEntityType(), 0, blinder.getPositionVector()))
        //val packet: PacketType = PacketType.Play.Server.SPAWN_ENTITY //conn.sendPacket(PacketPlayOutSpawnEntity(blinder.entityId, blinder.uniqueId, loc.x, loc.y, loc.z, 0f, 0f, blinder.type, 0, blinder.velocity))

        //Entity Spawn Packet
        if (falling != null) {
            container1.integers
                    .write(0, falling.entityId)
                    .write(1, falling.velocity.component1().toInt())
                    .write(2, falling.velocity.component2().toInt())
                    .write(3, falling.velocity.component3().toInt())
                    .write(4, 0)
                    .write(5, 0)
            container1.uuiDs
                    .write(0, falling.uniqueId)
            container1.entityTypeModifier
                    .write(0, falling.type)
        }
        container1.doubles
                .write(0, loc.x + position[0])
                .write(1, loc.y + position[1])
                .write(2, loc.z + position[2])

        spoofs += container1.integers.read(0) //could just use falling.entityId
        try {
            MineInAbyss.instance?.protocolManager?.sendServerPacket(player, container1)
        }catch(e: Exception){
            System.err.println("Error: could not send packet")
        }
        //}else{
            //System.err.println("Error: no protocol manager. unsent packet = $container1")
        //}
        //Entity Metadata Packet
        //container2.integers
                //.write(0, falling.entityId)
    }*/
    override fun clone() = copy()
}
