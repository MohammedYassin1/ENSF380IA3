package edu.ucalgary.oop;

import java.sql.*;

public class PROJDB {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public PROJDB() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();