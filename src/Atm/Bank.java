package Atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bank {


    private String card_num;
    private String card_pin;

    // Getters
    public String getCard_num() {
        return card_num;
    }

    public String getCard_pin() {
        return card_pin;
    }

    // Setters
    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public void setCard_pin(String card_pin) {
        this.card_pin = card_pin;
    }

    /* Constructor */
    public Bank(String card_num, String card_pin) {

        this.card_num = card_num;
        this.card_pin = card_pin;
    }

    // DB connection method This method will return connecting object.
    private Connection connection() {

        String url = "jdbc:sqlite:Bank_DB.db";
        Connection conn = null;

        try {

            conn = DriverManager.getConnection(url);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return conn;
    }


    //Each method will be connecting the the DB to verifiy the card and user account info

    /* Inserting data to DB this method is just for easy data entry!
    be wrap in a group comment for when the application is running
    public void insertDB() {

        Connection conn = null;
        Statement stmt = null;
        String url = "jdbc:sqlite:Bank_DB.db";

        try {

            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            conn.setAutoCommit(false);

            System.out.println("Database connection successfully");

            String sql = "INSERT INTO Customer (customer_name,  customer_dob, card_number, card_pin)\n" +
                    "VALUES ('Angel vargas' , '02/03/1980', 1001, 2536)";

            stmt.execute(sql);
            stmt.close();
            conn.commit();
            conn.close();

        } catch (Exception e ) {

            System.err.println(e.getMessage());
        }

        System.out.println("Records created successfully");
    }*/


    public static Boolean validateInfo(String card_num, String card_pin) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;
        Boolean validate = null;

        String url = "jdbc:sqlite:Bank_DB.db";

        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            conn.setAutoCommit(false);

            String valCardquery = "SELECT COUNT(card_number)\n" +
                    "FROM Customer\n" +
                    "WHERE card_number = ?;";

            String valPinquery = "SELECT COUNT(card_pin)\n" +
                    "FROM Customer\n" +
                    "WHERE card_number = ?;";

            Boolean valCard = stmt.execute(valCardquery);
            Boolean valPin = stmt.execute(valPinquery);

            stmt.execute(valCardquery);
            stmt.execute(valPinquery);

            if (valCard && valPin) {

                validate = true;
                stmt.close();
                conn.commit();
                conn.close();

            } else {
                System.out.println("Your Card number or Pin number are incorrect.");
                System.out.println("Please try again!");
            }

        } catch(Exception e ) {

            System.err.println(e.getMessage());
        }

        return validate;
    }

}
