package streams;

import common.superheros.SuperHero;

import java.util.List;
import java.util.stream.Collectors;

public class SuperSquad {

    private List<SuperHero> supersquad;

    public SuperSquad(List<SuperHero> supersquad) {
        this.supersquad = supersquad;
    }

    public List<SuperHero> filterSquadWithStrenthLessThan90() {
        return this.supersquad.stream().filter(squad -> squad.strengthLevel > 90).collect(Collectors.toList());
    }

    public List<SuperHero> filterSquadBySquadName() {
        return this.supersquad.stream().sorted((a,b)-> a.squadName.compareTo(b.squadName)).collect(Collectors.toList());
    }
}
