package lambdas;

import common.superheros.SuperHero;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SuperHeroSorter {

    /** Intermediate solution 1 **/

//    public List<SuperHero> sort(List<SuperHero> superHeroes) {
//        superHeroes.sort(new SuperHeroComparator());
//        return superHeroes;
//    }

//    public List<SuperHero> sort(List<SuperHero> superHeroes) {
//        return superHeroes.stream().sorted(new SuperHeroComparator()).collect(Collectors.toList());
//    }

//    public List<SuperHero> sort(List<SuperHero> superHeroes) {
//        return superHeroes.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
//    }
}

//class SuperHeroComparator implements Comparator<SuperHero> {
//
//    @Override
//    public int compare(SuperHero o1, SuperHero o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
//}
