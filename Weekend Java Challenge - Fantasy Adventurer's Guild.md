## Overview
Welcome, Adventurer!

Your task is to build a Command Line Interface (CLI) application in Java that simulates a visit to a Fantasy Adventurer's Guild.

The player will arrive at the guild, introduce themselves, order a beverage from the guild barista, interact with various NPCs, accept a quest, and complete their first adventure.

This project is designed to help you practice fundamental Java concepts while encouraging creativity and problem-solving.

---
# Learning Objectives
By completing this challenge, you should gain experience with:
- Reading user input using `Scanner`
- Working with Strings, integers, and Booleans
- Using conditionals (`if`, `else`, `switch`)
- Creating and using classes
- Organizing code into methods
- Using loops (`for` `while`)
- Working with collections
- Creating and using Enums
- Designing a small object-oriented application

---
# Project Requirements
Your application must include the following features.
## 1. Character Creation
When the application starts, the player should be welcomed to the Adventurer's Guild.

The application must ask for:
- Character name
- Character age

Store this information in a `Player` object.
## 2. Beverage Selection
The player must be able to choose a beverage from the guild barista.

Examples:
- Coffee
- Tea
- Water
- Ale

Use an Enum to represent the available beverages.

Your application should react to the player's selection and display an appropriate message.
## 3. NPC Interaction
The player must be able to speak with at least three NPCs.

Examples:
- Guild Master
- Merchant
- Veteran Adventurer
- Blacksmith
- Barista

Each NPC should provide different dialogue or information.

The player should be able to choose which NPC they wish to interact with.
## 4. Quest System
The Guild Master should offer the player a quest.

The player must decide whether they wish to accept the quest.

Use a Boolean value to track whether the quest was accepted.

Examples of quests:
- Defeat goblins
- Rescue a traveler
- Recover a lost artifact
- Hunt dangerous wolves

The quest theme is entirely up to you.
## 5. Quest Completion
The player should complete a simple adventure related to the quest.

This does not need to be complex combat.

Examples:
- Making choices during an encounter
- Solving a simple challenge
- Selecting an action from a menu

The outcome should affect the final result shown to the player.
## 6. Guild Report
At the end of the application, display a summary of the player's adventure.

Example information:
- Character name
- Character age
- Beverage selected
- Quest accepted
- Quest completed
- Any rewards earned

---
# Technical Constraints

Your solution must:
- Be written in Java
- Run entirely in the console
- Use OOP principles
- Contain multiple classes
- Use at least one Enum
- Use at least one List
- Use methods to organize logic
- Use conditionals
- Use loops where appropriate

---
# Suggested Class Structure
You do not have to follow this exactly.

However, a structure similar to the following is recommended:
- `Main`
- `Game`
- `Player`
- `Npc`
- `Quest`
- `Beverage` (Enum)

You are encouraged to expand this structure if needed.

---
# Implementation Hints
These are suggestions, not requirements.
### Player
Consider storing information such as:
- Name
- Age
- Selected Beverage
- Gold Earned
- Quest Status
### NPCs
Each NPC could have:
- Name
- Dialogue

You may wish to store NPCs in a List and allow the player to choose who to speak with.

---
### Menus
A menu-driven design works well for CLI applications.

Example:
1. Talk to Guild Master
2. Talk to Merchant
3. View Character
4. Accept Quest
5. Exit

---
### Enums
Enums are an excellent way to represent fixed values.

Examples include:
- Beverage Types
- Quest Status
- Menu Actions

---
# Bonus Challenges
Choose one or more if you finish early.

### Bonus 1 - Character Save System
Allow the player to save their character information to a file.
### Bonus 2 - Multiple Quests
Add multiple quests and allow the player to choose which one to accept.
### Bonus 3 - Inventory System
Create an inventory where players can collect items and rewards.
### Bonus 4 - Random Events
Introduce random encounters or events using Java's random number generation.

---
# Submission Checklist
Before submitting your project, verify the following:

-  Application compiles and runs without errors.
-  Player can enter a name.
-  Player can enter an age.
-  Beverage selection uses an Enum.
-  At least three NPCs can be interacted with.
-  Player can accept or decline a quest.
-  Quest can be completed through user interaction.
-  A List is used somewhere within the application.
-  Final Guild Report displays adventure results.
-  Code is organized into multiple classes and methods.

Good luck, Adventurer. The guild awaits your arrival!