package com.djinfinite.manors_bounty.world.capability.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@AutoRegisterCapability
public class ModAttribute implements INBTSerializable<CompoundTag> {
    private final HashMap<String,Integer> concurrentHashMap = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public ModAttribute() {
    }
    public synchronized int getCooldownValue(String key){
        lock.lock();
        try {
            return concurrentHashMap.getOrDefault(key,0);
        } finally {
            lock.unlock();
        }
    }
    public synchronized List<String> allKeys(){
        lock.lock();
        try {
            return concurrentHashMap.keySet().stream().toList();
        } finally {
            lock.unlock();
        }
    }
    public synchronized void setCooldownValue(String key,int cd){
        lock.lock();
        try {
            concurrentHashMap.put(key,cd);
        } finally {
            lock.unlock();
        }
    }
    public synchronized void removeCooldownValue(String key){
        lock.lock();
        try {
            concurrentHashMap.remove(key);
        } finally {
            lock.unlock();
        }
    }
    public synchronized void clearCooldownValue(){
        lock.lock();
        try {
            concurrentHashMap.clear();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        concurrentHashMap.forEach(tag::putInt);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        nbt.getAllKeys().forEach(s -> concurrentHashMap.put(s,nbt.getInt(s)));
    }
}
