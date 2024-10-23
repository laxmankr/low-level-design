package org.bookmyshow.model;

class User {
    private int id;
    private String name;
    private boolean isRegistered;

    public User(int id, String name, boolean isRegistered) {
        this.id = id;
        this.name = name;
        this.isRegistered = isRegistered;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

}
