package lotto;

import lotto.domain.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("로또 당첨 확인 테스트 - 1등")
    void 로또_당첨_확인_1등() {
        // given
        int count = 6;
        boolean bonus = false;

        // when
        Rank rank = Rank.findRank(count, bonus);

        // then
        Assertions.assertThat(rank.getWinnings()).isEqualTo(Rank.FIRST.getWinnings());
    }

    @Test
    @DisplayName("로또 당첨 확인 테스트 - 2등")
    void 로또_당첨_확인_2등() {
        // given
        int count = 5;
        boolean bonus = true;

        // when
        Rank rank = Rank.findRank(count, bonus);

        // then
        Assertions.assertThat(rank.getWinnings()).isEqualTo(Rank.SECOND.getWinnings());
    }

    @Test
    @DisplayName("로또 당첨 확인 테스트 - 3등")
    void 로또_당첨_확인_3등() {
        // given
        int count = 5;
        boolean bonus = false;

        // when
        Rank rank = Rank.findRank(count, bonus);

        // then
        Assertions.assertThat(rank.getWinnings()).isEqualTo(Rank.THIRD.getWinnings());
    }

    @Test
    @DisplayName("로또 당첨 확인 테스트 - 4등")
    void 로또_당첨_확인_4등() {
        // given
        int count = 4;
        boolean bonus = false;

        // when
        Rank rank = Rank.findRank(count, bonus);

        // then
        Assertions.assertThat(rank.getWinnings()).isEqualTo(Rank.FOURTH.getWinnings());
    }

    @Test
    @DisplayName("로또 당첨 확인 테스트 - 5등")
    void 로또_당첨_확인_5등() {
        // given
        int count = 3;
        boolean bonus = false;

        // when
        Rank rank = Rank.findRank(count, bonus);

        // then
        Assertions.assertThat(rank.getWinnings()).isEqualTo(Rank.FIFTH.getWinnings());
    }

    @Test
    @DisplayName("로또 당첨 확인 테스트 - 미당첨")
    void 로또_당첨_확인_미당첨() {
        // given
        int count = 4;
        boolean bonus = true;

        // when
        Rank rank = Rank.findRank(count, bonus);

        // then
        Assertions.assertThat(rank.getWinnings()).isEqualTo(Rank.NONE.getWinnings());
    }
}