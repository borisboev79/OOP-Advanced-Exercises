package Advanced.Advanced_Exam_June.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if(this.exercises.size() < this.exerciseCount) {
            exercises.add(exercise);
        }
    }

    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream().filter(c -> c.getName().equals(name) && c.getMuscle().equals(muscle))
                .findFirst().orElse(null);
    }

    public boolean removeExercise(String name, String muscle) {
        return this.exercises.remove(this.exercises.stream().filter(m -> m.getName()
                .equals(name) && m.getMuscle().equals(muscle)).findFirst().orElse(null));
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return this.exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public String getStatistics() {

        return "Workout type: " + this.type + System.lineSeparator() +
             this.exercises.stream().map(Exercise::toString).collect(Collectors.joining(System.lineSeparator()));
    }


}
