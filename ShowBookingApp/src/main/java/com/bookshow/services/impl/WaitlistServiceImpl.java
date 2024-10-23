package com.bookshow.services.impl;

import com.bookshow.model.User;
import com.bookshow.model.Slot;
import com.bookshow.services.WaitlistService;

public class WaitlistServiceImpl implements WaitlistService {

    @Override
    public void addToWaitlist(User user, Slot slot) {
        slot.getWaitlist().add(user);
    }

    @Override
    public User getNextFromWaitlist(Slot slot) {
        if (!slot.getWaitlist().isEmpty()) {
            return slot.getWaitlist().remove(0);
        }
        return null;
    }
}