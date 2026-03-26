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
      Player player = new Player(10, "player1", playerX, playerY);
            
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
            else if (input.startsWith("TAKE ")) {
               String itemName = input.substring(5);
               boolean found = false;
               for(int i = 0; i < player.getRoom(dungeonMap).getItemsInRoom().size(); i++) {
                  Item item = player.getRoom(dungeonMap).getItemsInRoom().get(i);
                  System.out.println(item);
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
            
             else if (input.equals("INVENTORY")) {
               System.out.println("inventory: " + player.getInventory());
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
}