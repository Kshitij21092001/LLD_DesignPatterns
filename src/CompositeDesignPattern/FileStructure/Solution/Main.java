package CompositeDesignPattern.FileStructure.Solution;

public class Main {
    public static void main(String[] args){
        Directory movies = new Directory("Movies");
        Directory comedyMovies = new Directory("Comedy Movies");
        Directory thrillerMovies = new Directory("Thriller Movies");
        File theHangover = new File("TheHangover.mp4");
        File shutterIsland = new File("ShutterIsland.mp4");

        movies.addToDirectory(comedyMovies);
        comedyMovies.addToDirectory(theHangover);
        movies.addToDirectory(thrillerMovies);
        thrillerMovies.addToDirectory(shutterIsland);

        movies.ls();
    }
}
