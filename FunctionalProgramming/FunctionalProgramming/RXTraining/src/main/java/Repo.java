public class Repo {
    public Employee findById(int id) {
        if (id > 0 && id < 5)
            return new Employee(id);
        else
            throw new RuntimeException("No such emp");
    }
}
