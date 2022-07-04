package ex3;

import java.util.*;

public class Movie {
    private final String title;
	private final int year;
	private final Person director;
	private final Person writer;
	private final List<Person> cast;
	private final List<Place> locations;
	private final List<String> languages;
	private final List<String> genres;
	private final boolean isTelevision;
	private final boolean isNetflix;
	private final boolean isIndependent;


    public static class Builder {
    
        private final String title;
		private int year=0;
		private Person director=null;
		private Person writer=null;
		private List<Person> cast =new ArrayList<Person>();
		private List<Place> locations =new ArrayList<Place>();
		private List<String> languages =new ArrayList<String>();
		private List<String> genres =new ArrayList<String>();
		private boolean isTelevision;
		private boolean isNetflix;
		private boolean isIndependent;
        
        
        
        public Builder(String title){
            this.title=title;
        }
        
        public Builder MovieYear(int year){
            this.year=year;
            return this;
        }

        public Builder MovieDirector(Person director){
            this.director = director;
            return this;
        }

        public Builder MovieWriter(Person writer){
            this.writer = writer;
            return this;
        }

        public Builder isTelMovie(boolean isTelevision){
            this.isTelevision=isTelevision;
            return this;
        }

        public Builder isNetMovie(boolean isNetflix){
            this.isNetflix=isNetflix;
            return this;
        }

        public Builder isIndepMovie(boolean isIndependent){
            this.isIndependent=isIndependent;
            return this;
        }

        public Builder MovieCast(Person cast){
            this.cast.add(cast);
            return this;
        }
        
        public Builder MovieLocations(Place locations){
            this.locations.add(locations);
            return this;
        }

        public Builder MovieLanguages(String languages){
            this.languages.add(languages);
            return this;
        }

        public Builder MovieGenres(String genre){
            this.genres.add(genre);
            return this;
        }

        public Movie Moviebuild(){
            return new Movie(this);
        }

    }

    private Movie(Builder builder){
        this.title = builder.title;
        this.year = builder.year;
        this.director = builder.director;
        this.writer = builder.writer;
        this.cast = builder.cast;
        this.locations=builder.locations;
        this.languages=builder.languages;
        this.genres=builder.genres;
        this.isTelevision= builder.isTelevision;
        this.isNetflix = builder.isNetflix;
        this.isIndependent=builder.isIndependent;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", director=" + director +
                ", writer=" + writer +
                ", cast=" + cast +
                ", locations=" + locations +
                ", languages=" + languages +
                ", genres=" + genres +
                ", isTelevision=" + isTelevision +
                ", isNetflix=" + isNetflix +
                ", isIndependent=" + isIndependent +
                '}';
    }
}
