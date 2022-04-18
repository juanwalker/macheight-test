package com.maceight;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("values")
    Player[] values;

    public Player[] getValues() {
        return values;
    }

    public void setValues(Player[] values) {
        this.values = values;
    }
}
