import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void printLine() {
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> todo = new ArrayList<Task>();
        System.out.println("What's new scooby doo?\n" + "How can I help you today?");
        while (sc.hasNext()) {
            String command = sc.next();
            switch (command) {
                case "bye":
                    printLine();
                    System.out.println("See you later alligator ");
                    printLine();
                    System.exit(0);
                    break;
                case "list":
                    printLine();
                    System.out.println("Here's what you got: ");
                    if (todo.size() == 0) {
                        System.out.println("You are free!!");
                    }
                    for (Task task :
                            todo) {
                        System.out.println(todo.indexOf(task) + 1 + ". " + task.toString());
                    }
                    printLine();
                    break;
                case "done":
                    printLine();
                    int taskID = sc.nextInt() - 1;
                    Task task = todo.get(taskID);
                    task.markAsDone();
                    System.out.println("Gratz, you finished this dawg :");
                    System.out.println(task.toString());
                    printLine();
                    break;
                case "todo":
                    printLine();
                    String name = sc.nextLine();
                    try {
                        if (name.isEmpty() || name == " ") {
                            throw new DukeException("no task indicated");
                        } else {
                            Todo td = new Todo(name);
                            todo.add(td);
                            System.out.println("Aight new task for you: \n" + td.toString());
                            System.out.println("Now you got " + todo.size() + " task(s) waiting man");
                        }} catch (DukeException e){
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                    }
                    printLine();
                    break;
                case "deadline":
                    printLine();
                    String fullDL = sc.nextLine();

                    try {
                        String DLname = fullDL.split("/by")[0];
                        String DLtime = fullDL.split("/by")[1];
                        Deadline dl = new Deadline(DLname, DLtime);
                        todo.add(dl);
                        System.out.println("Aight new task for you: \n" + dl.toString());
                        System.out.println("Now you got " + todo.size() + " task(s) waiting man");
                        } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("check you entered both a description and a deadline time");;
                        e.printStackTrace();
                    }
                    printLine();
                    break;
                case "event":
                    printLine();
                    String fullE = sc.nextLine();
                    try {
                        String EventName = fullE.split("/at")[0];
                        String EventTime = fullE.split("/at")[1];
                        Event e = new Event(EventName, EventTime);
                        todo.add(e);
                        System.out.println("Aight new task for you: \n" + e.toString());
                        System.out.println("Now you got " + todo.size() + " task(s) waiting man");
                        } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("check you entered both a description and an event time");
                        e.printStackTrace();
                    }
                    printLine();
                    break;
                case "delete":
                    printLine();
                    try {
                        int deleteID = sc.nextInt() - 1;
                        Task deleted = todo.get(deleteID);
                        todo.remove(deleteID);
                        System.out.println("Gotchu, I am removing \n" + deleted.toString());
                        System.out.println("Now you got " + todo.size() + " task(s) waiting man");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("the item you are trying to delete does not exist");
                        e.printStackTrace();
                    }
                    printLine();
                    break;
                default:
                    printLine();
                    System.out.println("sorry i don't get you");
                    printLine();
            }
        }
    }
}
