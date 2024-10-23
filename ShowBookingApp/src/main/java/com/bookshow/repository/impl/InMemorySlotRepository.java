package com.bookshow.repository.impl;

import com.bookshow.model.Slot;
import com.bookshow.repository.SlotRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemorySlotRepository implements SlotRepository {
    private Map<String, List<Slot>> slotStorage = new HashMap<>();

    @Override
    public void saveSlot(String showName, Slot slot) {
        slotStorage.putIfAbsent(showName, new ArrayList<>());
        slotStorage.get(showName).add(slot);
    }

    @Override
    public Slot findSlotByShowAndTime(String showName, String timeSlot) {
        List<Slot> slots = slotStorage.get(showName);
        if (slots != null) {
            for (Slot slot : slots) {
                if (slot.getTimeSlot().equals(timeSlot)) {
                    return slot;
                }
            }
        }
        return null;
    }

    @Override
    public List<Slot> findSlotsByShow(String showName) {
        System.out.println("findSlotByShow get called ");
        return slotStorage.getOrDefault(showName, new ArrayList<>());
    }
}
