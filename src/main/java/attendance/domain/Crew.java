package attendance.domain;

public class Crew {
    private final String name;

    private Crew(String name) {
        this.name = name;
    }

    public static Crew of(String name) {
        return new Crew(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "name='" + name + '\'' +
                '}';
    }
}
