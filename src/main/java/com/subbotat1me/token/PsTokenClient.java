package com.subbotat1me.token;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.client.gui.screens.inventory.ShulkerBoxScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
//import net.minecraft.client.gui.screens.PauseScreen;

public class PsTokenClient {
    static final String MOD_ID = "pstoken_mod";
    static final int FRAMES = 211;
    static final double MS_PER_FRAME = 7100.0 / FRAMES;
    static long start = -1;

    static final SoundEvent SOUND = SoundEvent.createVariableRangeEvent(
            Identifier.fromNamespaceAndPath(MOD_ID, "token_getting"));
    static final Identifier[] TEX = new Identifier[FRAMES];
    static {
        for (int i = 0; i < FRAMES; i++) {
            TEX[i] = Identifier.fromNamespaceAndPath(MOD_ID,
                    String.format("textures/gui/pstoken_vid_%03d.png", i + 1));
        }
    }

    @SubscribeEvent
    public static void onScreenOpen(ScreenEvent.Opening e) {
        Screen s = e.getNewScreen();
        boolean container = s instanceof ContainerScreen || s instanceof ShulkerBoxScreen;
        if (container && start < 0 && new Random().nextInt(PsTokenConfig.ONE_IN.get()) == 0) {
            start = System.currentTimeMillis();
            Minecraft.getInstance().getSoundManager()
                    .play(SimpleSoundInstance.forUI(SOUND, 1.0f));
        }
    }

    //@SubscribeEvent
    //public static void onScreenRender(ScreenEvent.Render.Post e) {
    //    // поверх меню паузы (ESC) не рисуем
    //    if (e.getScreen() instanceof PauseScreen) return;
    //    draw(e.getGuiGraphics());
    //}

    @SubscribeEvent
    public static void onHudRender(RenderGuiEvent.Post e) {
        draw(e.getGuiGraphics());
    }

    static void draw(GuiGraphicsExtractor g) {
        if (start < 0) return;
        int frame = (int) ((System.currentTimeMillis() - start) / MS_PER_FRAME);
        if (frame >= FRAMES) { start = -1; return; }
        var w = Minecraft.getInstance().getWindow();
        int sw = w.getGuiScaledWidth(), sh = w.getGuiScaledHeight();
        //g.blit(RenderPipelines.GUI_TEXTURED, TEX[frame], 0, 0, 0, 0, sw, sh, 854, 480, 854, 480);
        g.blit(RenderPipelines.GUI_TEXTURED, TEX[frame], 0, 0, 0, 0, sw, sh, 1920, 1080, 1920, 1080);
    }
}