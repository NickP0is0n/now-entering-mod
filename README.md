# Now Entering

**Now Entering** is a lightweight client-side Minecraft mod for Fabric that displays a sleek, rounded HUD banner at the top of your screen whenever you enter a new biome.

## Features

- **Biome Entry Notifications:** Automatically detects when you cross into a different biome and displays a `"Now entering <Biome>"` pop-up banner for 5 seconds.
- **Localized Biome Names:** Uses Minecraft's built-in translation keys so biome names automatically appear in your selected game language (including custom/modded biomes with localization).
- **Minimalist UI:** Renders a clean, custom-drawn rounded dark HUD card that stays out of the way of your gameplay.

---

## Requirements

To install and play with **Now Entering**, you need the following:

| Requirement | Version |
| :--- | :--- |
| **Minecraft** | `26.3` |
| **Java** | `25` or newer |
| **Fabric Loader** | `0.20.1` or newer |
| **[Fabric API](https://modrinth.com/mod/fabric-api)** | `0.165.2+26.3` (or compatible `26.3` release) |
| **[Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin)** | `1.14.2+kotlin.2.4.21` or newer |

### Installation

1. Install [Fabric Loader](https://fabricmc.net/use/installer/) for Minecraft `26.3`.
2. Download **[Fabric API](https://modrinth.com/mod/fabric-api)** and **[Fabric Language Kotlin](https://modrinth.com/mod/fabric-language-kotlin)** and place their `.jar` files into your Minecraft `mods` folder.
3. Download the latest **Now Entering** `.jar` release and place it into your `mods` folder.
4. Launch Minecraft with the Fabric profile.

---

## Building from Source

### Prerequisites

- **JDK 25** or newer installed and configured in your `PATH` / `JAVA_HOME`.
- **Git** (to clone the repository).

### Build Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/nickp0is0n/now-entering.git
   cd now-entering
   ```

2. Build the mod using the included Gradle wrapper:
   - **macOS / Linux:**
     ```bash
     ./gradlew build
     ```
   - **Windows (Command Prompt / PowerShell):**
     ```powershell
     .\gradlew.bat build
     ```

3. Once the build finishes, the compiled mod `.jar` can be found in:
   ```text
   build/libs/
   ```

### Running in Development

To launch a test Minecraft client directly from the source tree:

```bash
./gradlew runClient
```

---

## License

This project is available under the [CC0-1.0 License](LICENSE).
