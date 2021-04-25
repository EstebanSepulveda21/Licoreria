package com.licoreria.licoreria.shared.domain.valueObjects;

import lombok.Data;

@Data
public abstract class StringValueObjetc {

    protected final String value;

    public StringValueObjetc(String value) {
        this.value = value;
    }

    public String value(){
        return this.value;
    }
}
