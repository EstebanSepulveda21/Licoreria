package com.licoreria.licoreria.shared.domain.valueObjects;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class Identifier {

    protected final Long value;

    public Identifier(Long value){
        //ensureValidUuid(value);
        this.value = value;
    }

   /* private void ensureValidUuid(Long value) {
        UUID.fromString(String.valueOf(value));
    }*/

    private Long value(){return value;}
}
