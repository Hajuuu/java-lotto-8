package lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OutputView {

    public static void printLotto(List<Lotto> lotto) {
        System.out.printf("%n%d개를 구매했습니다.%n", lotto.size());
        lotto.forEach(System.out::println);
    }

    public static void printWinningStatistics(LottoResult lottoResult, double profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .sorted(Comparator.comparingInt(Rank::getWinnings)) // 낮은 순부터 출력
                .forEach(rank -> {
                    System.out.printf(
                            "%d%s (%s원) - %d개%n", rank.getCount(), getRankMessage(rank),
                            String.format("%,d", rank.getWinnings()),
                            lottoResult.getCount(rank)
                    );
                });
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static String getRankMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return "개 일치, 보너스 볼 일치";
        }
        return "개 일치";
    }
}
