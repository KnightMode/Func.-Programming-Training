package streams;

import common.superheros.SuperHero;
import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperSquadSpec {
    private SuperSquad superSquad;

    @Before
    void setup() {

        // Add your favourites ;)
        SuperHero banner = new SuperHero("Banner", 93, "squad1");
        SuperHero wayne = new SuperHero("Wayne", 90, "squad2");
        SuperHero rogers = new SuperHero("Rogers", 91, "squad3");
        SuperHero stark = new SuperHero("Stark", 89, "squad1");
        SuperHero diana = new SuperHero("Diana", 92, "squad1");
        SuperHero kent = new SuperHero("Kent", 99, "squad3");
        SuperHero parker = new SuperHero("Parker", 81, "squad2");
        SuperHero challa = new SuperHero("Challa", 87, "squad2");
        SuperHero thor = new SuperHero("Thor", 89, "squad1");
        SuperHero curry = new SuperHero("Curry", 85, "squad1");
        superSquad = new SuperSquad(Arrays.asList(new SuperHero[]{banner, wayne, rogers, stark, diana, kent, parker, challa, thor, curry}));
    }

    @Test
    public void ableToCreadSquad() {

    }

    @Test
    public void filterSquadBySquadName() {
        assertThat(superSquad.filterSquadBySquadName()).
    }
    /** Use streams **/
    // 1. Filter those with strength greater than 90
    // 2. Filter those with strength less than 85
    // 3. Filter the heroes whose name starts with 'C'
    // 4. Add a squad property to the class and group the heroes by their squad
    // 5. Filter the strongest 3 from each squad
    // 6. Strongest from each squad
    // 7. Cummulative strength of each squad

}
