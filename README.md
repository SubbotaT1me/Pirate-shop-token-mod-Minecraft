# Pirate Shop Token mod

Can't get the Pirate Shop Token in Fortnite? You'll definitely get it in Minecraft!

Every time you open a chest, a barrel or a shulker box, there's a tiny chance (1 in 10,000 by default) that a full-screen Pirate Shop Token animation with sound plays on your screen. It's purely visual: nothing is added to your inventory and nothing changes in your world.

## Features

- Random chance when opening chests, barrels and shulker boxes
- Full-screen animation with sound
- Configurable chance (in-game: Mods → Pirate Shop Token mod → Config)
- Client-side only, no need to install it on servers

## Installation

1. Install NeoForge for Minecraft 26.3
2. Download the mod from [Modrinth](https://modrinth.com/mod/pstoken) (put your real link here)
3. Put the `.jar` file into your `mods` folder

## Configuration

The config file is `config/pstoken_mod-client.toml`:

```toml
oneIn = 10000
```

The value means "1 in N" per container opened. Set it to `1` to see the animation every time.

## Building from source

Requirements: JDK 25.

```
gradlew build
```

The built jar will be in `build/libs`.

The animation frames and the sound are not included in this repository.
To build a working jar, add them yourself:

- frames: `src/main/resources/assets/pstoken_mod/textures/gui/pstoken_vid_001.png` ... `pstoken_vid_211.png`
- sound: `src/main/resources/assets/pstoken_mod/sounds/token_getting_sound.ogg`

## Issues

Found a bug? Please open an issue on the
[issue tracker](https://github.com/Minemax10/Pirate-shop-token-mod-Minecraft/issues).

## License

All Rights Reserved (see `LICENSE`).

## Disclaimer

This is an unofficial fan project and is not affiliated with, endorsed by
or sponsored by Epic Games. Fortnite and the Pirate Shop Token are the
property of Epic Games, Inc. This mod is free and non-commercial.
