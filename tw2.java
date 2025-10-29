import java.util.*;

public class tw2 {
    static class Task {
        String priority;
        List<Integer> dependencies;

        public Task(int taskId, String priority, List<Integer> dependencies) {
            this.taskId = taskId;
            this.priority = priority;
            this.dependencies = dependencies;

        }

        public boolean isReadyToExeute(Set<Integer> completedTasks) {
            return completedTasks.containsAll(dependencies);

        }

    }

    private Deque<Task> deque;
    private Set<Integer> completedTests;

    public tw2() {
        deque = new LinkedList<>();
        completedTests = new HashSet<>();

    }

    public void addTask(Task task) {
        if (task.priority.equals("HIGH")) {
            deque.addFirst(task);

        } else {
            deque.addLast(task);
        }
    }

    public void processTasks(){
        while (!deque.isEmpty()) {
            Task task =deque.peek();
            if(task.isReadyToExeute(completedTests)){
                deque.poll();
                System.out.println("Exeuting Task for deque ID:"+ task.taskId);
                completedTests.add(task.taskId);

            }else{
                System.out.println("Task ID:"+task.taskId+"");
            }
            
        }
    }

    public static void main(String[] args) {
        tw2 scheduler = new tw2();
        Task task1 = new Task(1, "High", Arrays.asList());
        Task task2 = new Task(2, "Low", Arrays.asList(1));
        Task task3 = new Task(3, "High", Arrays.asList(1));  // depends on the task 1
        Task task4 = new Task(4, "Low", Arrays.asList(2));  // deoend on the task 2....
        Task task5 = new Task(5, "High", Arrays.asList(3));
        Task task6 = new Task(6, "Low", Arrays.asList(4));
        // add tasks to teh scheduler.........
        scheduler.addTask(task1);
        scheduler.addTask(task2);
        scheduler.addTask(task3);
        scheduler.addTask(task4);
        scheduler.addTask(task5);
        scheduler.addTask(task6);
    }
}

// Task task1=new Task(1,"High",Arrays.asList());
// Task task2=new Task(2,"Low",Arrays.asList(1));
// Task task3=new Task(3,"High",Arrays.asList(1));
// Task task4=new Task(4,"Low",Arrays.asList(2));