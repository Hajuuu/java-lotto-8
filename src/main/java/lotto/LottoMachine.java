package lotto;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public int buyTickets(int amount) {
        return amount / LOTTO_PRICE;
    }

    
}
