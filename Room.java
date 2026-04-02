import java.util.ArrayList;

public class Room {
   private ArrayList<Item> itemsInRoom;
   private ArrayList<Monster> monstersInRoom;
   private ArrayList<HealingPotion> healingPotions;
   private boolean isThereAHealingPotion;
   private final int maxNumberOfMonsters = 2;
   private final int maxNumberOfItems = 2;
   
   public Room() {
      // TODO: Generate a random number of monsters and items between 1 and max (inclusive)
      // TODO: Create the ArrayLists to hold the Items and Monsters in the Room and populate them with Monsters and Items
      this.itemsInRoom = new ArrayList<Item>();
      this.monstersInRoom = new ArrayList<Monster>();
      this.healingPotions = new ArrayList<HealingPotion>();

      int numberOfItems = (int)(Math.random() * (maxNumberOfItems))+1;
      for(int i = 0; i < numberOfItems; i++) {
         itemsInRoom.add(new Item());
      }

      int numberOfMonsters = (int)(Math.random() * (maxNumberOfMonsters))+1;
      for(int i = 0; i < numberOfMonsters; i++) {
         monstersInRoom.add(new Monster());
      }
      
      this.isThereAHealingPotion = Math.random() > 0.5;
      if(isThereAHealingPotion) {
         healingPotions.add(new HealingPotion());
      }
   }
   
   public ArrayList<Item> getItemsInRoom() {
      return this.itemsInRoom;
   }
   
   public ArrayList<Monster> getMonstersInRoom() {
      return this.monstersInRoom;
   }
   
   public boolean isThereAHealingPotion() {
      return isThereAHealingPotion;
   }
   
   public HealingPotion drinkPotion() {
      HealingPotion temp = healingPotions.get(0);
      this.removeHealingPotion();
      return temp;
   }
   
   public void removeItem(Item item) {
      this.itemsInRoom.remove(item);
   }
   
   public void addItem(Item item) {
      this.itemsInRoom.add(item);
   }
      
   public void removeMonster(Monster monster) {
      this.monstersInRoom.remove(monster);
   }
   
   public void removeHealingPotion() {
      isThereAHealingPotion = false;
      healingPotions.clear();
   }
   
   public boolean hasMonster(String monsterName) {
      for(Monster monster : monstersInRoom) {
         if(monster.getMonsterType().toUpperCase().equals(monsterName.toUpperCase())) {
            return true;
         }
      }
      return false;
   }
   
   public Monster getMonsterByName(String monsterName) {
      for(Monster monster : monstersInRoom) {
         if(monster.getMonsterType().toUpperCase().equals(monsterName.toUpperCase())) {
            return monster;
         }
      }
      return null;

   }
    
   public String toString() {
      String returnString = "Items in room: \n";
      for(Item item : this.getItemsInRoom()) {
         returnString += item + "\n"; 
      }
      returnString += "Monsters in room: \n";
      for(Monster monster : monstersInRoom) {
         returnString += monster + "\n"; 
      }
      returnString += "Healing Potions in room: \n";
      if(isThereAHealingPotion) {
         returnString += healingPotions.get(0) + "\n";
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