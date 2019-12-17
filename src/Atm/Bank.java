package Atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Bank {


    private boolean validateUser;
    private String card_num;
    private String card_pin;


    /* Getters */
    public void setValidateUser(boolean validateUser) {
        this.validateUser = validateUser;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public void setCard_pin(String card_pin) {
        this.card_pin = card_pin;
    }

    public boolean isValidateUser() {
        return validateUser;
    }

    /* Setters */
    public String getCard_num() {
        return card_num;
    }

    public String getCard_pin() {
        return card_pin;
    }


    /* Constructor */
    public Bank(String card_num, String card_pin) {

        this.card_num = card_num;
        this.card_pin = card_pin;
    }


    //Each method will be connecting the the DB to verifiy the card  and get user account info

    /* Inserting data to DB this method is just for easy data entry!
    be wrap in a group comment for when the application is running */
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
    }

}
