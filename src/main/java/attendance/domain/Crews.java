package attendance.domain;

import attendance.util.ErrorMessage;
import attendance.util.FileParser;

import java.util.ArrayList;
import java.util.List;

public class Crews {
    private final List<Crew> crews;

    private Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public static Crews initCrews() {
        return new Crews(FileParser.initCrews());
    }

    public void checkContains(String name) {
        List<String> names = new ArrayList<>();
        for (Crew crew : crews) {
            String nameForCrew = crew.getName();
            names.add(nameForCrew);
        }
        if (!names.contains(name)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_NICKNAME_EXCEPTION.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Crews{" +
                "crews=" + crews +
                '}';
    }
}
