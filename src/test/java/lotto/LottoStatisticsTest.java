package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    @Test
    @DisplayName("수익률 계산 검증")
    void 수익률_계산_검증() {
        // given
        LottoResult lottoResult = new LottoResult();
        List<Lotto> purchaseLottos = List.of(
                new Lotto(List.of(1, 2, 3, 7, 8, 9)) // 3개 일치
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 10, 11, 12);
        int bonusNumber = 13;
        int amount = 8000;

        // when
        lottoResult.confirmWinnings(purchaseLottos, winningNumbers, bonusNumber);
        double profitRate = LottoStatistics.calculateProfitRate(lottoResult, amount);

        // then
        assertThat(profitRate).isEqualTo(62.5);
    }
}