package lotto;

import static lotto.ErrorMessages.INPUT_AMOUNT_IS_NEGATIVE;
import static lotto.ErrorMessages.INPUT_AMOUNT_IS_NOT_NUMBER;
import static lotto.ErrorMessages.INPUT_AMOUNT_IS_OVER;
import static lotto.ErrorMessages.INPUT_AMOUNT_WRONG_UNITS;
import static lotto.ErrorMessages.INPUT_BONUS_NUMBER_DUPLICATE;
import static lotto.ErrorMessages.INPUT_BONUS_NUMBER_IS_NOT_NUMBER;
import static lotto.ErrorMessages.INPUT_LOTTO_IS_EMPTY;
import static lotto.ErrorMessages.INPUT_LOTTO_IS_NOT_NUMBER;
import static lotto.ErrorMessages.INPUT_LOTTO_NUMBER_DUPLICATE;
import static lotto.ErrorMessages.INPUT_WRONG_RANGE;
import static lotto.InputView.validateAmount;
import static lotto.InputView.validateBonusNumber;
import static lotto.InputView.validateLotto;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    @DisplayName("구매 금액이 0보다 작은 경우 예외 발생")
    void 구매_금액이_0보다_작은_경우_예외_발생() {
        // given
        String purchase = "-10000";

        // when & then
        assertThatThrownBy(() -> validateAmount(purchase))
                .hasMessage(INPUT_AMOUNT_IS_NEGATIVE.getMessage());
    }

    @Test
    @DisplayName("100,000원 초과인 경우 예외 발생")
    void 구매_금액이_100000원_초과인_경우_예외_발생() {
        // given
        String purchase = "150000";

        // when & then
        assertThatThrownBy(() -> validateAmount(purchase))
                .hasMessage(INPUT_AMOUNT_IS_OVER.getMessage());
    }

    @Test
    @DisplayName("구매 금액이 1,000원 단위가 아닐 경우 예외 발생")
    void 구매_금액이_1000원_단위가_아닐_경우_예외_발생() {
        // given
        String purchase = "1200";

        // when & then
        assertThatThrownBy(() -> validateAmount(purchase))
                .hasMessage(INPUT_AMOUNT_WRONG_UNITS.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닐 경우 예외 발생")
    void 숫자가_아닐_경우_예외_발생() {
        // given
        String purchase = "abc";

        // when & then
        assertThatThrownBy(() -> validateAmount(purchase))
                .hasMessage(INPUT_AMOUNT_IS_NOT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("번호가 1~45 사이의 숫자가 아닐 경우 예외 발생")
    void 번호가_1에서_45_사이의_숫자가_아닐_경우_예외_발생() {
        // given
        String numbers = "0,1,2,3,4,5";

        // when & then
        assertThatThrownBy(() -> validateLotto(numbers))
                .hasMessage(INPUT_WRONG_RANGE.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력 시 예외 발생")
    void 숫자가_아닌_문자_입력_시_예외_발생() {
        // given
        String numbers = "a,1,2,3,4,5";

        // when & then
        assertThatThrownBy(() -> validateLotto(numbers))
                .hasMessage(INPUT_LOTTO_IS_NOT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또에 중복된 값 입력 시 예외 발생")
    void 로또에_중복된_값_입력_시_예외_발생() {
        // given
        String numbers = "1,2,3,4,4,5";

        // when & then
        assertThatThrownBy(() -> validateLotto(numbers))
                .hasMessage(INPUT_LOTTO_NUMBER_DUPLICATE.getMessage());
    }


    @Test
    @DisplayName("로또 번호에 숫자 없이 공백만 있는 경우 예외 발생")
    void 로또_번호에_숫자_없이_공백만_있는_경우_예외_발생() {
        // given
        String numbers = "1, 2, ,3,4,5,6";

        // when & then
        assertThatThrownBy(() -> validateLotto(numbers))
                .hasMessage(INPUT_LOTTO_IS_EMPTY.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    void 보너스_번호가_당첨_번호와_중복될_경우_예외_발생() {
        // given
        String number = "6";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> validateBonusNumber(lotto, number))
                .hasMessage(INPUT_BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 값이 입력될 경우 예외 발생")
    void 숫자가_아닌_값이_입력될_경우_예외_발생() {
        // given
        String number = "six";
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when & then
        assertThatThrownBy(() -> validateBonusNumber(lotto, number))
                .hasMessage(INPUT_BONUS_NUMBER_IS_NOT_NUMBER.getMessage());
    }
}