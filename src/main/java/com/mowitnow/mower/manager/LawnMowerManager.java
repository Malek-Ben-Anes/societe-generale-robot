package com.mowitnow.mower.manager;

import com.mowitnow.mower.model.Lawn;
import com.mowitnow.mower.model.LawnMower;

import java.util.ArrayList;
import java.util.List;

public class LawnMowerManager {
    private final Lawn lawn;
    private List<LawnMower> lawnMowers;

    public LawnMowerManager(Lawn lawn) {
        this.lawn = lawn;
        this.lawnMowers = new ArrayList<>();
    }

    public void addLawnMower(LawnMower lawnMower) {
        lawnMowers.add(lawnMower);
    }

    public void runAllMowers() {
        for (LawnMower mower : lawnMowers) {
            mower.move(lawn);
            System.out.println(mower.getPosition());
        }
    }
}