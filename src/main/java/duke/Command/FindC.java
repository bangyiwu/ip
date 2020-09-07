package duke.Command;

import duke.Command.Command;
import duke.Storage;
import duke.task.Task;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

import java.io.IOException;
import java.util.ArrayList;

public class FindC extends Command {

    private final String input;

    public FindC(String input) {
        this.input = input;
    }

    @Override
    public String execute(Ui ui, TaskList todoList, Storage store) throws IOException {
        assert input.length() > 4 : "no keyword entered";

        String result = "";
        String keyword = input.substring(5);
        int findCount = 0;
        System.out.println("Here are the matching tasks in your list:");
        for (Task found: todoList.todoList) {
            if (found.description.contains(keyword)) {
                result += findCount + 1 + "." + found.toString() + "\n";
                findCount++;
            }
        }
        if (findCount == 0) {
            result += "No related tasks found";
        }
        return result;
    }
}
