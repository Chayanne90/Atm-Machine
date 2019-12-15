package Atm;

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


    /*Each method will be connecting the the DB to verifiy the card  and get user account info*/
}
