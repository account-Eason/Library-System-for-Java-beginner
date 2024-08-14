package com.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LibraryGUI {
    private Library library;
    private JFrame frame;
    private JTextField titleField;
    private JTextField isbnField;
    private JTextField authorField;
    private JTextField yearField;
    private JTextArea displayArea;

    public LibraryGUI(Library library) {
        this.library = library;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Title");
        titleLabel.setBounds(20, 20, 80, 25);
        frame.add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(100, 20, 165, 25);
        frame.add(titleField);

        JLabel authorLabel = new JLabel("Author");
        authorLabel.setBounds(20, 60, 80, 25);
        frame.add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(100, 60, 165, 25);
        frame.add(authorField);

        JLabel isbnLabel = new JLabel("ISBN");
        isbnLabel.setBounds(20, 100, 80, 25);
        frame.add(isbnLabel);

        isbnField = new JTextField();
        isbnField.setBounds(100, 100, 165, 25);
        frame.add(isbnField);

        JLabel yearLabel = new JLabel("Year");
        yearLabel.setBounds(20, 140, 80, 25);
        frame.add(yearLabel);

        yearField = new JTextField();
        yearField.setBounds(100, 140, 165, 25);
        frame.add(yearField);

        JButton addButton = new JButton("Add Book");
        addButton.setBounds(20, 180, 120, 25);
        frame.add(addButton);

        displayArea = new JTextArea();
        displayArea.setBounds(300, 20, 260, 300);
        frame.add(displayArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                String isbn = isbnField.getText();
                int year = Integer.parseInt(yearField.getText());

                Book book = new Book(title, author, isbn, year);
                library.addBook(book);
                displayBooks();
            }
        });
        frame.setVisible(true);
    }
    private void displayBooks() {
        displayArea.setText("");
        for (Book book : library.getAllBooks()) {
            displayArea.append(book.toString() + "\n");
        }
    }
}
