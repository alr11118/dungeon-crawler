public class Monster {
private String monsterType;
private int monsterHealth;
   private final String[] monsterTypes = {
            "Goblin",
            "Skeleton_Warrior",
            "Zombie",
            "Orc",
            "Dark_Sorcerer",
            "Giant_Spider",
            "Vampire_Bat",
            "Slime",
            "Mimic",
            "Lich",
            "Troll",
            "Werewolf",
            "Gargoyle",
            "Wraith",
            "Minotaur",
            "Basilisk",
            "Doppelgänger",
            "Demon_Hound",
            "Cave_Serpent",
            "Ancient_Dragon"
        };

   public Monster() {
      // TODO: Pick a random monster type from monsterTypes
      int randomIndex = (int)(Math.random()*monsterTypes.length);
      this.monsterType = monsterTypes[randomIndex];
      this.monsterHealth = 100;
   }
   public int getMonsterHealth() {
      return this.monsterHealth;
   }
   
   public String getMonsterType() {
      return this.monsterType;
   }
   
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return("Monster: " + this.monsterType + " Health: " + this.monsterHealth);
   }
}