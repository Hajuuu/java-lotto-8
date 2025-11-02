package lotto;

public class LottoStatistics {

    public static double calculateProfitRate(LottoResult result, int amount) {
        long totalWinnings = result.getResults().entrySet().stream()
                .mapToLong(e -> (long) e.getKey().getWinnings() * e.getValue())
                .sum();
        return (double) totalWinnings / amount * 100;
    }
}
