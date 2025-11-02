package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(2_000_000_000, false, 6),
    SECOND(30_000_000, true, 5),
    THIRD(1_500_000, false, 5),
    FOURTH(50_000, false, 4),
    FIFTH(5_000, false, 3),
    NONE(0, false, 0);

    private int winnings;
    private boolean bonus;
    private int count;

    Rank(int winnings, boolean bonus, int count) {
        this.winnings = winnings;
        this.bonus = bonus;
        this.count = count;
    }

    public static Rank findRank(int count, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.count == count)
                .filter(rank -> rank.bonus == bonus)
                .findFirst()
                .orElse(NONE);
    }

    public int getWinnings() {
        return winnings;
    }

    public int getCount() {
        return count;
    }
}
