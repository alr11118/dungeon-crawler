public class Map {

   private Room[][] roomGrid;
   
   public Map(int rows, int columns) {
      // TODO: initalize the Map by creating the 2D array
      // and then calling populateMap which will build all of the Rooms
      this.roomGrid = new Room[rows][columns];
      this.populateMap();
   }
   
   public void populateMap() {
      // TODO: populate the map with a bunch of Rooms with random numbers of monsters and items
      // Hint: Use nested for loops to fill every row and column
      // Another Hint: use the Room constructor to populate the Monsters and Items
      for(int row = 0; row < roomGrid.length; row++) {
         for(int col = 0; col < roomGrid[0].length; col++) {
            roomGrid[row][col] = new Room();
         }
      }
   }
   
   public int getNumRows() {
      // TODO: return the number of rows in roomGrid
      return roomGrid.length;
   }
   
   public int getNumCols() {
      // TODO: return the number of columns in roomGrid
      return roomGrid[0].length;
   }
   
   public Room getRoom(int row, int column) {
      // TODO: return the Room that is at the row and column that are passed
      return roomGrid[row][column];
   }
   
   public Room getRandomRoom() {
      // TODO: This method will simply return a random room in the Map so that you can 
      // give the player a random starting point.
      int row = (int)(Math.random() * roomGrid.length);
      int col = (int)(Math.random() * roomGrid[0].length);
      return roomGrid[row][col];
   }
   
   public static void main(String[] args) {
      Map map = new Map(5, 6);
      System.out.println(map.getRoom(0, 0));
      System.out.println(map.getRoom(2, 3));
   }
}
  