package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

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
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
