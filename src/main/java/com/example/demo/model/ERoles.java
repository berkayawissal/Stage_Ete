package com.example.demo.model;

import com.jayway.jsonpath.JsonPath;

import java.util.stream.Stream;

public enum ERoles {
    ADMIN,USER,LIVREUR,DISTRIBUTEUR,POINT_DE_VENTE,END_USER;

    public Stream<ERoles> stream() {
        return Stream.of(ERoles.values());
    }
}
