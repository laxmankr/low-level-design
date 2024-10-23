package com.bookshow.services.impl;

import com.bookshow.exceptions.ShowException;
import com.bookshow.model.Genre;
import com.bookshow.model.Show;
import com.bookshow.model.Slot;
import com.bookshow.repository.ShowRepository;
import com.bookshow.repository.SlotRepository;
import com.bookshow.services.ShowService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowServiceImpl implements ShowService {
    private ShowRepository showRepository;
    private SlotRepository slotRepository;

    public ShowServiceImpl(ShowRepository showRepository, SlotRepository slotRepository) {
        this.showRepository = showRepository;
        this.slotRepository = slotRepository;
    }

    @Override
    public void registerShow(String showName, Genre genre) {
        if (showRepository.findShowByName(showName) != null) {
            throw new ShowException("Show already registered");
        }
        Show show = new Show(showName, genre);
        showRepository.saveShow(show);
        System.out.println("\nShow="+showName+" is registered successfully!!");
    }

    private boolean isValidSlot(Slot slot, Show show){
        List<Slot> slots = slotRepository.findSlotsByShow(show.getShowName());
        if(slots.stream().anyMatch(s -> s.getTimeSlot().equals(slot.getTimeSlot()))){
            System.out.println("Slot "+ slot.getTimeSlot() +" already exists for Show "+show.getShowName());
            return false;
        }
        String[] period = slot.getTimeSlot().split("[-:]");
        System.out.println(Arrays.toString(period));
        return Integer.parseInt(period[2]) - Integer.parseInt(period[0]) == 1 && Integer.parseInt(period[1]) == Integer.parseInt(period[3]);
    }

    @Override
    public void onboardShowSlots(String showName, List<Slot> slots) {
        Show show = showRepository.findShowByName(showName);
        if(!show.getSlots().isEmpty()){
            System.out.println("Slots has beed alrady added, we can not add/modify the slots");
            return;
        }
        if (show == null) {
            throw new ShowException(showName+" not found");

        }
        List<Slot> validSlots = new ArrayList<>();
        for (Slot slot : slots) {
            if(isValidSlot(slot, show)) {
                slotRepository.saveSlot(showName, slot);
                validSlots.add(slot);
            }else{
                System.out.println(slot.getTimeSlot() + " are invalid slot");
            }
        }

        show.setSlots(validSlots);
        showRepository.saveShow(show);
        System.out.println("\nShow details:" + validSlots);
        System.out.println(showRepository.findShowByName(showName).toString());
        System.out.println("\nSlots are onboarded for " + showName);
    }

    @Override
    public List<Show> showAvailByGenre(Genre genre) {
//        System.out.println("\nShow available for Genre: " + genre);
        return showRepository.findAllShowsByGenre(genre);
    }
}
