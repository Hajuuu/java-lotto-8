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
                throw new IllegalArgumentException("[ERROR] 0 이하의 숫자는 입력할 수 없습니다.");
            }
            if (amount > 100000) {
                throw new IllegalArgumentException("[ERROR] 100,000을 초과하여 구매할 수 없습니다.");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매 가능합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
