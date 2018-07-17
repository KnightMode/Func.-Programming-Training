package immutability;

import common.superheros.SuperHero;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperHeroSpec {

    /**
     * ONLY IMMUTABLE OBJECTS
     */

    /*
        Model a super hero with the following attributes
        1. Name
        2. Strength Level
     */
    // Outcome - Simple object creation with 2 params
    @Test
    public void ableToCreateSuperHeroWithReqObjects() {
        //SuperHero superHero = new SuperHero("Iron Man",1000);
        //assertThat(superHero.toString()).isEqualTo("Iron Man1000");
    }

    @Test
    public void createSuperHeroWithNumberOfProperties() {
        //SuperHero superHero = new SuperHero("Hulk",200,"Bruce Banner", Lists.newArrayList("Nick Fury", "avbc"),true);
        SuperHero superHero = new SuperHero.Builder()
                .name("Hulk")
                .strength(200)
                .addAssociates("Nick Fury")
                .realName("Bruce")
                .build();

        assertThat(superHero.toString()).isEqualTo("Hulk200");
    }

    /*
        Make the super hero fight with another one. This leads to

        1. Win - If the strength is more than the opponent
        2. Lose - If the strength is less
        3. Draw - when the strengths are the same.
     */
    // Outcome - a comparison on win/ loss/ draw
    @Test
    public void spidermanWinsAgainstThor() {
        SuperHero hulk = new SuperHero.Builder()
                .name("Hulk")
                .strength(200)
                .fromEarth(true)
                .addAssociates("Nick Fury")
                .realName("Bruce")
                .build();

        SuperHero spiderman = new SuperHero.Builder()
                .name("Spiderman")
                .strength(300)
                .fromEarth(true)
                .addAssociates("acb")
                .realName("Peter")
                .build();

        assertThat(hulk.compareTo(spiderman)).isPositive();
    }
    /*
        As an after math of the fight, if the super

        1. Wins - His strength increased by 2
        2. Draws - His strength increases by 1
        3. Loss - His strength remains the same.
     */
    // New object of Super hero with the increased power level

    /*
        Get the fight history of the hero which displays
        1. With whom the fight was
        2. What was the result
        3. What was the change in Strength level ( like increased from 2 to 4
     */
    // Store of all the history of the super hero which is nothing but the result from each fight
}
