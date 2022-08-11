package Advanced.Advanced_Lab1_StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Scanner;
public class ADV_LAB05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while(!filename.equals("print")){

            if(filename.equals("cancel")){
                    if(printerQueue.isEmpty()){
                        System.out.println("Printer is on standby");

                    } else {
                        String firstInQueue = printerQueue.poll();
                        System.out.println("Canceled " + firstInQueue);
                    }
            } else {
                printerQueue.offer(filename);
            }

            filename = scanner.nextLine();
        }
        while(!printerQueue.isEmpty()){
            System.out.println(printerQueue.poll());
        }

    }
}
