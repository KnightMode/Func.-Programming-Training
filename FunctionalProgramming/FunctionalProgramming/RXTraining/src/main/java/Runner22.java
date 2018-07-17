import java.util.ArrayList;
import java.util.stream.Stream;

public class Runner22 {
    public static void main(String[] args) {
        Repo repo = new Repo();
        Stream.of(1, 2, 3, 4, 5)
                .collect(ArrayList::new, (acc, id) -> {
                    Employee e = repo.findById(id);
                    acc.add(e);
                }, ArrayList::addAll);
    }
}
