package common.superheros;

import lombok.EqualsAndHashCode;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class SuperHero implements  Comparable<SuperHero> {

    private final String name;
    private final int strength;
    private final String realName;
    private final boolean fromEarth;
    private final List<String> associates;

    public SuperHero(String name, int strength) {
        this(name, strength, "", false, new ArrayList<>());
    }

    private SuperHero(String name, int strength, String realName, boolean fromEarth, List<String> associates) {
        this.name = name;
        this.strength = strength;
        this.realName = realName;
        this.fromEarth = fromEarth;
        this.associates = associates;
    }


    @Override
    public String toString() {
        return String.format("%s#%d", name, strength);
    }

    @Override
    public int compareTo(SuperHero opponent) {
        return this.strength - opponent.strength ;
    }

    public Pair<SuperHero, SuperHero> fightAgainst(SuperHero opponent) {
        if (this.compareTo(opponent) > 0) {
            return new Pair<>(new SuperHero.Builder()
                                            .from(this)
                                            .increaseStrength(2)
                                            .build(),
                                new SuperHero.Builder()
                                            .from(opponent)
                                            .build() );
        }

        if(this.compareTo(opponent) == 0){
            return new Pair<>(new SuperHero.Builder()
                    .from(this)
                    .increaseStrength(1)
                    .build(),
                    new SuperHero.Builder()
                            .from(opponent)
                            .increaseStrength(1)
                            .build() );
        }

        return new Pair<>(new SuperHero.Builder()
                .from(this)
                .build(),
                new SuperHero.Builder()
                        .from(opponent)
                        .increaseStrength(2)
                        .build() );

    }

    public Pair<SuperHero, SuperHero> fightAgainst(SuperHero opponent, RecordKeeper recordKeeper) {

        recordKeeper.startRecording(new Pair<SuperHero, SuperHero>(this, opponent));
        Pair<SuperHero, SuperHero> fightResult = this.fightAgainst(opponent);
        recordKeeper.stopRecording(fightResult);
        return fightResult;
    }

    public String name() {
        return name;
    }

    public int strength() {
        return strength;
    }

    public static class Builder {

        private String name;
        private int strength;
        private String realName;
        private boolean fromEarth;
        private List<String> associates = new ArrayList<>();

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder strength(int level) {
            this.strength = level;
            return this;
        }

        public Builder realName(String realName) {
            this.realName = realName;
            return this;
        }

        public Builder fromEarth(boolean isFromEarth) {
            this.fromEarth = isFromEarth;
            return this;
        }

        public Builder addAssociates(String associate) {
            this.associates.add(associate);
            return this;
        }

        public Builder from(SuperHero superHero) {
            this.name = superHero.name;
            this.strength = superHero.strength;
            this.realName = superHero.realName;
            this.associates = superHero.associates;
            this.fromEarth = superHero.fromEarth;

            return this;
        }

        public Builder increaseStrength(int by) {
            this.strength+=by;
            return this;
        }

        public SuperHero build() {
            return new SuperHero(this.name,
                    this.strength,
                    this.realName,
                    this.fromEarth,
                    this.associates);
        }

    }
}
