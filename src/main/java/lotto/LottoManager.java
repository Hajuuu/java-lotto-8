package lotto;

import java.util.List;

public class LottoManager {

    private final LottoMachine lottoMachine = new LottoMachine();

    private final LottoResult lottoResult = new LottoResult();

    public void run() {
        int amount = InputView.inputAmount();
        List<Lotto> lotto = lottoMachine.issuanceLotto(amount);
        OutputView.printLotto(lotto);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        lottoResult.confirmWinnings(lotto, winningNumbers, bonusNumber);

        double rate = LottoStatistics.calculateProfitRate(lottoResult, amount);
        OutputView.printWinningStatistics(lottoResult, rate);
    }
}
