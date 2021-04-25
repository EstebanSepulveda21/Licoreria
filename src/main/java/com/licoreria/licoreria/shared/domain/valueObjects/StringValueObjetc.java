package com.licoreria.licoreria.shared.domain.valueObjects;

import lombok.Data;

import java.util.Objects;

@Data
public abstract class StringValueObjetc {

    protected final String value;

    public StringValueObjetc(String value) {

        this.value = value;
    }

    public String value(){

        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringValueObjetc that = (StringValueObjetc) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
