package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("로또 발행 테스트")
    void 로또_발행_테스트() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        int amount = 3000;

        // when
        List<Lotto> lotto = lottoMachine.issuanceLotto(amount);

        // then
        assertThat(lotto.size()).isEqualTo(3);
    }

}