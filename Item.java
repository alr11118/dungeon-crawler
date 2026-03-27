public class Item {
   private String itemType;
   private boolean isEquipped;
   private final ItemType[] itemTypes = {
            new ItemType("Rusty_Sword", 10, 5),
            //new ItemType("Healing_Potion", 10, 5), healing potion will be seperate
            new ItemType("Torch", 10, 5),
            new ItemType("Ancient_Scroll", 10, 5),
            new ItemType("Leather_Armor", 10, 5),
            new ItemType("Silver_Key", 10, 5),
            new ItemType("Magic_Amulet", 10, 5),
            new ItemType("Goblin_Dagger", 10, 5),
            new ItemType("Spellbook_of_Fire", 10, 5),
            new ItemType("Bag_of_Gold_Coins", 10, 5),
            new ItemType("Mysterious_Rune_Stone", 10, 5),
            new ItemType("Skeleton_Bone", 10, 5),
            new ItemType("Cursed_Ring", 10, 5),
            new ItemType("Potion_of_Invisibility", 10, 5),
            new ItemType("Iron_Shield", 10, 5),
            new ItemType("Dragon_Egg", 10, 5),
            new ItemType("Trap_Disarming_Kit", 10, 5),
            new ItemType("Crystal_Orb", 10, 5),
            new ItemType("Venomous_Dagger", 10, 5),
            new ItemType("Tattered_Map", 10, 5)
        };
   public record ItemType(String name, int damage, int level) {}

   public Item() {
      // TODO: Pick a random item type from itemTypes
      int randomIndex = (int)(Math.random()*itemTypes.length);
      this.itemType = itemTypes[randomIndex].name();
      this.isEquipped = false;

   }

   public String getItemType() {
      return this.itemType;
   }
   
   public boolean getIsItemEquiped() {
      return(this.isEquipped);
   }
   
   public void setIsItemEquiped(boolean bool) {
      this.isEquipped = bool;
   }

   
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return("Item: " + this.itemType + ", is Equiped: " + isEquipped);

   }
}