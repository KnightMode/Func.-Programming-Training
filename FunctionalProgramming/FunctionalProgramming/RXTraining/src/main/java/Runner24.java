import java.util.Optional;

//without Null
public class Runner24 {
    public static class Events {
        private int id;
        private Optional<String> type;

        public Events(int id, String type) {
            this.id = id;
            this.type = Optional.ofNullable(type);
        }

        public int getId() {
            return id;
        }

        public Optional<String> getType() {
            return type;
        }

        public String toString() {
            return "Object created %d" + id;
        }
    }

    class EventService {
        private final Repo repo;

        EventService(Repo repo) {
            this.repo = repo;
        }

        public String findById(Integer id) {
            return repo.findById(id).flatMap(Events::getType).orElse("Error");
        }
    }

    static class Repo {
        public Optional<Events> findById(Integer id) {
            if (id > 0)
                return Optional.of(new Events(id, "Holiday"));
            else
                return Optional.empty();
        }
    }

    //

    public static void main(String[] args) {
        Repo repo = new Repo();
        System.out.println(repo.findById(-1).orElse(new Events(3,"")));
        System.out.println(repo.findById(5));
    }
}
