/*
 * Copyright (c) 2025. gitoido-mc
 * This Source Code Form is subject to the terms of the MIT License.
 * If a copy of the MIT License was not distributed with this file,
 * you can obtain one at https://github.com/gitoido-mc/rad-gyms/blob/main/LICENSE.
 *
 */

package lol.gito.radgyms.block

import io.wispforest.owo.registration.reflect.BlockRegistryContainer
import lol.gito.radgyms.item.group.ItemGroupManager
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item

class BlockRegistry : BlockRegistryContainer {
    companion object {
        @JvmField
        val GYM_ENTRANCE = GymEntranceBlock(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS))

        @JvmField
        val GYM_EXIT = GymExitBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK))

        @JvmField
        val SHARD_BLOCK_COMMON = CommonShardBlock()

        @JvmField
        val SHARD_BLOCK_UNCOMMON = UncommonShardBlock()

        @JvmField
        val SHARD_BLOCK_RARE = RareShardBlock()

        @JvmField
        val SHARD_BLOCK_EPIC = EpicShardBlock()
    }

    override fun createBlockItem(block: Block, identifier: String): BlockItem {
        val baseSettings = Item.Settings().group(ItemGroupManager.GYMS_GROUP)

        val settings = if (block is PokeShardBlockBase) baseSettings.rarity(block.rarity) else baseSettings

        return BlockItem(block, settings ?: baseSettings)
    }
}
