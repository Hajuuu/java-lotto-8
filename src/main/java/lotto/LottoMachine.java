package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public int buyTickets(int amount) {
        return amount / LOTTO_PRICE;
    }

    public List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
