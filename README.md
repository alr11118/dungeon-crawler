# Dungeon Crawler (Text-Based Java Game)

A text-based dungeon crawler inspired by classic interactive fiction games. Built in Java using object-oriented programming, this project simulates a grid-based dungeon filled with monsters, items, and interactive rooms.

The player explores the dungeon, collects items, fights monsters, and tries to survive while navigating the map.

---

## Features

- Fully playable text-based dungeon crawler
- 2D grid-based map system
- Randomly generated rooms with items and monsters
- Inventory system (take/drop items)
- Combat system with monsters
- Movement system with boundary checks
- Healing potion system
- Command-based input parser
- Win condition (defeat all monsters)
- Game over on player death

---

## How the Game Works

The game runs in a loop where the player types commands to interact with the world. Each room contains different items and monsters generated randomly at the start of the game.

The player must explore the map, collect items, and defeat all monsters to win.

---

## Controls / Commands

### Movement
Move using:

```
move up
```
```
move down
```
```
move left
```
```
move right
```

---

### Player Status

```coordinates``` → shows current position

```health``` → shows player health

```look``` → displays current room contents


---

### Inventory System

```take <item>```  →  Take items from the room

```drop <item>```  →  Drop items from your inventory

```inventory``` →  View your inventory

Example:

```
take Rusty_Sword
```

---

### Combat
Fight monsters in the same room:

```fight <monster>```

- Automatically uses the strongest available item
- Monster is removed when defeated

Example:
```
fight Ancient_Dragon
```

---

### Healing & Items

```drink potion``` →  Drink healing potions

---

### Exit the game:

```exit```


---

## Win Condition

- You win by defeating all monsters in the dungeon
- You lose if your health reaches 0

---

## Project Structure

Game.java
Player.java
Map.java
Room.java
Item.java
Monster.java
HealingPotion.java

---

## Concepts Used

- Object-Oriented Programming (OOP)
- Classes and objects
- Encapsulation
- 2D arrays
- ArrayLists
- Input handling
- Game loop design
- Random generation

---

## What I Learned

- Designing a multi-class Java system
- Breaking a large project into smaller components
- Managing game state with objects
- Parsing user input commands
- Debugging interconnected systems

---

## Future Improvements

- Boss fights and stronger enemies
- Expanded item and equipment system
- Improved combat mechanics
- GUI version of the game
- Larger procedural map generation

---

Built as a learning exercise in object-oriented programming and game development.
