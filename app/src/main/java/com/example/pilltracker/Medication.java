package com.example.pilltracker;

import java.time.LocalDateTime;

/**
 *  Medication model
 */
public class Medication {
    private String name;

    private String dosage;

    // TODO multiple times a day
    // TODO non-scheduled
    // TODO every n-days / day of week
    private LocalDateTime reminder;

    public Medication(String name, String dosage) {
        this.name = name;
        this.dosage = dosage;
    }

    public String getName() {
        return name;
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
