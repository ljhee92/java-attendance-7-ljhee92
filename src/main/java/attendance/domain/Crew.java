package attendance.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Crew crew = (Crew) o;
        return Objects.equals(name, crew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
