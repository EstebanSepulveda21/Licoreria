package com.licoreria.licoreria.controllers;

import org.junit.jupiter.api.Test;
import java.util.UUID;

public class BrandsPutControllerShould extends RequestTestCase  {

    @Test
    public void create() throws Exception {

        assertRequestWithBody("POST",
                              "/api/v1/brands/" + UUID.randomUUID().toString(),
                              "{\"name\":\"UwUsoft\"}",
                              201);

    }



}
