import java.util.ArrayList;

public class Player {
   private ArrayList<Item> inventory;
   private String playerName;
   private int health;
   private int currentX;
   private int currentY;


   public Player(int health, String playerName, int startingX, int startingY) {
      // set the health and playerName to the passed parameters
      this.health = health;
      this.playerName = playerName;      
      
      // TODO: create the empty Inventory
      this.inventory = new ArrayList<Item>();
      
      // TODO: set the startingX and Y of the player
      this.currentX = startingX;
      this.currentY = startingY;
   }
   
   public int getX() {
      return this.currentX;
   }
   
   public int getY() {
      return this.currentY;
   }

   public void addItemToInventory(Item item) {
      // TODO: add an item to inventory
      inventory.add(item);
   }
   
   public Item removeItemFromInventory(Item item) {
      // TODO: remove an item to inventory. Return the Item so it can returned to the Room that it is in
      inventory.remove(item);
      return(item);
   }
   
   public Item getItemByName(String itemName) {
      for(Item item : this.inventory) {
         if(item.getItemType().equals(itemName)) {
            return item;
         }
      }
      return null;
   }
   
   public boolean hasItem(String itemName) {
      for(Item item : inventory) {
         if(item.getItemType().equals(itemName)) {
            return true;
         }
      }
      return false;
   }
   
   public String getInventory() {
      String temp = "";
      for(Item item : this.inventory) {
         temp += item + " ";
      }
      return temp;
   }
   
   
   public String look(Map map) {
      // TODO: This method will take the player's current X and Y, and return the contents of the room
      // they are in with a descriptive String
      // HINT: Use map.getRoom(currentX, currentY) and call toString()
      return map.getRoom(currentX, currentY).toString();
   }
   public void moveTo(int x, int y) {
      // TODO: Update the Player's currentX and currentY values.
      this.currentX = x;
      this.currentY = y;
   }
   
   public Room getRoom(Map map) {
      // TODO: return the room object that the player is currently in, given the Map that was passed
      return map.getRoom(currentX, currentY);
   }
   
   public static void main(String[] args) {
      Player p = new Player(100, "Hero", 0, 0);
      Map map = new Map(5, 6);
      System.out.println(p.look(map));
      p.moveTo(1, 2);
      System.out.println(p.look(map));
   }
}