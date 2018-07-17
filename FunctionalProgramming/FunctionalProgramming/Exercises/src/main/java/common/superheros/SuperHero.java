package common.superheros;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
public class SuperHero implements Comparable<SuperHero> {

    private final String name;
    public final int strengthLevel;
    public final String squadName;

    public SuperHero(String name, int strengthLevel, String squadName) {
        this.name = name;
        this.strengthLevel = strengthLevel;
        this.squadName = squadName;
    }

    @Override
    public String toString() {
        return String.format(name + strengthLevel);
    }

    @Override
    public int compareTo(SuperHero o) {
        return o.strengthLevel - this.strengthLevel;
    }

    public static class Builder {
        private String name;
        private int strengthLevel;
        private String realName;
        private List<String> associates = new ArrayList<>();
        private Boolean fromEarth;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder strength(Integer strengthLevel) {
            this.strengthLevel = strengthLevel;
            return this;
        }

        public Builder realName(String realName) {
            this.realName = realName;
            return this;
        }

        public Builder addAssociates(String name) {
            this.associates.add(name);
            return this;
        }

        public Builder fromEarth(Boolean fromEarth) {
            this.fromEarth = fromEarth;
            return this;
        }

    }
}