public class Monster {
   private MonsterType monsterType;
   private String name;
   private int health;
   private int level;
   private int damagePerHit;
   
   private final MonsterType[] monsterTypes = {
            new MonsterType("Goblin", 10, 200), 
            new MonsterType("Skeleton_Warrior", 5, 100),
            new MonsterType("Zombie", 5, 100),
            new MonsterType("Orc", 5, 100),
            new MonsterType("Dark_Sorcerer", 5, 100),
            new MonsterType("Giant_Spider", 5, 100),
            new MonsterType("Vampire_Bat", 5, 100),
            new MonsterType("Slime", 5, 100),
            new MonsterType("Mimic", 5, 100),
            new MonsterType("Lich", 5, 100),
            new MonsterType("Troll", 5, 100),
            new MonsterType("Werewolf", 5, 100),
            new MonsterType("Gargoyle", 5, 200),
            new MonsterType("Wraith", 5, 100),
            new MonsterType("Minotaur", 5, 100),
            new MonsterType("Basilisk", 5, 100),
            new MonsterType("Doppelgänger", 5, 100),
            new MonsterType("Demon_Hound", 5, 100),
            new MonsterType("Cave_Serpent", 5, 100),
            new MonsterType("Ancient_Dragon", 5, 100)
        };
        
   public record MonsterType(String name, int level, int startingHealth) {}

   public Monster() {
      // TODO: Pick a random monster type from monsterTypes
      int randomIndex = (int)(Math.random()*monsterTypes.length);
      this.monsterType = monsterTypes[randomIndex];
      this.name = monsterType.name;
      this.level = monsterType.level;
      this.health = monsterType.startingHealth;
      
      // Idea maybe use a switch case...later
      if(this.level < 5){
         this.damagePerHit = 10;
      }
      else if(this.level < 10 && this.level >= 5){
         this.damagePerHit = 25;
      }
      else if(this.level < 15 && this.level >= 10){
         this.damagePerHit = 50;
      }
      else if(this.level <= 20 && this.level >= 15){
         this.damagePerHit = 65;
      }
      else{
         this.damagePerHit = 10;
      }
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
   }
   
   public String toString() {
      // TODO: Build a descriptive String for use by other methods
      return("Monster: " + this.name + " Health: " + this.health + " Level: " + this.level);
   }
}