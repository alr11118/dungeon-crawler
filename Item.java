public class Item {
   private String itemTypeName;
   private ItemType itemType;
   private boolean isEquipped;
   private final ItemType[] itemTypes = {
            new ItemType("Rusty_Sword", 10, 5),
            //new ItemType("Healing_Potion", 10, 5), healing potion will be seperate
            new ItemType("Torch", 10, 13),
            new ItemType("Ancient_Scroll", 10, 10),
            new ItemType("Leather_Armor", 10, 7),
            new ItemType("Silver_Key", 10, 10),
            new ItemType("Magic_Amulet", 10, 15),
            new ItemType("Goblin_Dagger", 10, 12),
            new ItemType("Spellbook_of_Fire", 10, 14),
            new ItemType("Bag_of_Gold_Coins", 10, 5),
            new ItemType("Mysterious_Rune_Stone", 10, 10),
            new ItemType("Skeleton_Bone", 10, 5),
            new ItemType("Cursed_Ring", 10, 15),
            new ItemType("Potion_of_Invisibility", 10, 15),
            new ItemType("Iron_Shield", 10, 12),
            new ItemType("Dragon_Egg", 10, 10),
            new ItemType("Trap_Disarming_Kit", 10, 14),
            new ItemType("Crystal_Orb", 10, 16),
            new ItemType("Venomous_Dagger", 10, 19),
            new ItemType("Tattered_Map", 10, 13)
        };
   public record ItemType(String name, int damage, int level) {}

   public Item() {
      // TODO: Pick a random item type from itemTypes
      int randomIndex = (int)(Math.random()*itemTypes.length);
      this.itemTypeName = itemTypes[randomIndex].name();
      this.itemType = itemTypes[randomIndex];
      this.isEquipped = false;

   }

   public String getItemType() {
      return this.itemTypeName;
   }
   
   public boolean getIsItemEquiped() {
      return(this.isEquipped);
   }
   
   public void setIsItemEquiped(boolean bool) {
      this.isEquipped = bool;
   }

   
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return("Item: " + this.itemTypeName + ", is Equiped: " + isEquipped);

   }
}