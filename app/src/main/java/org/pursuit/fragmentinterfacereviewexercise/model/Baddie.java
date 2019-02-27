package org.pursuit.fragmentinterfacereviewexercise.model;

public class Baddie {
    private String name;
    private String instagram;
    private String image;

    public Baddie(String name, String instagram, String image) {
        this.name = name;
        this.instagram = instagram;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getImage() {
        return image;
    }
}

