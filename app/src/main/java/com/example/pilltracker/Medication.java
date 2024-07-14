package com.example.pilltracker;

import java.time.LocalDateTime;

/**
 *  Medication model
 */
public class Medication {
    private String name;

    private String dosage;

    private String frequency;

    // TODO multiple times a day
    // TODO non-scheduled
    // TODO every n-days / day of week
    private LocalDateTime reminder;

    public Medication(String name, String dosage, String frequency) {
        this.name = name;
        this.dosage = dosage;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public String getDose() {
        return dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setReminder(LocalDateTime reminder) {
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "name='" + name + '\'' +
                ", dosage='" + dosage + '\'' +
                ", reminder=" + reminder +
                '}';
    }
}
