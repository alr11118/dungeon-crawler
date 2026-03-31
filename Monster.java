public class Monster {
   private MonsterType monsterType;
   private String name;
   private int health;
   private int level;
   private int damagePerHit;
   
   private final MonsterType[] monsterTypes = {
            new MonsterType("Goblin", 30, 100), 
            new MonsterType("Skeleton_Warrior", 20, 150),
            new MonsterType("Zombie", 40, 150),
            new MonsterType("Orc", 45, 175),
            new MonsterType("Dark_Sorcerer", 50, 100),
            new MonsterType("Giant_Spider", 45, 125),
            new MonsterType("Vampire_Bat", 25, 120),
            new MonsterType("Slime", 15, 100),
            new MonsterType("Mimic", 50, 100),
            new MonsterType("Lich", 60, 150),
            new MonsterType("Troll", 65, 150),
            new MonsterType("Werewolf", 60, 175),
            new MonsterType("Gargoyle", 60, 200),
            new MonsterType("Wraith", 70, 190),
            new MonsterType("Minotaur", 70, 180),
            new MonsterType("Basilisk", 70, 180),
            new MonsterType("Doppelgänger", 75, 170),
            new MonsterType("Demon_Hound", 70, 130),
            new MonsterType("Cave_Serpent", 60, 120),
            new MonsterType("Ancient_Dragon", 80, 250)
        };
        
   public record MonsterType(String name, int damagePerHit, int startingHealth) {}

   public Monster() {
      // TODO: Pick a random monster type from monsterTypes
      int randomIndex = (int)(Math.random()*monsterTypes.length);
      this.monsterType = monsterTypes[randomIndex];
      this.name = monsterType.name;
      this.damagePerHit = monsterType.damagePerHit;
      this.health = monsterType.startingHealth;
      this.level = (int) Math.round(this.damagePerHit/4);
   }
   
   public int getMonsterHealth() {
      return this.health;
   }
   
   public int getDamagePerHit() {
      return this.damagePerHit;
   }
   
   public String getMonsterType() {
      return this.name;
   }
   
   public void damageMonster(int damageAmount) {
      this.health -= damageAmount;
      if(health < 0) {
         health = 0;
      }
   }
   
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return("Monster: " + this.name + " Health: " + this.health + " Level: " + this.level);
   }
}