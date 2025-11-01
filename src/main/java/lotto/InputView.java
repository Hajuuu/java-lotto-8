package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static List<Integer> inputWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = readLine();
            try {
                return validateLotto(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static List<Integer> validateLotto(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputView::validateParseInt)
                .toList();

        validateDuplicate(numbers);
        return numbers;
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

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    public static int inputBonusNumber(Lotto lotto) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = readLine();
            try {
                return validateBonusNumber(lotto, input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validateBonusNumber(Lotto lotto, String number) {
        try {
            int bonusNumber = Integer.parseInt(number);
            lotto.duplicateLotto(bonusNumber);
            validateRange(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_IS_NOT_NUMBER.getMessage());
        }
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_WRONG_RANGE.getMessage());
        }
    }
}
