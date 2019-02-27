package org.pursuit.fragmentinterfacereviewexercise.model;

import java.util.List;

public class BaddieList {
    private List<Baddie> baddies;

    public BaddieList(List<Baddie> baddies) {
        this.baddies = baddies;
    }

    public List<Baddie> getBaddiesList() {
        return baddies;
    }
}
