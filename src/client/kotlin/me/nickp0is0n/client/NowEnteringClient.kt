package me.nickp0is0n.client

import me.nickp0is0n.NowEntering
import me.nickp0is0n.client.widgets.NewBiomeWidget
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements
import net.minecraft.client.DeltaTracker
import net.minecraft.client.gui.GuiGraphicsExtractor
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component
import net.minecraft.resources.Identifier
import net.minecraft.world.level.biome.Biome

object NowEnteringClient : ClientModInitializer {
    override fun onInitializeClient() {
        var lastBiomeId: Identifier? = null

        ClientTickEvents.START_CLIENT_TICK.register { client ->
            val player = client.player
            if (player != null && client.level != null) {
                var currentBiomeEntry = client.level?.getBiome(player.blockPosition()) ?: return@register
                val currentBiomeId = currentBiomeEntry.unwrapKey()
                    .map { key -> key.identifier() }
                    .orElse(null) ?: return@register

                if (currentBiomeId != lastBiomeId) {
                    lastBiomeId = currentBiomeId
                    onBiomeChange(player, currentBiomeId)
                }
            }
        }
    }

    private fun onBiomeChange(player: LocalPlayer, newBiomeId: Identifier) {
        println("Biome changed: $newBiomeId")
        val translationKey = "biome.${newBiomeId.namespace}.${newBiomeId.path}"
        val localizedName = Component.translatable(translationKey).string
        HudElementRegistry.attachElementBefore(
            VanillaHudElements.CHAT, NowEntering.id("before_chat"),
            NewBiomeWidget(100, 0, 100, 100, localizedName)
        )
    }
}