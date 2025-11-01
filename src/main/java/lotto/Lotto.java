package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void duplicateLotto(int bonusNumber) {
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

}
