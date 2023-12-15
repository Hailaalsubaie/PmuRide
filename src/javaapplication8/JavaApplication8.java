/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication8;
import java.util.ArrayList;
import java.util.List;
class UserStory {
    private int id;
    private String title;
    private int storyPoints;
    private List<Task> tasks;
    public UserStory(int id, String title, int storyPoints) {
        this.id = id;
        this.title = title;
        this.storyPoints = storyPoints;
        this.tasks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getStoryPoints() {
        return storyPoints;
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
}
class Task {
    private int id;
    private String description;
    private boolean completed;
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void complete() {
        completed = true;
    }
}

class ScrumTeam {
    private List<UserStory> productBacklog;
    private List<UserStory> sprintBacklog;
    public ScrumTeam() {
        this.productBacklog = new ArrayList<>();
        this.sprintBacklog = new ArrayList<>();
    }

    public void addToProductBacklog(UserStory userStory) {
        productBacklog.add(userStory);
    }
    public void startSprint() {
        sprintBacklog.addAll(productBacklog);
        productBacklog.clear();
    }
    public void finishTask(int taskId) {
        for (UserStory userStory : sprintBacklog) {
            for (Task task : userStory.getTasks()) {
                if (task.getId() == taskId) {
                    task.complete();
                    System.out.println("Task '" + task.getDescription() + "' completed!");
                    return;
                }
            }
        }
        System.out.println("Task not found in the sprint backlog.");
    }
    public void viewSprintBacklog() {
        System.out.println("Sprint Backlog:");
        for (UserStory userStory : sprintBacklog) {
            System.out.println("- " + userStory.getTitle() + " (" + userStory.getStoryPoints() + " SP)");
            for (Task task : userStory.getTasks()) {
                System.out.println("  - Task " + task.getId() + ": " + task.getDescription() +
                        (task.isCompleted() ? " (Completed)" : ""));
            }
        }
    }
}
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ScrumTeam scrumTeam = new ScrumTeam();
        // Create user stories and tasks
        UserStory story1 = new UserStory(1, "Implement User Authentication", 5);
        story1.addTask(new Task(1, "Design login screen"));
        story1.addTask(new Task(2, "Implement authentication logic"));
        UserStory story2 = new UserStory(2, "Create Dashboard UI", 8);
        story2.addTask(new Task(3, "Design dashboard layout"));
        story2.addTask(new Task(4, "Implement data visualization"));
       
        scrumTeam.addToProductBacklog(story1);
        scrumTeam.addToProductBacklog(story2);
        // Start a sprint
        scrumTeam.startSprint();
        // View sprint backlog
        scrumTeam.viewSprintBacklog();
        // Finish a task
        scrumTeam.finishTask(2);
        // View updated sprint backlog
        scrumTeam.viewSprintBacklog();
    }
}
    
    

