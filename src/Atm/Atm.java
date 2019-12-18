package Atm;

public class Atm extends Bank {

    /* Constructor */
    public Atm(String card_num, String card_pin) {
        super(card_num, card_pin);
    }

    public static void main (String [] args) {

        Bank bankTLC = new Bank("1001", "1234");

        final boolean validate = bankTLC.validateInfo(bankTLC.getCard_num(), bankTLC.getCard_pin());

        if (validate) {
            System.out.print("Your card Information exists in our Database!");
        }

    }

}
