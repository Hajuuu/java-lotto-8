package lotto;

public enum ErrorMessages {

    INPUT_AMOUNT_IS_NEGATIVE("[ERROR] 0 이하의 숫자는 입력할 수 없습니다."),
    INPUT_AMOUNT_IS_OVER("[ERROR] 100,000을 초과하여 구매할 수 없습니다."),
    INPUT_AMOUNT_WRONG_UNITS("[ERROR] 로또는 1,000원 단위로 구매 가능합니다."),
    INPUT_AMOUNT_IS_NOT_NUMBER("[ERROR] 숫자만 입력 가능합니다."),

    INPUT_WRONG_RANGE("[ERROR] 번호는 1부터 45까지만 가능합니다."),
    INPUT_LOTTO_IS_NOT_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
    INPUT_LOTTO_IS_EMPTY("[ERROR] 비어 있거나 공백만 있는 입력이 포함되어 있습니다."),
    INPUT_LOTTO_NUMBER_DUPLICATE("[ERROR] 번호는 중복되지 않게 입력해야합니다."),

    INPUT_BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않게 입력해야합니다."),
    INPUT_BONUS_NUMBER_IS_NOT_NUMBER("[ERROR] 숫자만 입력 가능합니다.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
