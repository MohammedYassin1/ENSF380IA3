package edu.ucalgary.oop;

import java.sql.*;

public class PROJDB {
    private Connection dbConnection;

    public void createConnection() {
        try {
            dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertInquirer(String firstName, String lastName, String phoneNumber) {
        String sql = "INSERT INTO INQUIRER (firstName, lastName, phoneNumber) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = dbConnection.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phoneNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertInquiryLog(int inquirer, Date callDate, String details) {
        String sql = "INSERT INTO INQUIRY_LOG (inquirer, callDate, details) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = dbConnection.prepareStatement(sql)) {
            pstmt.setInt(1, inquirer);
            pstmt.setDate(2, callDate);
            pstmt.setString(3, details);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readInquirers() {
        String sql = "SELECT * FROM INQUIRER";

        try (Statement stmt = dbConnection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                                   rs.getString("firstName") + "\t" +
                                   rs.getString("lastName") + "\t" +
                                   rs.getString("phoneNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readInquiryLog() {
        String sql = "SELECT * FROM INQUIRY_LOG";

        try (Statement stmt = dbConnection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                                   rs.getInt("inquirer") + "\t" +
                                   rs.getDate("callDate") + "\t" +
                                   rs.getString("details"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}