package Advanced.Advanced_ExamPreparation_Exercises.StacksAndQueues;
import java.util.*;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(tasksStack::push);

        ArrayDeque<Integer> threadsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        int targetTask = Integer.parseInt(scanner.nextLine());

        int task = 0;
        int thread = 0;


        while (task != targetTask ) {

            task = tasksStack.pop();
            thread = threadsQueue.poll();

            if(task > thread) {
                tasksStack.push(task);
            }

        }
        threadsQueue.push(thread);
        System.out.printf("Thread with value %d killed task %d%n", thread, task);
        System.out.println(threadsQueue.stream().map(String::valueOf).collect(Collectors.joining(" ")));


    }
}
