package com.subbotat1me.token;

import net.neoforged.neoforge.common.ModConfigSpec;

public class PsTokenConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.IntValue ONE_IN = BUILDER
            .comment("Chance is 1 in N each time a chest, barrel or shulker box is opened. 1 = every time.")
            .defineInRange("oneIn", 10000, 1, 1_000_000_000);

    public static final ModConfigSpec SPEC = BUILDER.build();
}