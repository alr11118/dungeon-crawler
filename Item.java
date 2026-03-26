public class Item {
   private String itemType;
   private boolean isEquipped;
   private final String[] itemTypes = {
            "Rusty_Sword",
            "Healing_Potion",
            "Torch",
            "Ancient_Scroll",
            "Leather_Armor",
            "Silver_Key",
            "Magic_Amulet",
            "Goblin_Dagger",
            "Spellbook_of_Fire",
            "Bag_of_Gold_Coins",
            "Mysterious_Rune_Stone",
            "Skeleton_Bone",
            "Cursed_Ring",
            "Potion_of_Invisibility",
            "Iron_Shield",
            "Dragon_Egg",
            "Trap_Disarming_Kit",
            "Crystal_Orb",
            "Venomous_Dagger",
            "Tattered_Map"
        };

   public Item() {
      // TODO: Pick a random item type from itemTypes
      int randomIndex = (int)(Math.random()*itemTypes.length);
      this.itemType = itemTypes[randomIndex];
      this.isEquipped = false;

   }
   
   public void setIsItemEquiped(boolean bool) {
      this.isEquipped = bool;
   }
   
   public String getItemType() {
      return this.itemType;
   }
   
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return("Item: " + this.itemType + ", is Equiped: " + isEquipped);

   }
}