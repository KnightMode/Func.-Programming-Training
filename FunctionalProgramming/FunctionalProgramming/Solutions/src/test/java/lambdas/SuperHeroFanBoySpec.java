package lambdas;

import common.superheros.SuperHero;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class SuperHeroFanBoySpec {

    private List<SuperHero> employees;

    @Before
    public void setUp() {
        // Add your favourites ;)
        SuperHero banner = new SuperHero("Banner", 93);
        SuperHero wayne = new SuperHero("Wayne", 90);
        SuperHero rogers = new SuperHero("Rogers", 91);
        SuperHero stark = new SuperHero("Stark", 89);
        SuperHero diana = new SuperHero("Diana", 92);
        SuperHero kent = new SuperHero("Kent", 99);
        SuperHero parker = new SuperHero("Parker", 81);
        SuperHero challa = new SuperHero("Challa", 87);
        SuperHero thor = new SuperHero("Thor", 89);
        SuperHero curry = new SuperHero("Curry", 85);
        employees = Arrays.asList(new SuperHero[]{banner, wayne, rogers, stark, diana, kent, parker, challa, thor, curry});
    }

    // 1. Use comparator to sort the super heroes by name
    @Test
    public void shouldSortSuperHeroesByName() {
        //assertThat(new SuperHeroSorter().sort(employees).toString()).isEqualTo("[Banner, Challa, Curry, Diana, Kent, Parker, Rogers, Stark, Thor, Wayne]");
    }

    // 2. Sort them in descending order by their strength
    // 3. Sort them in ascending order by their strength
    // 4. Create your own superhero with random strength above 70 and below 85

}
