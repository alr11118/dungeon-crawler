public class Map {

   private Room[][] roomGrid;
   
   public Map(int rows, int columns) {
      // TODO: initalize the Map by creating the 2D array
      // and then calling populateMap which will build all of the Rooms
   }
   public void populateMap() {
      // TODO: populate the map with a bunch of Rooms with random numbers of monsters and items
   }
   public Room getRoom(int row, int column) {
      return roomGrid[row][column];
   }
   
   public Room getRandomRoom() {
      // TODO: This method will simply return a random room in the Map so that you can 
      // give the player a random starting point.
      
   }
}
  