package Quest;

public class Quest {
    private String name;
    private String objective;
    private int reward;
    private String completionMessage;
    private boolean active;
    private boolean completed;

    public Quest() {
        // Required for JSON deserialization.
    }

    public Quest(String name, String objective, int reward, String completionMessage) {
        this.name = name;
        this.objective = objective;
        this.reward = reward;
        this.completionMessage = completionMessage;
    }

    public String getName() {
        return name;
    }

    public String getObjective() {
        return objective;
    }

    public int getReward() {
        return reward;
    }

    public String getCompletionMessage() {
        return completionMessage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
