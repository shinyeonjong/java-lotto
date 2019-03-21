package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottosTest {
    private Lottos lottos;
    private List<Lotto> lotto = new ArrayList<>();

    @Before
    public void initLottos() {
        this.lotto.add(new Lotto(Arrays.asList(16, 26, 32, 35, 37, 39)));
        this.lotto.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
        this.lotto.add(new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)));
        this.lotto.add(new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)));
        this.lotto.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)));
        this.lotto.add(new Lotto(Arrays.asList(1, 8, 11, 32, 38, 45)));
    }

    @Test
    public void 로또_한장_두개_일치() {
        List<Lotto> lotto = new ArrayList<>();
        lotto.add(new Lotto(Arrays.asList(16, 26, 32, 35, 37, 39)));
        List<Integer> winningNumbers = Arrays.asList(16, 26, 36, 40, 44, 45);
        Lottos lottos = new Lottos(lotto, winningNumbers);
        assertThat(lottos.produceResults().get(2)).isNull();
    }

    @Test
    public void 로또_한장_세개_일치() {
        List<Lotto> lotto = new ArrayList<>();
        lotto.add(new Lotto(Arrays.asList(16, 26, 32, 35, 37, 39)));
        List<Integer> winningNumbers = Arrays.asList(16, 26, 35, 40, 44, 45);
        Lottos lottos = new Lottos(lotto, winningNumbers);
        assertThat(lottos.produceResults().get(3)).isEqualTo(1);
    }

    @Test
    public void 로또_여러장_두개_일치() {
        this.lottos = new Lottos(this.lotto, Arrays.asList(2, 13, 22, 32, 38, 45));
        assertThat(this.lottos.produceResults().get(2)).isNull();
    }


    @Test
    public void 로또_여러장_세개_일치() {
        this.lottos = new Lottos(this.lotto, Arrays.asList(1, 8, 11, 32, 38, 45));
        assertThat(this.lottos.produceResults().get(3)).isEqualTo(2);
    }

    @Test
    public void 로또_여러장_모두_일치() {
        this.lottos = new Lottos(this.lotto, Arrays.asList(1, 8, 11, 32, 38, 45));
        assertThat(this.lottos.produceResults().get(6)).isEqualTo(1);
    }
}