package com.maceight;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Player    implements Comparable<Player> {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("h_in")
    private Double inches;
    @JsonProperty("h_meters")
    private Double meters;
    @JsonProperty("last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Double getInches() {
        return inches;
    }
    public void setInches(String inches) {
        this.inches = Double.parseDouble(inches);
    }
    public Double getMeters() {
        return meters;
    }
    public void setMeters(String meters) {
        this.meters = Double.parseDouble(meters);
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return new StringBuilder(firstName).append(" ").append(lastName).toString();

    }



    @Override
    public int compareTo(Player player) {
        int result = this.getFirstName().compareTo(player.getFirstName());
        if(result == 0) {
            result =   this.getLastName().compareTo(player.getLastName());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return firstName.equals(player.firstName) && lastName.equals(player.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
