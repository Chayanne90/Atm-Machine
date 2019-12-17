package Atm;

public class Atm extends Bank {

    private boolean validate;

    /* constructor */
    public Atm(String card_num, String card_pin) {
        super(card_num, card_pin);
    }


    public static void main (String [] args) {

        Bank bankTLC = new Bank("3001", "5263");

        final Boolean cardnumisthere = bankTLC.validateCard(bankTLC.getCard_num());

        System.out.print("teh card number exists? " + cardnumisthere);

    }


}
