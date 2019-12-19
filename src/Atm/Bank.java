package Atm;

import java.sql.*;

public class Bank {

    private String customerName;
    private String card_num;
    private String card_pin;

    // Setters
    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public void setCard_pin(String card_pin) {
        this.card_pin = card_pin;
    }

    public void  setCustomername(String customerName){
        this.customerName = customerName;
    }

    // Getters
    public String getCard_num() {
        return card_num;
    }

    public String getCard_pin() {
        return card_pin;
    }

    public String getCustomername(){
        return customerName;
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


    /* The ValCardandPin method check if the card number and pin enter by customer exists in the database */
    public final Boolean valCardandPin(String card_num, String card_pin) {

        Boolean validate = null;
        String sql = "SELECT count(a.card_number)  card_number,\n" +
                "count(b.card_pin) as card_pin\n" +
                "FROM  Customer a\n" +
                "LEFT  JOIN Customer b\n" +
                "on a.customer_id = b.customer_id\n" +
                "where a.card_number = ? and b.card_pin = ?";

        try (Connection conn = this.connection();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            /* Set the value */
            pstmt.setString(1, card_num);
            pstmt.setString(2,card_pin);
            ResultSet rs  = pstmt.executeQuery();

            /* getBoolean return true if the value from the query is 1 and 0 if the value is 0 */
            boolean valcard= rs.getBoolean("card_number");
            boolean valpin =rs.getBoolean("card_pin");


            if (valcard && valpin){ validate = true;}
            conn.close();

        } catch(Exception e ) {

            System.err.println(e.getMessage());
        }

        return validate;
    }

}
