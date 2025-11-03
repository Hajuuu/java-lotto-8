package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> issuanceLotto(int amount) {
        int number = buyLotto(amount);
        return IntStream.range(0, number)
                .mapToObj(num -> new Lotto(pickLottoNumbers()))
                .collect(Collectors.toList());
    }

    private int buyLotto(int amount) {
        return amount / LOTTO_PRICE;
    }

    private List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }

}
