package lotto;

import java.util.List;

public class OutputView {

    public static void printLotto(List<Lotto> lotto) {
        lotto.forEach(System.out::println);
    }
}
