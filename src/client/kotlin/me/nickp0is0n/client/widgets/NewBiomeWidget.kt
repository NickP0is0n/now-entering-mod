package me.nickp0is0n.client.widgets

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement
import net.minecraft.client.DeltaTracker
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphicsExtractor
import net.minecraft.client.gui.components.AbstractWidget
import net.minecraft.client.gui.narration.NarrationElementOutput
import net.minecraft.network.chat.Component

class NewBiomeWidget(
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int,
    private val biome: String
) :
    HudElement {
    override fun extractRenderState(graphics: GuiGraphicsExtractor, tickCounter: DeltaTracker) {
        val colorBg = Integer.parseUnsignedInt("FF191919", 16)
        val colorBorder = Integer.parseUnsignedInt("FF464648", 16)
        val font = Minecraft.getInstance().font

        val primaryTextColor = Integer.parseUnsignedInt("FFFFFFFF", 16)
        val secondaryTextColor = Integer.parseUnsignedInt("FFD9D9D9", 16)

        renderRoundedRectangle(graphics, x, y, width, height, colorBg, colorBorder)
        graphics.centeredText(font, Component.literal("Now entering"), x + 1, y + 4, secondaryTextColor)
        graphics.centeredText(font, Component.literal(biome), x + 1, y + 15, primaryTextColor)
    }

    private fun renderRoundedRectangle(
        graphics: GuiGraphicsExtractor,
        startX: Int,
        startY: Int,
        width: Int,
        height: Int,
        colorBg: Int,
        colorBorder: Int
    ) {
        val startOffsets = listOf(3, 1, 1)
        val endOffsets = startOffsets.reversed()

        println("Drawing biome widget: $startX $startY $width $height $colorBg $colorBorder")
        for (i in startY..(startY + height)) {
            print("Drawing line $i ")
            when (i) {
                startY -> {
                    graphics.fill(startX + startOffsets[0], i, startX + width - startOffsets[0], i + 1, colorBorder)
                }

                (startY + height - 1) -> {
                    graphics.fill(startX + endOffsets[2], i, startX + width - endOffsets[2], i + 1, colorBorder)
                }

                else -> {
                    val positionStartX = startX + if (i < startOffsets.size) startOffsets[i] else 0
                    val positionEndX = startX + width - if (i < startOffsets.size) startOffsets[i] else 0
                    graphics.fill(positionStartX, i, positionStartX, i + 1, colorBorder)
                    graphics.fill(positionEndX, i, positionEndX, i + 1, colorBorder)
                    graphics.fill(positionStartX + 1, i, positionEndX - 1, i + 1, colorBg)
                }
            }
        }
    }
}