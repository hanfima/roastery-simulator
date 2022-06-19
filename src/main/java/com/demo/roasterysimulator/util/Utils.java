package com.demo.roasterysimulator.util;

import java.util.Random;

public class Utils {

    public static double generateRandom(double min, double max) {
        Random random = new Random();
        return random.doubles(min, max).findFirst().getAsDouble();
    }

    public static int generateRandom(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }
}
