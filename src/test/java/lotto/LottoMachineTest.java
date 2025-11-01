package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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
        int tickets = lottoMachine.buyTickets(amount);

        // then
        assertThat(tickets).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 번호 발행 테스트")
    void 로또_번호_발행_테스트() {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        // when
        List<Integer> numbers = lottoMachine.pickLottoNumbers();

        // then
        assertThat(numbers.size()).isEqualTo(6);
    }
}