package attendance.domain;

import attendance.util.FileParser;

import java.util.List;

public class Crews {
    private final List<Crew> crews;

    private Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public static Crews initCrews() {
        return new Crews(FileParser.initCrews());
    }

    @Override
    public String toString() {
        return "Crews{" +
                "crews=" + crews +
                '}';
    }
}
