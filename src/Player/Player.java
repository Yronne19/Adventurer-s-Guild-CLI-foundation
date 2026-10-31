package Player;

import Beverage.BeverageEnum;
import Quest.Quest;

public class Player {
    private String name;
    private int age;
    private BeverageEnum beverage = BeverageEnum.NOTHING;
    private int gold;
    private Quest quest;

    public Player() {
        // Required for JSON deserialization.
    }

    public Player(Quest quest) {
        this.quest = quest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BeverageEnum getBeverage() {
        return beverage == null ? BeverageEnum.NOTHING : beverage;
    }

    public void setBeverage(BeverageEnum beverage) {
        this.beverage = beverage == null ? BeverageEnum.NOTHING : beverage;
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Gold amount cannot be negative.");
        }
        gold += amount;
    }

    public Quest getQuest() {
        return quest;
    }
}
