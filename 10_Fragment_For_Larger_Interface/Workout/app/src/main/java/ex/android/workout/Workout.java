package ex.android.workout;

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener", "5 Handstand push-ups\n10 1-legged squirts\n15 Pull-ups"),
            new Workout("Core Agony", "100 Pull-ups\n Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("Strength and Length", "500 meter run\n21 X 1.5 pood kettleball swing\n21 X pull-ups")
    };

    //  각 Workout은 이름과 설명을 포함
    private Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
