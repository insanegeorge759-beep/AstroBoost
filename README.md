# 🚀 AstroBoost — Fabric 1.21.11

**The ultimate performance mod for low-end PCs**

## სისტემები

### 1. 💡 Light Engine Rewrite
- Crystal, TNT, Respawn Anchor, Wither აფეთქების lag-ის fix
- Async სინათლის განახლებები — lag spike-ები აღარ იქნება
- StarLight/ScalableLux-ის მსგავსი მიდგომა

### 2. ⚡ Chunk Engine System
- CPU Priority Scheduling — player-ახლო chunk-ები პირველ რიგში
- C2ME-სთან სრული თავსებადობა
- Intel Celeron-ისთვის ოპტიმიზებული (2 thread)

### 3. 🎛️ AstroBoost GUI
- **F8** → AstroBoost Settings გახსნა
- ან: ESC → Options → AstroBoost
- ყველაფერი თავიდანვე Low FPS რეჟიმზეა:
  - Particles: Off
  - Animations: Off
  - Water/Lava Animation: Off
  - Weather Effects: Off
  - Portal Animation: Off

## დაყენება
1. გადმოწერე Fabric Loader 1.21.11
2. გადმოწერე Fabric API 1.21.11
3. ჩააგდე `astroboost-1.0.0.jar` → `mods` საქაღალდეში

## Build
```bash
./gradlew build
```
JAR: `build/libs/astroboost-1.0.0.jar`

## თავსებადი Mod-ები
- ✅ C2ME
- ✅ Sodium
- ✅ Lithium
- ✅ EntityCulling
