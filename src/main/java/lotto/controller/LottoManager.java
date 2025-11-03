package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {

    private final LottoMachine lottoMachine = new LottoMachine();

    private final LottoResult lottoResult = new LottoResult();

    public void run() {
        int amount = InputView.inputAmount();
        List<Lotto> lotto = lottoMachine.issuanceLotto(amount);
        OutputView.printLotto(lotto);

        Lotto winningLotto = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningLotto);

        lottoResult.confirmWinnings(lotto, winningLotto, bonusNumber);

        double rate = LottoStatistics.calculateProfitRate(lottoResult, amount);
        OutputView.printWinningStatistics(lottoResult, rate);
    }
}
