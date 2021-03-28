package com.derongan.minecraft.mineinabyss.mapping

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.map.MapCanvas
import org.bukkit.map.MapPalette
import org.bukkit.map.MapRenderer
import org.bukkit.map.MapView
import java.awt.Color
import java.util.*


class CaveMapRenderer(contextual: Boolean) : MapRenderer() {
    override fun render(map: MapView, canvas: MapCanvas, player: Player) {
        var block = false
        val y = player.eyeLocation.blockY
        val x = player.eyeLocation.blockX
        val z = player.eyeLocation.blockZ
        val blocksMap: MutableMap<Material, Color> = HashMap<Material, Color>()
        blocksMap[Material.GRASS] = Color(49, 101, 25)
        blocksMap[Material.TALL_GRASS] = Color(49, 101, 25)
        blocksMap[Material.COBBLESTONE] = Color(130, 130, 130)
        blocksMap[Material.COBBLESTONE_SLAB] = Color(130, 130, 130)
        blocksMap[Material.FURNACE] = Color(130, 130, 130)
        blocksMap[Material.STONE] = Color(117, 117, 117)
        blocksMap[Material.STONE_SLAB] = Color(117, 117, 117)
        blocksMap[Material.IRON_ORE] = Color(117, 117, 117)
        blocksMap[Material.GOLD_ORE] = Color(117, 117, 117)
        blocksMap[Material.REDSTONE_ORE] = Color(117, 117, 117)
        blocksMap[Material.DIAMOND_ORE] = Color(117, 117, 117)
        blocksMap[Material.COAL_ORE] = Color(117, 117, 117)
        blocksMap[Material.EMERALD_ORE] = Color(117, 117, 117)
        blocksMap[Material.LAPIS_ORE] = Color(117, 117, 117)
        blocksMap[Material.IRON_BLOCK] = Color(236, 236, 236)
        blocksMap[Material.GOLD_BLOCK] = Color(243, 223, 75)
        blocksMap[Material.REDSTONE_BLOCK] = Color(196, 25, 16)
        blocksMap[Material.DIAMOND_BLOCK] = Color(95, 233, 217)
        blocksMap[Material.COAL_BLOCK] = Color(19, 19, 19)
        blocksMap[Material.EMERALD_BLOCK] = Color(71, 213, 105)
        blocksMap[Material.LAPIS_BLOCK] = Color(42, 80, 139)
        blocksMap[Material.WATER] = Color(67, 101, 165)
        blocksMap[Material.SEAGRASS] = Color(67, 101, 165)
        blocksMap[Material.BUBBLE_COLUMN] = Color(67, 101, 165)
        blocksMap[Material.TALL_SEAGRASS] = Color(67, 101, 165)
        blocksMap[Material.KELP] = Color(67, 101, 165)
        blocksMap[Material.GRASS_BLOCK] = Color(82, 129, 69)
        blocksMap[Material.DIRT] = Color(168, 120, 83)
        blocksMap[Material.SAND] = Color(222, 215, 172)
        blocksMap[Material.SANDSTONE] = Color(213, 207, 162)
        blocksMap[Material.ACACIA_LEAVES] = Color(73, 181, 24)
        blocksMap[Material.BIRCH_LEAVES] = Color(114, 149, 76)
        blocksMap[Material.DARK_OAK_LEAVES] = Color(72, 186, 18)
        blocksMap[Material.JUNGLE_LEAVES] = Color(74, 185, 25)
        blocksMap[Material.OAK_LEAVES] = Color(73, 183, 24)
        blocksMap[Material.SPRUCE_LEAVES] = Color(55, 91, 56)
        blocksMap[Material.GRASS_PATH] = Color(170, 148, 89)
        blocksMap[Material.COARSE_DIRT] = Color(104, 75, 51)
        blocksMap[Material.ANDESITE] = Color(136, 136, 138)
        blocksMap[Material.DIORITE] = Color(181, 181, 181)
        blocksMap[Material.DEAD_BUSH] = Color(144, 97, 39)
        blocksMap[Material.CACTUS] = Color(76, 107, 35)
        blocksMap[Material.DANDELION] = Color(247, 229, 77)
        blocksMap[Material.POPPY] = Color(230, 47, 43)
        blocksMap[Material.CORNFLOWER] = Color(70, 106, 235)
        blocksMap[Material.AZURE_BLUET] = Color(210, 215, 223)
        blocksMap[Material.OXEYE_DAISY] = Color(187, 188, 189)
        blocksMap[Material.LAVA] = Color(211, 124, 40)
        blocksMap[Material.GRANITE] = Color(156, 111, 91)
        blocksMap[Material.REDSTONE_LAMP] = Color(123, 73, 33)
        blocksMap[Material.GRAVEL] = Color(139, 135, 134)
        blocksMap[Material.SPRUCE_LOG] = Color(48, 34, 25)
        blocksMap[Material.OAK_LOG] = Color(58, 35, 9)
        blocksMap[Material.BIRCH_LOG] = Color(196, 195, 193)
        blocksMap[Material.JUNGLE_LOG] = Color(89, 76, 37)
        blocksMap[Material.ACACIA_LOG] = Color(95, 95, 85)
        blocksMap[Material.DARK_OAK_LOG] = Color(35, 27, 16)
        blocksMap[Material.SPRUCE_PLANKS] = Color(100, 78, 47)
        blocksMap[Material.OAK_PLANKS] = Color(172, 140, 88)
        blocksMap[Material.BIRCH_PLANKS] = Color(202, 185, 131)
        blocksMap[Material.JUNGLE_PLANKS] = Color(172, 124, 89)
        blocksMap[Material.ACACIA_PLANKS] = Color(178, 102, 60)
        blocksMap[Material.DARK_OAK_PLANKS] = Color(62, 41, 18)
        blocksMap[Material.SPRUCE_FENCE] = Color(100, 78, 47)
        blocksMap[Material.OAK_FENCE] = Color(172, 140, 88)
        blocksMap[Material.BIRCH_FENCE] = Color(202, 185, 131)
        blocksMap[Material.JUNGLE_FENCE] = Color(172, 124, 89)
        blocksMap[Material.ACACIA_FENCE] = Color(178, 102, 60)
        blocksMap[Material.DARK_OAK_FENCE] = Color(62, 41, 18)
        blocksMap[Material.SPRUCE_STAIRS] = Color(100, 78, 47)
        blocksMap[Material.OAK_STAIRS] = Color(172, 140, 88)
        blocksMap[Material.BIRCH_STAIRS] = Color(202, 185, 131)
        blocksMap[Material.JUNGLE_STAIRS] = Color(172, 124, 89)
        blocksMap[Material.ACACIA_STAIRS] = Color(178, 102, 60)
        blocksMap[Material.DARK_OAK_STAIRS] = Color(62, 41, 18)
        blocksMap[Material.SPRUCE_SLAB] = Color(100, 78, 47)
        blocksMap[Material.OAK_SLAB] = Color(172, 140, 88)
        blocksMap[Material.BIRCH_SLAB] = Color(202, 185, 131)
        blocksMap[Material.JUNGLE_SLAB] = Color(172, 124, 89)
        blocksMap[Material.ACACIA_SLAB] = Color(178, 102, 60)
        blocksMap[Material.DARK_OAK_SLAB] = Color(62, 41, 18)
        blocksMap[Material.CRAFTING_TABLE] = Color(172, 140, 88)
        blocksMap[Material.BOOKSHELF] = Color(172, 140, 88)
        blocksMap[Material.SUGAR_CANE] = Color(71, 139, 42)
        blocksMap[Material.BEDROCK] = Color(47, 47, 47)
        blocksMap[Material.TORCH] = Color(206, 173, 26)
        blocksMap[Material.PUMPKIN] = Color(222, 141, 28)
        blocksMap[Material.CARVED_PUMPKIN] = Color(222, 141, 28)
        blocksMap[Material.JACK_O_LANTERN] = Color(222, 141, 28)
        blocksMap[Material.TNT] = Color(203, 49, 26)
        blocksMap[Material.BLACK_WOOL] = Color(6, 7, 12)
        blocksMap[Material.WHITE_WOOL] = Color(225, 226, 228)
        blocksMap[Material.BLUE_WOOL] = Color(45, 50, 145)
        blocksMap[Material.BROWN_WOOL] = Color(105, 70, 39)
        blocksMap[Material.CYAN_WOOL] = Color(21, 139, 145)
        blocksMap[Material.GRAY_WOOL] = Color(64, 67, 72)
        blocksMap[Material.GREEN_WOOL] = Color(83, 108, 20)
        blocksMap[Material.LIGHT_BLUE_WOOL] = Color(121, 148, 202)
        blocksMap[Material.LIGHT_GRAY_WOOL] = Color(164, 168, 169)
        blocksMap[Material.LIME_WOOL] = Color(122, 198, 38)
        blocksMap[Material.MAGENTA_WOOL] = Color(188, 66, 179)
        blocksMap[Material.ORANGE_WOOL] = Color(240, 125, 30)
        blocksMap[Material.PINK_WOOL] = Color(242, 148, 177)
        blocksMap[Material.PURPLE_WOOL] = Color(129, 65, 182)
        blocksMap[Material.RED_WOOL] = Color(155, 53, 49)
        blocksMap[Material.YELLOW_WOOL] = Color(195, 182, 47)
        blocksMap[Material.BLACK_BANNER] = Color(6, 7, 12)
        blocksMap[Material.WHITE_BANNER] = Color(225, 226, 228)
        blocksMap[Material.BLUE_BANNER] = Color(45, 50, 145)
        blocksMap[Material.BROWN_BANNER] = Color(105, 70, 39)
        blocksMap[Material.CYAN_BANNER] = Color(21, 139, 145)
        blocksMap[Material.GRAY_BANNER] = Color(64, 67, 72)
        blocksMap[Material.GREEN_BANNER] = Color(83, 108, 20)
        blocksMap[Material.LIGHT_BLUE_BANNER] = Color(121, 148, 202)
        blocksMap[Material.LIGHT_GRAY_BANNER] = Color(164, 168, 169)
        blocksMap[Material.LIME_BANNER] = Color(122, 198, 38)
        blocksMap[Material.MAGENTA_BANNER] = Color(188, 66, 179)
        blocksMap[Material.ORANGE_BANNER] = Color(240, 125, 30)
        blocksMap[Material.PINK_BANNER] = Color(242, 148, 177)
        blocksMap[Material.PURPLE_BANNER] = Color(129, 65, 182)
        blocksMap[Material.RED_BANNER] = Color(155, 53, 49)
        blocksMap[Material.YELLOW_BANNER] = Color(195, 182, 47)
        blocksMap[Material.BLACK_WALL_BANNER] = Color(6, 7, 12)
        blocksMap[Material.WHITE_WALL_BANNER] = Color(225, 226, 228)
        blocksMap[Material.BLUE_WALL_BANNER] = Color(45, 50, 145)
        blocksMap[Material.BROWN_WALL_BANNER] = Color(105, 70, 39)
        blocksMap[Material.CYAN_WALL_BANNER] = Color(21, 139, 145)
        blocksMap[Material.GRAY_WALL_BANNER] = Color(64, 67, 72)
        blocksMap[Material.GREEN_WALL_BANNER] = Color(83, 108, 20)
        blocksMap[Material.LIGHT_BLUE_WALL_BANNER] = Color(121, 148, 202)
        blocksMap[Material.LIGHT_GRAY_WALL_BANNER] = Color(164, 168, 169)
        blocksMap[Material.LIME_WALL_BANNER] = Color(122, 198, 38)
        blocksMap[Material.MAGENTA_WALL_BANNER] = Color(188, 66, 179)
        blocksMap[Material.ORANGE_WALL_BANNER] = Color(240, 125, 30)
        blocksMap[Material.PINK_WALL_BANNER] = Color(242, 148, 177)
        blocksMap[Material.PURPLE_WALL_BANNER] = Color(129, 65, 182)
        blocksMap[Material.RED_WALL_BANNER] = Color(155, 53, 49)
        blocksMap[Material.YELLOW_WALL_BANNER] = Color(195, 182, 47)
        blocksMap[Material.BLACK_CONCRETE] = Color(7, 9, 14)
        blocksMap[Material.WHITE_CONCRETE] = Color(199, 202, 207)
        blocksMap[Material.BLUE_CONCRETE] = Color(42, 44, 133)
        blocksMap[Material.BROWN_CONCRETE] = Color(91, 57, 30)
        blocksMap[Material.CYAN_CONCRETE] = Color(20, 113, 129)
        blocksMap[Material.GRAY_CONCRETE] = Color(118, 119, 110)
        blocksMap[Material.GREEN_CONCRETE] = Color(88, 156, 25)
        blocksMap[Material.LIGHT_BLUE_CONCRETE] = Color(33, 130, 190)
        blocksMap[Material.LIGHT_GRAY_CONCRETE] = Color(195, 203, 206)
        blocksMap[Material.LIME_CONCRETE] = Color(90, 162, 23)
        blocksMap[Material.MAGENTA_CONCRETE] = Color(162, 47, 152)
        blocksMap[Material.ORANGE_CONCRETE] = Color(207, 81, 1)
        blocksMap[Material.PINK_CONCRETE] = Color(205, 95, 138)
        blocksMap[Material.PURPLE_CONCRETE] = Color(155, 45, 145)
        blocksMap[Material.RED_CONCRETE] = Color(136, 30, 33)
        blocksMap[Material.YELLOW_CONCRETE] = Color(222, 162, 19)
        blocksMap[Material.CRAFTING_TABLE] = Color(33, 23, 57)
        blocksMap[Material.ENCHANTING_TABLE] = Color(33, 23, 57)
        blocksMap[Material.SNOW] = Color(232, 240, 239)
        blocksMap[Material.SNOW_BLOCK] = Color(232, 240, 239)
        for (i in -10..10) {
            for (j in -10..10) {
                var k = y
                while(!block && k > y-20) {
                    if (player.world.getBlockAt(x + i, k, z + j).type != Material.AIR && player.world.getBlockAt(x + i, k, z + j).type != Material.CAVE_AIR && player.world.getBlockAt(x + i, k, z + j).type != Material.VOID_AIR) {
                        block = true
                        if(blocksMap.containsKey(player.world.getBlockAt(x + i, k, z + j))) {
                            canvas.setPixel((x + i) - map.centerX, (z + j) - map.centerZ, MapPalette.matchColor(blocksMap[player.world.getBlockAt(x + i, k, z + j)]!!))
                        }else{
                            canvas.setPixel((x + i) - map.centerX, (z + j) - map.centerZ, MapPalette.matchColor(1,1,1))
                        }
                    }else{
                        k--
                        if(k == y - 20){
                            canvas.setPixel((x + i) - map.centerX, (z + j) - map.centerZ, MapPalette.matchColor(0,0,0))
                        }
                    }
                }
            }
        }
    }
}