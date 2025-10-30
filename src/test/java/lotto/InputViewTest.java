package lotto;

import static lotto.ErrorMessages.INPUT_AMOUNT_IS_NEGATIVE;
import static lotto.ErrorMessages.INPUT_AMOUNT_IS_NOT_NUMBER;
import static lotto.ErrorMessages.INPUT_AMOUNT_IS_OVER;
import static lotto.ErrorMessages.INPUT_AMOUNT_WRONG_UNITS;
import static lotto.InputView.validateAmount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    
    @Test
    @DisplayName("구매 금액이 0보다 작은 경우 예외 발생")
    void 구매_금액이_0보다_작은_경우_예외_발생() {
        // given
        String purchase = "-10000";

        // when & then
        Assertions.assertThatThrownBy(() -> validateAmount(purchase))
                .hasMessage(INPUT_AMOUNT_IS_NEGATIVE.getMessage());
    }

    @Test
    @DisplayName("100,000원 초과인 경우 예외 발생")
    void 구매_금액이_100000원_초과인_경우_예외_발생() {
        // given
        String purchase = "150000";

        // when & then
        Assertions.assertThatThrownBy(() -> validateAmount(purchase))
                .hasMessage(INPUT_AMOUNT_IS_OVER.getMessage());
    }

    @Test
    @DisplayName("구매 금액이 1,000원 단위가 아닐 경우 예외 발생")
    void 구매_금액이_1000원_단위가_아닐_경우_예외_발생() {
        // given
        String purchase = "1200";

        // when & then
        Assertions.assertThatThrownBy(() -> validateAmount(purchase))
                .hasMessage(INPUT_AMOUNT_WRONG_UNITS.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닐 경우 예외 발생")
    void inputAmount() {
        // given
        String purchase = "abc";

        // when & then
        Assertions.assertThatThrownBy(() -> validateAmount(purchase))
                .hasMessage(INPUT_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

}