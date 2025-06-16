package org.skypro.skyshop.product;

interface Searchable {

    String searchTerm();

    String contentType();

    String getName();

    default String getStringRepresentation() {
        return getName() + contentType();
    }
}