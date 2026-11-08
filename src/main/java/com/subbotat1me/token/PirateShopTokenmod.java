package com.subbotat1me.token;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
// dist = Dist.CLIENT: мод загружается только на клиенте
@Mod(value = PirateShopTokenmod.MODID, dist = Dist.CLIENT)
public class PirateShopTokenmod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "pstoken_mod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public PirateShopTokenmod(IEventBus modEventBus, ModContainer modContainer) {
        // Подключаем обработчики событий из PsTokenClient
        NeoForge.EVENT_BUS.register(PsTokenClient.class);
        modContainer.registerConfig(ModConfig.Type.CLIENT, PsTokenConfig.SPEC);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}