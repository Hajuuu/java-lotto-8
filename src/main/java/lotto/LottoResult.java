package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> results = new HashMap<>();

    public void confirmWinnings(List<Lotto> purchaseLotto, List<Integer> winningNumbers, int bonusNumber) {
        purchaseLotto.forEach(lotto -> {
            int matchCount = countMatchingNumbers(lotto, winningNumbers);
            boolean bonusMatch = lotto.contains(bonusNumber);
            Rank rank = Rank.findRank(matchCount, bonusMatch);

            results.put(rank, results.getOrDefault(rank, 0) + 1);
        });
    }

    private int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public int getCount(Rank rank) {
        return results.getOrDefault(rank, 0);
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }


}
