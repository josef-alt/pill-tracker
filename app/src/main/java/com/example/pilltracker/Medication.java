package com.example.pilltracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.OptionalLong;

/**
 *  Medication model
 */
public class Medication {
    private OptionalLong id;

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
        this.id = OptionalLong.empty();
    }

    public Medication(long id, String name, String dosage, String frequency) {
        this.name = name;
        this.dosage = dosage;
        this.frequency = frequency;
        this.id = OptionalLong.of(id);
    }

    public boolean hasId() {
        return id.isPresent();
    }

    public void setId(long id) {
        this.id = OptionalLong.of(id);
    }

    public long getId() {
        return id.getAsLong();
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

    public void setReminderFromISO(String iso) {
        reminder = LocalDateTime.parse(iso, DateTimeFormatter.ISO_TIME);
    }

    public LocalDateTime getReminder() {
        return reminder;
    }

    public String getReminderAsString() {
        return reminder.format(DateTimeFormatter.ISO_TIME);
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
