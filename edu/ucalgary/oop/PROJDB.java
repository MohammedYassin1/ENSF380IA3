package edu.ucalgary.oop;

import java.sql.*;

public class PROJDB {
    private Connection dbConnection;
    private ResultSet rs;

    public void createConnection() {
        try {
            dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertInquirer(Inquirer inquirer) {
        String firstName = inquirer.getFirstName();
        String lastName = inquirer.getLastName();
        String phoneNumber = inquirer.getServicesPhoneNum();
        int id = -1;
    
        try {
            String sql = "INSERT INTO INQUIRER (firstName, lastName, phoneNumber) VALUES (?,?,?) RETURNING id";
            PreparedStatement pstmt = dbConnection.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phoneNumber);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        inquirer.setId(id);
    }

    public void insertInquiryLog(LogInquirer logInquirer) {
        String sql = "INSERT INTO INQUIRY_LOG (inquirer, callDate, details) VALUES (?,?,?)";
        if (logInquirer.getInquirer().getId() == -1) {
            insertInquirer(logInquirer.getInquirer());
        }
        int inquirer = logInquirer.getInquirer().getId();
        for (ReliefService reliefService : logInquirer.getLog()) {
            if (reliefService.getLogged() == false) {
                String callDate = reliefService.getDateOfInquiry();
                String details = reliefService.getInfoProvided();
                reliefService.setLogged(true);
                try{
                    PreparedStatement pstmt = dbConnection.prepareStatement(sql);
                    pstmt.setInt(1, inquirer);
                    pstmt.setDate(2, callDate);
                    pstmt.setString(3, details);
                    pstmt.executeUpdate();
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
        }
        
    }

    public void readInquirers() {
        String sql = "SELECT * FROM INQUIRER";

        try {
            Statement stmt = dbConnection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                                   rs.getString("firstName") + "\t" +
                                   rs.getString("lastName") + "\t" +
                                   rs.getString("phoneNumber"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readInquiryLog() {
        String sql = "SELECT * FROM INQUIRY_LOG";

        try{
            Statement stmt = dbConnection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                                   rs.getInt("inquirer") + "\t" +
                                   rs.getDate("callDate") + "\t" +
                                   rs.getString("details"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            rs.close();
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        PROJDB db = new PROJDB();

        // Establish a database connection
        db.createConnection();

        // Test the insertInquirer method
        db.insertInquirer("John", "Doe", "123-456-7890");

        // Test the insertInquiryLog method
        db.insertInquiryLog(1, java.sql.Date.valueOf("2022-12-01"), "Test details");

        // Test the readInquirers method
        db.readInquirers();

        // Test the readInquiryLog method
        db.readInquiryLog();
    }
}
