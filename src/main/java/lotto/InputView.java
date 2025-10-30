package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

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
}
