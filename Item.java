public class Item {
   private ItemType itemType;
   private boolean isEquipped;
   private String name;
   private int level;
   private int damagePerHit;
   private final ItemType[] itemTypes = {
            new ItemType("Rusty_Sword", 100),
            new ItemType("Torch", 75),
            new ItemType("Ancient_Scroll", 65),
            new ItemType("Leather_Armor", 65),
            new ItemType("Silver_Key", 55),
            new ItemType("Magic_Amulet", 100),
            new ItemType("Goblin_Dagger", 65),
            new ItemType("Spellbook_of_Fire", 80),
            new ItemType("Bag_of_Gold_Coins", 55),
            new ItemType("Mysterious_Rune_Stone", 90),
            new ItemType("Skeleton_Bone", 70),
            new ItemType("Cursed_Ring", 75),
            new ItemType("Potion_of_Invisibility", 65),
            new ItemType("Iron_Shield", 80),
            new ItemType("Dragon_Egg", 85),
            new ItemType("Trap_Disarming_Kit", 65),
            new ItemType("Crystal_Orb", 90),
            new ItemType("Venomous_Dagger", 95),
            new ItemType("Tattered_Map", 80)
        };
   public record ItemType(String name, int damage) {}

   public Item() {
      // TODO: Pick a random item type from itemTypes
      int randomIndex = (int)(Math.random()*itemTypes.length);
      this.itemType = itemTypes[randomIndex];
      this.name = itemType.name();
      this.damagePerHit = itemType.damage();
      this.level = (int)Math.round((this.damagePerHit-50)/2.5);
      this.isEquipped = false;

   }

   public String getItemType() {
      return this.name;
   }
   
   public boolean getIsItemEquiped() {
      return(this.isEquipped);
   }
   
   public int getLevel() {
      return this.level;
   }
   
   public int getDamage() {
      return this.damagePerHit;
   }
   
   public void setIsItemEquiped(boolean bool) {
      this.isEquipped = bool;
   }

   
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return("Item: " + this.name + ", is Equiped: " + isEquipped + ", Level: " + this.level);

   }
}