package lotto;

public enum ErrorMessages {

    INPUT_AMOUNT_IS_NEGATIVE("[ERROR] 0 이하의 숫자는 입력할 수 없습니다."),
    INPUT_AMOUNT_IS_OVER("[ERROR] 100,000을 초과하여 구매할 수 없습니다."),
    INPUT_AMOUNT_WRONG_UNITS("[ERROR] 로또는 1,000원 단위로 구매 가능합니다."),
    INPUT_AMOUNT_IS_NOT_NUMBER("[ERROR] 숫자만 입력 가능합니다.");

    private String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
