package com.example;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        new LibraryGUI(library);
    }
}
