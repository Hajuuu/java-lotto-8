package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.util.ErrorMessages;

public class InputView {

    public static int inputAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = readLine();
            try {
                return validateAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validateAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0) {
                throw new IllegalArgumentException(ErrorMessages.INPUT_AMOUNT_IS_NEGATIVE.getMessage());
            }
            if (amount > 100000) {
                throw new IllegalArgumentException(ErrorMessages.INPUT_AMOUNT_IS_OVER.getMessage());
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessages.INPUT_AMOUNT_WRONG_UNITS.getMessage());
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_AMOUNT_IS_NOT_NUMBER.getMessage());
        }
    }

    public static Lotto inputWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String input = readLine();
            try {
                return validateLotto(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static Lotto validateLotto(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputView::validateParseInt)
                .toList();

        return new Lotto(numbers);
    }

    private static int validateParseInt(String number) {
        if (number == null || number.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_LOTTO_IS_EMPTY.getMessage());
        }
        try {
            int lottoNumber = Integer.parseInt(number);
            validateRange(lottoNumber);
            return lottoNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_LOTTO_IS_NOT_NUMBER.getMessage());
        }
    }


    public static int inputBonusNumber(Lotto winningLotto) {
        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String input = readLine();
            try {
                return validateBonusNumber(winningLotto, input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validateBonusNumber(Lotto winningLotto, String number) {
        try {
            int bonusNumber = Integer.parseInt(number.trim());
            duplicateLotto(winningLotto, bonusNumber);
            validateRange(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_IS_NOT_NUMBER.getMessage());
        }
    }


    public static void duplicateLotto(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_WRONG_RANGE.getMessage());
        }
    }
}
