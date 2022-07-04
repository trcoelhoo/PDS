package ex3;

public class Lab05ex3 {
    public static void main(String[] args) {
        Movie filme = new Movie.Builder("O Poderoso Chefão")
                .MovieYear(1998)
                .MovieDirector(new Person("Francis Ford Coppola", 56))
                .MovieWriter(new Person("Mario Puzo", 56))
                .isTelMovie(true)
                .isNetMovie(false)
                .isIndepMovie(true)
                .MovieCast(new Person("Al Pacino", 56))
                .MovieLocations(new Place("USA", "New York", "Manhattan"))
                .MovieLanguages("Portuguese")
                .MovieGenres("Crime")

                .Moviebuild();
        System.out.println(filme);
    }

}
