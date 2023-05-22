# Snake and Ladder Game

This is a simple Snake and Ladder game implemented as a Spring Boot project. The game allows players to roll a dice and move their token on the game board based on the outcome of the dice roll. If the player lands on a snake, they move down to a lower-numbered square, whereas if they land on a ladder, they move up to a higher-numbered square.

## Game Features

- Classic Snake and Ladder gameplay.
- Supports multiple players.
- User can decide position of snake, ladder and size of board.
- Random dice roll for each player's turn.
- Player statistics tracking (current position).
- A ladder bottom and snake head can't be in sam index 

## Requirements

- Java Development Kit (JDK) 8 or higher
- Maven

## Installation

1. Clone the repository:

```bash
git clone https://github.com/amPrajapatiDeqode/SnakeLadder.git
```

2. Build the project using Maven:

```bash
mvn clean install
```

## Usage

1. Run the Spring Boot application:

```bash
mvn spring-boot:run
```
