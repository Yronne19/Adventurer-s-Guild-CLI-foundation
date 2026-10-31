# Fantasy Adventurer's Guild

A Java console project about creating an adventurer, choosing a guild beverage, and meeting the guild's NPCs.

## Features

- Collects the player's name and age.
- Offers coffee, tea, water, or ale using the `BeverageEnum` enum.
- Presents a menu for five NPCs, each with unique dialogue.
- Lets the player accept and complete the Guild Master's quest.
- Produces a final Guild Report with the adventure outcome.
- Saves the player, quest state, beverage, and gold to `data/player-save.json` using Gson.

## Requirements

- Java Development Kit (JDK) 11 or later.
- PowerShell (for the commands below).

## Build and run

Run these commands from the project root:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
javac -cp ".\lib\gson-2.15.0.jar" -d out (Get-ChildItem .\src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp "out;.\lib\gson-2.15.0.jar" Main
```

The application writes its JSON save file to `data\player-save.json` in the project root. It is automatically saved after important choices and when the program exits.

## Project structure

```text
src/
  Beverage/       Beverage enum
  FileHandling/   Gson player-save repository
  InputValidation/Console input helpers
  NPC/            NPC model and enum
  Player/         Player model
  Quest/          Quest model
  data/           Legacy dialogue source files
  Main.java       Application entry point and menus
```

The project is a small console game intended as a learning exercise.
