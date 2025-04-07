# Pac-Man Game Implementation

![Image](https://github.com/user-attachments/assets/95627db8-69cd-415c-b955-855fe36df8c7)

## Project Description
A Java-based Pac-Man game with GUI (mandatory) featuring core gameplay mechanics, customizable settings, and optional multiplayer functionality using client-server architecture.

---

## Core Features

### **Game Elements**
| Component          | Behavior                                  |
|--------------------|-------------------------------------------|
| **Pac-Man**        | Player-controlled (WASD/arrow keys) with 3-5 lives (configurable) |
| **Gold Coins**     | 75-155 yellow dots (1 point each); respawn after collection |
| **Walls**          | Green barriers (custom layouts allowed)   |
| **Enemies**        | White ghosts with random movement; deduct 1 life on collision |

### **Game Flow**
1. **Main Menu**: Start Game / Settings / Highscores  
2. **Player Setup**: Enter username → Begin game  
3. **Gameplay**:  
   - Collect coins → Increase score  
   - Avoid enemies → Lose lives  
4. **Game Over**: When lives = 0 → Save score to highscores  

### **Technical Requirements**
- **GUI**: Java Swing (clean design affects grading)  
- **Movement**: Smooth keyboard controls  
- **Scoring**: Dynamic display with "NEW RECORD" notification  
- **Highscores**: Sorted leaderboard (name + score)  

---

## Advanced Features (Bonus Points)

### **Customization**
- Adjust coin count (75-155)  
- Modify enemy count (default: 4)  
- **Special Coins**: +6 points (max 6 per level)  

### **Dynamic Level Design**
- Regenerate wall layouts after coin collection  
- New enemy types (e.g., faster/predictive ghosts)  

### **Multiplayer (Client-Server)**
- **Admin Client**: Spawn/move enemies in real-time  
- **Observer Client**: Watch Pac-Man movement  

---

## Implementation Details

### **Key Classes**
```java
public class Pacman {
    // Handles movement, lives, collision
}

public class GameBoard {
    // Manages coins, walls, enemies
}

public class HighscoreManager {
    // Saves/loads player records
}
