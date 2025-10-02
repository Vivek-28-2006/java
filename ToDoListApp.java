import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static final ArrayList<Task> tasks = new ArrayList<>();

    static class Task {
        StringBuffer description;
        boolean isDone;

        Task(String desc) {
            this.description = new StringBuffer(desc);
            this.isDone = false;
        }

        void markDone() {
            isDone = true;
        }

        void edit(String newDesc) {
            description = new StringBuffer(newDesc);
        }

        public String toString() {
            return (isDone ? "[✓] " : "[ ] ") + description;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add  2. Remove  3. Edit  4. Mark Done  5. View  6. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Enter task: ");
                        tasks.add(new Task(sc.nextLine()));
                    }
                    case "2" -> {
                        System.out.print("Task number to remove: ");
                        tasks.remove(Integer.parseInt(sc.nextLine()) - 1);
                    }
                    case "3" -> {
                        System.out.print("Task number to edit: ");
                        int idx = Integer.parseInt(sc.nextLine()) - 1;
                        System.out.print("New description: ");
                        tasks.get(idx).edit(sc.nextLine());
                    }
                    case "4" -> {
                        System.out.print("Task number to mark done: ");
                        tasks.get(Integer.parseInt(sc.nextLine()) - 1).markDone();
                    }
                    case "5" -> {
                        System.out.println("To-Do List:");
                        for (int i = 0; i < tasks.size(); i++)
                            System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    case "6" -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}