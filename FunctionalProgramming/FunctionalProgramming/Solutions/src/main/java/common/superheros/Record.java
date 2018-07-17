package common.superheros;

public class Record {

    private final SuperHero heroBeforeFight;
    private final SuperHero opponentBeforeFight;

    private final SuperHero heroAfterFight;
    private final SuperHero opponentAfterFight;

    private Record(SuperHero heroBeforeFight, SuperHero opponentBeforeFight, SuperHero heroAfterFight, SuperHero opponentAfterFight) {
        this.heroBeforeFight = heroBeforeFight;
        this.opponentBeforeFight = opponentBeforeFight;
        this.heroAfterFight = heroAfterFight;
        this.opponentAfterFight = opponentAfterFight;
    }

    @Override
    public String toString() {
        return String.format("%s vs %s, %s : %d -> %d",
                this.heroBeforeFight.name(),
                this.opponentBeforeFight.name(),
                result(),
                this.heroBeforeFight.strength(),
                this.heroAfterFight.strength());
    }

    private String result() {
        switch (this.heroAfterFight.strength() - this.heroBeforeFight.strength() ) {
            case 0: return "Lost";
            case 1: return "Draw";
            default: return "Won";
        }
    }

    public Record invert() {
        return new Record(this.opponentBeforeFight, this.heroBeforeFight,
                this.opponentAfterFight, this.heroAfterFight);
    }

    public String heroName() {
        return this.heroBeforeFight.name();
    }


    public static class Builder {
        private SuperHero heroBeforeFight;
        private SuperHero opponentBeforeFight;

        private SuperHero heroAfterFight;
        private SuperHero opponentAfterFight;

        Builder init(SuperHero hero, SuperHero opponent){
            this.heroBeforeFight = hero;
            this.opponentBeforeFight = opponent;

            return this;
        }

        Record end(SuperHero hero, SuperHero opponent){
            this.heroAfterFight = hero;
            this.opponentAfterFight = opponent;
            return new Record(this.heroBeforeFight, opponentBeforeFight,
                    this.heroAfterFight, opponentAfterFight);
        }
    }

}