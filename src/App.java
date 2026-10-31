import java.util.List;
import java.util.Scanner;

import Beverage.BeverageEnum;
import FileHandling.PlayerSaveRepository;
import InputValidation.InputValidation;
import NPC.Npc;
import NPC.NpcEnum;
import Player.Player;
import Quest.Quest;

public class App {

    private final Scanner scanner = new Scanner(System.in);
    private final InputValidation input = new InputValidation(scanner);
    private final PlayerSaveRepository saveRepository = new PlayerSaveRepository();
    private final Quest quest = new Quest(
            "Slime Trouble",
            "Defeat the slimes in the Whispering Forest.",
            100,
            "Excellent work! The forest is safer because of you.");
    private final Player player = new Player(quest);
    private final List<Npc> npcs = List.of(
            new Npc(NpcEnum.GUILD_MASTER, "Guild Master",
                    "Welcome, adventurer. A group of slimes has appeared in the Whispering Forest."),
            new Npc(NpcEnum.MERCHANT, "Merchant",
                    "Supplies make the difference between a story and a legend."),
            new Npc(NpcEnum.VETERAN_ADVENTURER, "Veteran Adventurer",
                    "Watch your footing in the forest. Slimes like damp ground."),
            new Npc(NpcEnum.BLACKSMITH, "Blacksmith",
                    "Keep your weapon clean and your promises cleaner."),
            new Npc(NpcEnum.BARISTA, "Barista",
                    "A warm drink is the first step toward a brave day."));

    public void run() {
        createCharacter();
        boolean running = true;
        while (running) {
            printMenu();
            switch (input.inputNumberInRange("Choose an option", 1, 6)) {
                case 1 -> selectBeverage();
                case 2 -> talkToNpc();
                case 3 -> completeQuest();
                case 4 -> printCharacter();
                case 5 -> savePlayer();
                case 6 -> running = false;
                default -> throw new IllegalStateException("Unexpected menu option");
            }
        }

        savePlayer();
        printGuildReport();
        scanner.close();
    }

    private void createCharacter() {
        System.out.println("=== Welcome to the Adventurer's Guild! ===");
        player.setName(input.inputText("Character name"));
        player.setAge(input.inputNumberInRange("Character age", 1, 150));
        savePlayer();
        System.out.printf("Welcome, %s!%n%n", player.getName());
    }

    private void printMenu() {
        System.out.println("=== Guild Hall ===");
        System.out.println("1. Select a beverage");
        System.out.println("2. Talk to an NPC");
        System.out.println("3. Go on your quest");
        System.out.println("4. View character");
        System.out.println("5. Save character");
        System.out.println("6. Leave the guild");
    }

    private void selectBeverage() {
        System.out.println("=== Select Beverage ===");
        BeverageEnum[] choices = {BeverageEnum.COFFEE, BeverageEnum.TEA, BeverageEnum.WATER, BeverageEnum.ALE};
        for (int index = 0; index < choices.length; index++) {
            System.out.printf("%d. %s%n", index + 1, choices[index].getDisplayName());
        }

        int choice = input.inputNumberInRange("Select beverage", 1, choices.length);
        player.setBeverage(choices[choice - 1]);
        System.out.printf("The barista hands %s a %s.%n%n", player.getName(), player.getBeverage().getDisplayName());
        savePlayer();
    }

    private void talkToNpc() {
        System.out.println("=== Choose an NPC ===");
        for (int index = 0; index < npcs.size(); index++) {
            System.out.printf("%d. %s%n", index + 1, npcs.get(index).getName());
        }
        System.out.printf("%d. Return%n", npcs.size() + 1);

        int choice = input.inputNumberInRange("Talk to", 1, npcs.size() + 1);
        if (choice == npcs.size() + 1) {
            return;
        }

        Npc npc = npcs.get(choice - 1);
        System.out.printf("%n%s: %s%n", npc.getName(), npc.getDialogue());
        if (npc.getType() == NpcEnum.GUILD_MASTER) {
            offerQuest();
        }
        System.out.println();
    }

    private void offerQuest() {
        if (quest.isCompleted()) {
            System.out.println("Guild Master: You have already made the guild proud.");
            return;
        }
        if (quest.isActive()) {
            System.out.println("Guild Master: Your quest is still active: " + quest.getName());
            return;
        }

        System.out.printf("Quest: %s%nObjective: %s%nReward: %d gold%n",
                quest.getName(), quest.getObjective(), quest.getReward());
        if (input.inputYesNo("Accept this quest")) {
            quest.setActive(true);
            System.out.println("You accepted the quest!");
        } else {
            System.out.println("The Guild Master nods. The offer remains open.");
        }
        savePlayer();
    }

    private void completeQuest() {
        if (!quest.isActive()) {
            System.out.println("You do not have an active quest. Speak to the Guild Master first.\n");
            return;
        }

        System.out.println("In the Whispering Forest, five slimes block the path.");
        if (!input.inputYesNo("Face the slimes")) {
            System.out.println("You return to the guild to prepare.\n");
            return;
        }

        quest.setActive(false);
        quest.setCompleted(true);
        player.addGold(quest.getReward());
        System.out.println(quest.getCompletionMessage());
        System.out.printf("You earned %d gold.%n%n", quest.getReward());
        savePlayer();
    }

    private void printCharacter() {
        System.out.printf("%n=== Character Sheet ===%nName: %s%nAge: %d%nBeverage: %s%nGold: %d%nQuest: %s%n%n",
                player.getName(),
                player.getAge(),
                player.getBeverage().getDisplayName(),
                player.getGold(),
                getQuestStatus());
    }

    private void printGuildReport() {
        System.out.printf("%n=== Guild Report ===%nAdventurer: %s%nAge: %d%nBeverage: %s%nQuest accepted: %s%nQuest completed: %s%nGold earned: %d%n",
                player.getName(),
                player.getAge(),
                player.getBeverage().getDisplayName(),
                quest.isActive() || quest.isCompleted() ? "Yes" : "No",
                quest.isCompleted() ? "Yes" : "No",
                player.getGold());
    }

    private String getQuestStatus() {
        if (quest.isCompleted()) {
            return quest.getName() + " (completed)";
        }
        if (quest.isActive()) {
            return quest.getName() + " (active)";
        }
        return "No active quest";
    }

    private void savePlayer() {
        try {
            saveRepository.save(player);
        } catch (Exception exception) {
            System.err.println("Unable to save character: " + exception.getMessage());
        }
    }
}
