package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    @DisplayName("로또 결과 확인 테스트")
    void 로또_결과_확인_테스트() {
        // given
        LottoResult lottoResult = new LottoResult();
        List<Lotto> purchaseLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),   // 6개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),  // 5개 + 보너스 일치
                new Lotto(List.of(1, 2, 3, 7, 8, 9))    // 3개 일치
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 10;

        // when
        lottoResult.confirmWinnings(purchaseLotto, winningNumbers, bonusNumber);

        // then
        Map<Rank, Integer> results = lottoResult.getResults();
        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);


    }
}