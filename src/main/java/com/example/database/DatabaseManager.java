package com.example.database;
import com.example.Book;

import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        try {
            //connect to database
            connection = DriverManager.getConnection("jdbc:sqlite:library.db");
            String createTableSQL = "CREATE TABLE IF NOT EXISTS BOOKS ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "title TEXT NOT NULL,"
                    + "author TEXT NOT NULL,"
                    + "isbn TEXT NOT NULL,"
                    + "year INTEGER NOT NULL,";
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSQL);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addBookToDatabase(Book book) {
        try {
            String insertSQL = "INSERT INTO books(title, author, isbn, year) VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(insertSQL);
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getIsbn());
            pstmt.setInt(4, book.getYear());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
