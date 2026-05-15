package CompositeDesignPattern.FileStructure.Problem;

public class Main {
    public static void main(String[] args){
        Directory movies = new Directory("Movies");
        Directory comedyMovies = new Directory("Comedy Movies");
        Directory thrillerMovies = new Directory("Thriller Movies");
        File theHangover = new File("TheHangver.mp4");
        File shutterIsland = new File("Shutter Island.mp4");

        movies.addToDirectory(comedyMovies);
        movies.addToDirectory(thrillerMovies);
        comedyMovies.addToDirectory(theHangover);
        thrillerMovies.addToDirectory(shutterIsland);

        movies.ls();
    }
}
