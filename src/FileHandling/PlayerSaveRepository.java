package FileHandling;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Player.Player;

public class PlayerSaveRepository {
    private static final Path SAVE_FILE = Path.of("data", "player-save.json");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void save(Player player) throws IOException {
        Files.createDirectories(SAVE_FILE.getParent());
        Files.writeString(SAVE_FILE, gson.toJson(player), StandardCharsets.UTF_8);
    }
}
