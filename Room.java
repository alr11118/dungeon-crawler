import java.util.ArrayList;

public class Room {
   private ArrayList<Item> itemsInRoom;
   private ArrayList<Monster> monstersInRoom;
   private final int maxNumberOfMonsters = 2;
   private final int maxNumberOfItems = 2;
   
   public Room() {
      // TODO: Generate a random number of monsters and items between 1 and max (inclusive)
      // TODO: Create the ArrayLists to hold the Items and Monsters in the Room and populate them with Monsters and Items
      this.itemsInRoom = new ArrayList<Item>();
      this.monstersInRoom = new ArrayList<Monster>();

      int numberOfItems = (int)(Math.random() * (maxNumberOfItems))+1;
      for(int i = 0; i < numberOfItems; i++) {
         itemsInRoom.add(new Item());
      }

      int numberOfMonsters = (int)(Math.random() * (maxNumberOfMonsters))+1;
      for(int i = 0; i < numberOfMonsters; i++) {
         monstersInRoom.add(new Monster());
      }
   }
   
   public ArrayList<Item> getItemsInRoom() {
      return this.itemsInRoom;
   }
   
   public ArrayList<Monster> getMonstersInRoom() {
      return this.monstersInRoom;
   }
   
   public void removeItem(Item item) {
      this.itemsInRoom.remove(item);
   }
   
   public void removeMonster(Monster monster) {
      this.monstersInRoom.remove(monster);
   }
   
   public String toString() {
      String returnString = "Items in room: \n";
      for(Item item : itemsInRoom) {
         returnString += item + "\n"; 
      }
      returnString += "Monsters in room: \n";
      for(Monster monster : monstersInRoom) {
         returnString += monster + "\n"; 
      }
      // TODO: build a returnString that nicely formats the Monsters and Items in the Room
      // HINT: Use a for-each loop to go through the ArrayLists
      return returnString;
   }
   
   public static void main(String[] args) {
      Room room = new Room();
      System.out.println(room);
   }
}