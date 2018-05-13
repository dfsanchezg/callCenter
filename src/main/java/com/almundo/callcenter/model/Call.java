package com.almundo.callcenter.model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The call class
 *
 * @Author Diego Sánchez
 */
public class Call {

    /**The duration*/
    private int duration;

    /** The call minimal duration time */
    private static final int MIN_DURATION = 5;

    /** The call maximum duration time */
    private static final int MAX_DURATION = 10;

    /**
     * Constructs a call
     */
    public Call() {

        this.duration = calculateDuration();
    }

    /**
     * Calculates the call duration
     *
     * @return the call duration time
     */
    private int calculateDuration(){

        return ThreadLocalRandom.current().nextInt(MIN_DURATION, MAX_DURATION);
    }

    /**
     * Gets the call duration
     *
     * @return the call duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the call duration
     *
     * @param duration the call duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
