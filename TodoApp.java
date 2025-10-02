import java.util.*;
class TodoListException extends Exception{

    TodoListException(String message) {
        super(message);
    }
}
public class TodoApp {
    private static final ArrayList<String> tasks = new ArrayList<>();  
    void markdone(int number)
    {
       String Text=tasks.get(number);
       Text= Text+". "+"[✔]";
       tasks.set(number,Text);
    }
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TodoApp Task =new TodoApp();
        String choice;
        do {
            System.out.println("\n1. Add  2. Remove  3. Edit  4. Mark Done  5. View  6. Exit");
            System.out.print("Choose: ");
            choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1"-> {
                        System.out.print("Enter task: ");
                        String work=sc.nextLine();
                        boolean exists = false;
                        for (String task : tasks) {
                            if (task.equalsIgnoreCase(work)) { 
                                exists = true;
                                break;
                            }
                        }
                    
                        if (exists) {
                            System.out.println("Already present in To-Do List.");
                        } else {
                            tasks.add(work);
                        }
                    }
                    case "2" -> {
                        System.out.print("Task number to remove: ");
                        tasks.remove(Integer.parseInt(sc.nextLine()) - 1);
                    }
                    case "3" -> {
                        System.out.print("Task number to edit: ");
                        int idx = Integer.parseInt(sc.nextLine()) - 1;
                        System.out.print("New Description:-");
                        String text=sc.nextLine();
                        tasks.set(idx,text);
                    }
                    case "4" -> {
                        System.out.print("Task number to mark done: ");
                        Task.markdone((Integer.parseInt(sc.nextLine()) - 1));
                    }
                    case "5" -> {
                        System.out.println("To-Do List:");
                        for(int i=0;i<tasks.size();i++)
                        {
                            System.out.println("\t"+(i+1)+"-"+tasks.get(i));
                        }
                    }
                    case "6" -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> {
                        throw new TodoListException("Invalid Choice!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }while(true);
    }
}