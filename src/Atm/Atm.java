package Atm;

public class Atm extends Bank {

    private boolean validate;

    /* constructor */
    public Atm(String card_num, String card_pin) {
        super(card_num, card_pin);
    }

    public static void main (String [] args) {

        Bank bankTLC = new Bank("1002", "5263");

        bankTLC.insertDB();

    }


}
