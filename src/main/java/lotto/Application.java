package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount = InputView.inputAmount();
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lotto = lottoMachine.issuanceLotto(amount);
        OutputView.printLotto(lotto);
        List<Integer> numbers = InputView.inputWinningNumbers();
        int number = InputView.inputBonusNumber(numbers);
        LottoResult lottoResult = new LottoResult();
        lottoResult.confirmWinnings(lotto, numbers, number);
        double rate = LottoStatistics.calculateProfitRate(lottoResult, amount);
        OutputView.printWinningStatistics(lottoResult, rate);
    }
}
