package NPC;

public class Npc {
    private final NpcEnum type;
    private final String name;
    private final String dialogue;

    public Npc(NpcEnum type, String name, String dialogue) {
        this.type = type;
        this.name = name;
        this.dialogue = dialogue;
    }

    public NpcEnum getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDialogue() {
        return dialogue;
    }
}
