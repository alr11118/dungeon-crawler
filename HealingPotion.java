public class HealingPotion {
   private PotionType potionType;
   private String name;
   private int healValue;
   private final PotionType[] potionTypes = {
            new PotionType("Red_Potion", 150),
            new PotionType("Orange_Potion", 75),
            new PotionType("Yellow_Potion", 75),
            new PotionType("Green_Potion!", -50),
            new PotionType("Blue_Potion", 100),
            new PotionType("Purple_Potion", 100),
            new PotionType("Pink_Potion", 200)
        };
   public record PotionType(String name, int healValue) {}
   
   public HealingPotion() {
      int randomIndex = (int)(Math.random()*potionTypes.length);
      this.potionType = potionTypes[randomIndex];
      this.name = potionType.name();
      this.healValue = potionType.healValue();
   }

   public String getPotionName() {
      return this.name;
   }
      
   public int getHealValue() {
      return this.healValue;
   }
   
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return("Healing Potion: " + this.name + ", health: " + this.healValue);

   }

}