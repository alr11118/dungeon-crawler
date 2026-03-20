import java.util.ArrayList;

public class Room {
   private ArrayList<Item> itemsInRoom;
   private ArrayList<Monster> monstersInRoom;
   private final int maxNumberOfMonsters = 1;
   private final int maxNumberOfItems = 2;
   
   public Room() {
      int numOfMonsters = (int) (Math.random() * maxNumberOfMonsters) + 1; 
      int numberOfItems = (int) (Math.random() * maxNumberOfItems) + 1;
      
      itemsInRoom = new ArrayList<Item>();
      monstersInRoom = new ArrayList<Monster>();
      
      for (int i = 1; i <= numOfMonsters; i++) {
         monstersInRoom.add(new Monster());         
      }
      
      for (int i = 1; i <= numberOfItems; i++) {
         itemsInRoom.add(new Item());         
      }
      
   }
   
   public String toString() {
      String returnString = "Items in room: ";

      
      for (Item item : itemsInRoom) {
         returnString = returnString + item + ", ";
      }
      
      returnString += "\n\nMonsters in room: ";
      for (Monster monster : monstersInRoom) {
            returnString = returnString + monster + ", ";
      }
      return returnString;
   }
      
    public static void main(String[] args) {
      Room room = new Room();
      System.out.println(room);
    }
   }