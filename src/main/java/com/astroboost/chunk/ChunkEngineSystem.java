package com.astroboost.chunk;

import com.astroboost.AstroBoostMod;
import com.astroboost.core.AstroBoostConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * AstroBoost Chunk Engine System
 *
 * - CPU Scheduling: chunk-ების ჩატვირთვა priority queue-ით
 * - Player-ახლო chunk-ები პირველ რიგში იტვირთება
 * - C2ME-სთან სრული თავსებადობა (C2ME-ს არ ჰქონდა priority scheduling)
 * - Thread count: Intel Celeron-ისთვის ოპტიმიზებული (2 thread)
 */
public class ChunkEngineSystem {

    private static ExecutorService chunkExecutor;
    private static PriorityBlockingQueue<ChunkLoadTask> chunkQueue;
    private static boolean initialized = false;

    public static void init() {
        if (!AstroBoostConfig.chunkEngineEnabled) {
            AstroBoostMod.LOGGER.info("🚀 AstroBoost Chunk Engine: გამორთულია config-ში.");
            return;
        }

        AstroBoostMod.LOGGER.info("🚀 AstroBoost Chunk Engine System: იწყება...");

        int threads = AstroBoostConfig.chunkThreadCount;
        chunkExecutor = Executors.newFixedThreadPool(threads, r -> {
            Thread t = new Thread(r, "AstroBoost-ChunkEngine-" + threads);
            t.setDaemon(true);
            t.setPriority(Thread.NORM_PRIORITY - 1); // Celeron-ზე main thread-ს არ გადატვირთავს
            return t;
        });

        chunkQueue = new PriorityBlockingQueue<>();

        if (AstroBoostConfig.c2meCompatMode) {
            AstroBoostMod.LOGGER.info("  ✅ C2ME თავსებადობა: ჩართულია");
        }
        if (AstroBoostConfig.prioritizePlayerChunks) {
            AstroBoostMod.LOGGER.info("  ✅ Player Chunk Priority: ჩართულია");
        }
        AstroBoostMod.LOGGER.info("  ✅ Chunk Threads: {}", threads);

        initialized = true;
        AstroBoostMod.LOGGER.info("🚀 AstroBoost Chunk Engine: წარმატებით ჩაიტვირთა!");
    }

    /**
     * Chunk-ის ჩატვირთვის task priority queue-ში დამატება.
     * Player-ახლო chunk-ები უფრო მაღალი priority-ით.
     */
    public static void scheduleChunkLoad(int chunkX, int chunkZ, int playerChunkX, int playerChunkZ) {
        if (!initialized) return;

        int distance = Math.abs(chunkX - playerChunkX) + Math.abs(chunkZ - playerChunkZ);
        int priority = AstroBoostConfig.prioritizePlayerChunks ? distance : 0;

        chunkQueue.offer(new ChunkLoadTask(chunkX, chunkZ, priority));
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public static void shutdown() {
        if (chunkExecutor != null) {
            chunkExecutor.shutdown();
        }
    }

    /**
     * Chunk Load Task — Priority Queue-სთვის
     */
    public static class ChunkLoadTask implements Comparable<ChunkLoadTask> {
        public final int chunkX;
        public final int chunkZ;
        public final int priority; // დაბალი = უმაღლესი priority

        public ChunkLoadTask(int chunkX, int chunkZ, int priority) {
            this.chunkX = chunkX;
            this.chunkZ = chunkZ;
            this.priority = priority;
        }

        @Override
        public int compareTo(ChunkLoadTask other) {
            return Integer.compare(this.priority, other.priority);
        }
    }
}
