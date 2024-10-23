package com.bookshow.repository;

import com.bookshow.model.Slot;

import java.util.List;

public interface SlotRepository {
    void saveSlot(String showName, Slot slot);
    Slot findSlotByShowAndTime(String showName, String timeSlot);
    List<Slot> findSlotsByShow(String showName);
}
