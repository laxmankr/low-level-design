package com.bookshow.services;

import com.bookshow.model.User;
import com.bookshow.model.Slot;

public interface WaitlistService {
    void addToWaitlist(User user, Slot slot);

    User getNextFromWaitlist(Slot slot);
}