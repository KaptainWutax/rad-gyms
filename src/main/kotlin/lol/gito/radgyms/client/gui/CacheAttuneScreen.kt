/*
 * Copyright (c) 2025. gitoido-mc
 * This Source Code Form is subject to the terms of the MIT License.
 * If a copy of the MIT License was not distributed with this file,
 * you can obtain one at https://github.com/gitoido-mc/rad-gyms/blob/main/LICENSE.
 *
 */

package lol.gito.radgyms.client.gui

import com.cobblemon.mod.common.api.types.ElementalType
import com.cobblemon.mod.common.api.types.ElementalTypes
import io.wispforest.owo.ui.base.BaseUIModelScreen
import io.wispforest.owo.ui.component.ButtonComponent
import io.wispforest.owo.ui.container.FlowLayout
import io.wispforest.owo.ui.core.Component
import io.wispforest.owo.ui.core.Insets
import lol.gito.radgyms.client.gui.GymGUIIdentifiers.ID_CANCEL
import lol.gito.radgyms.client.gui.GymGUIIdentifiers.ID_TYPES
import lol.gito.radgyms.client.gui.GymGUIIdentifiers.UI_CACHE_ATTUNE
import lol.gito.radgyms.client.gui.widget.CacheInfoHolder
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.Rarity

class CacheAttuneScreen(
    val player: PlayerEntity,
    val rarity: Rarity,
    private val shinyBoost: Int
) :
    BaseUIModelScreen<FlowLayout>(FlowLayout::class.java, DataSource.asset(UI_CACHE_ATTUNE)) {
    lateinit var root: FlowLayout

    override fun build(root: FlowLayout) {
        this.root = root

        root.childById(FlowLayout::class.java, ID_TYPES).children(buildElementalTypesCollection())
        root.childById(FlowLayout::class.java, "cache")
        root.childById(ButtonComponent::class.java, ID_CANCEL).onPress {
            this.close()
        }
    }

    private fun buildElementalTypesCollection(): MutableCollection<out Component> {
        val collection: MutableCollection<Component> = mutableListOf()

        for (type in ElementalTypes.all()) {
            collection.add(buildElementalTypeComposable(type))
        }

        return collection
    }

    private fun buildElementalTypeComposable(type: ElementalType): Component {
        val panel = CacheInfoHolder(player, type, rarity, shinyBoost)
        panel.padding(Insets.bottom(2))
        panel.id("cache")
        panel.build()

        return panel
    }
}
