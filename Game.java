import java.util.Scanner;

public class Game {   
   public static void main(String[] args) {
      boolean exitGame = false;
      Game game = new Game();
      Map dungeonMap = new Map(5, 6);
            
      Scanner scanner = new Scanner(System.in);
      
      // TODO: Create a Map which populates each element of the grid with a Room
      // that contains a random assortment of Monsters and Items
      
      // TODO: Create a Player at a random location in the Map
      // HINT: Generate random row/column values using Math.random()
      // and pass them into the Player constructor
      int playerX = (int)(Math.random()*dungeonMap.getNumRows());
      int playerY = (int)(Math.random()*dungeonMap.getNumCols());
      Player player = new Player(500, "player1", playerX, playerY);
      
      // Game Directions
      System.out.print("How to play:\nMove using command 'move' with 'up', 'down', 'right' and 'left' directions.\nExample: move up\nGet current coordinates using the command 'coordinates'\nUse the 'look' command to look arround the room\nUse 'take <item name>' command to take items from the room to your inventory\nExample: take Rusty_Sword\nUse 'drop <item name>' command to drop items from your inventory into your current room\nExample: drop Rusty_Sword\nUse 'invemtory' command to view your inventory\nUse 'fight <monster name>' command to fight the monsters that are in the same room as you, using your highest level item.\nExample: fight Ancient_Dragon\nIf your health drops to 0 you die and the game exits\nTo exit the game yourself use the command 'exit'\n");
      
      while (exitGame != true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().toUpperCase();
                        
            if (input.equals("EXIT")) {
                System.out.println("Exiting game. Goodbye!");
                exitGame = true;
            }
            else if (input.equals("LOOK") || input.equals("SEARCH")) {
               System.out.println(player.look(dungeonMap));
            }
            
            else if (input.equals("COORDINATES")) {
               System.out.println("Current Coordinates: (" + player.getX() +", "+ player.getY()+")");
            }
            
            else if (input.equals("INVENTORY")) {
               System.out.println("inventory: " + player.getInventory());
            }
                        
            else if (input.startsWith("TAKE ")) {
               String itemName = input.substring(5);
               boolean found = false;
               for(int i = 0; i < player.getRoom(dungeonMap).getItemsInRoom().size(); i++) {
                  Item item = player.getRoom(dungeonMap).getItemsInRoom().get(i);
                  if(itemName.equals(item.getItemType().toUpperCase())) {
                     player.addItemToInventory(item);
                     player.getRoom(dungeonMap).removeItem(item);
                     found = true;
                  }
               }
               if(!found){
                  System.out.println("Erorr: Item not in room");
               }
            }
            
            else if (input.startsWith("DROP ")) {
               String itemName = input.substring(5);
               if(player.hasItem(itemName)) {
                  Item item = player.getItemByName(itemName);
                  player.removeItemFromInventory(item);
                  player.getRoom(dungeonMap).addItem(item); 
               }
               else {
                  System.out.println("Erorr: Player does not have the item");
               }
            }
            
            // Fights using the fist item in the inventory
            // How do I want the improved monster fight to look like: 
            // you pick which monster you want,
            // items dont have health but they have damage values/levels, 
            // you fight with the hishest item you have, 
            // monsters also have damage values and you hit eachother one by one, 
            // who dies forst looses there are healing posions hidden in some rooms
            
            // What do I want to do right now: random healing p[otions with different colors and healing values you can grab them amd then you can drink them 
            else if (input.startsWith("FIGHT ")) 
            {
               // Sainty checks
               String monsterName = input.substring(6);
               if(!player.getRoom(dungeonMap).hasMonster(monsterName)) 
               {
                  System.out.println("Erorr: Monster not in the room");

               }
               if(player.getInventoryAsList().size() <= 0)
               {
                  System.out.println("Erorr: No items to fight");
               }
               
               Monster monster = player.getRoom(dungeonMap).getMonsterByName(monsterName);
               Item highestItem = player.getHighestItem();
               System.out.println("Starting Fight!!!");
               printWithDelay("Player health: " + player.getPlayerHealth());
               printWithDelay("Monster health: " + monster.getMonsterHealth());
               printWithDelay("Fighting with: " + highestItem);

               // Simutale fight!!
               while(player.getPlayerHealth() > 0 && monster.getMonsterHealth() > 0) {
                  // First the player hits
                  monster.damageMonster(highestItem.getDamage());
                  // then the monster hits
                  player.damagePlayer(monster.getDamagePerHit()); 
                  // Log healths 
                  printWithDelayNoNewLine(".");
                  printWithDelayNoNewLine(".");
                  printWithDelayNoNewLine(".");
                  printWithDelayNoNewLine("\n");
                  printWithDelay("Player health: " + player.getPlayerHealth());
                  printWithDelay("Monster health: " + monster.getMonsterHealth());
               }
               
               // Check who died
               if(player.getPlayerHealth() <= 0) {
                  System.out.println("You died");
                  exitGame = true;
               }
               else if(monster.getMonsterHealth() <= 0) {
                  printWithDelay("You won!!");
                  player.getRoom(dungeonMap).removeMonster(monster);
               }
            }


            // TODO: get the player movement working correctly. It should NOT let the player
            // move beyond the boundaries of the map, and provide the user with descriptions
            // of what is happening. You'll have to change the if/else/if statements here to 
            // do this.
            else if (input.startsWith("MOVE ")) {
               String direction = input.substring(5);
               if (direction.equals("UP") && player.getY()+1 < dungeonMap.getNumCols()) {
                  player.moveTo(player.getX(), player.getY() + 1);
                  System.out.println("Current Coordinates: (" + player.getX() +", "+ player.getY()+")");
               } 
               else if (direction.equals("DOWN") && player.getY()-1 >= 0) {
                  player.moveTo(player.getX(), player.getY() - 1);
                  System.out.println("Current Coordinates: (" + player.getX() +", "+ player.getY()+")");
               } 
               else if (direction.equals("LEFT") && player.getX()-1 >= 0) {  
                  player.moveTo(player.getX() - 1, player.getY()); 
                  System.out.println("Current Coordinates: (" + player.getX() +", "+ player.getY()+")"); 
               } 
               else if (direction.equals("RIGHT") && player.getX()+1 < dungeonMap.getNumRows()) {
                  player.moveTo(player.getX() + 1, player.getY());
                  System.out.println("Current Coordinates: (" + player.getX() +", "+ player.getY()+")");
               } 
               else {
                  System.out.println("You're trying to move in an invalid direction. Please choose UP, DOWN, LEFT or RIGHT");
                  System.out.println("Current Coordinates: (" + player.getX() +", "+ player.getY()+")");
               }
            }
         // TODO: display a message to the user telling them their current coordinates every time they move
       }
   }
   
   public static void printWithDelay(String text) {
      try {
         Thread.sleep(1000);
      } 
      catch (Exception e) {
         
      }
      System.out.println(text);
   }
   public static void printWithDelayNoNewLine(String text) {
      try {
         Thread.sleep(1000);
      } 
      catch (Exception e) {
         
      }
      System.out.print(text);
   }
}