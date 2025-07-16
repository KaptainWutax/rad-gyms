/*
 * Copyright (c) 2025. gitoido-mc
 * This Source Code Form is subject to the terms of the MIT License.
 * If a copy of the MIT License was not distributed with this file,
 * you can obtain one at https://github.com/gitoido-mc/rad-gyms/blob/main/LICENSE.
 *
 */

package lol.gito.radgyms.item

import io.wispforest.owo.registration.reflect.ItemRegistryContainer

class ItemRegistry : ItemRegistryContainer {
    companion object {
        @JvmField
        val GYM_KEY = GymKey()

        @JvmField
        val EXIT_ROPE = ExitRope()

        @JvmField
        val SHARD_COMMON = CommonPokeShard()

        @JvmField
        val SHARD_UNCOMMON = UncommonPokeShard()

        @JvmField
        val SHARD_RARE = RarePokeShard()

        @JvmField
        val SHARD_EPIC = EpicPokeShard()

        @JvmField
        val CACHE_COMMON = CommonPokeCache()

        @JvmField
        val CACHE_UNCOMMON = UncommonPokeCache()

        @JvmField
        val CACHE_RARE = RarePokeCache()

        @JvmField
        val CACHE_EPIC = EpicPokeCache()
    }
}
