package labs.lab10;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class MoviesStats {

	/**
	 * Given a Stream of Movies, return the number of movies in the Stream
	 */
	public static long problem1_countMovies(Stream<Movie> movies) {
		long movieCount = movies.count();
		System.out.println(movieCount);
		return movieCount; // FIX ME
	}
	
	/**
	 * Given a Stream of Movies and a string, return the number of movies
	 * in the Stream with a title that starts with the given string (case-sensitive)
	 */
	public static long problem2_countMoviesThatStartWith(Stream<Movie> movies, String startsWith) {
		long matchCount = movies.filter(m -> m.getTitle().equals(startsWith)).count();
		System.out.println(matchCount);
		return matchCount;
	}
	
	/**
	 * Given a Stream of Movies and a string, return the titles of movies
	 * in the Stream that contain the given string (NOT case-sensitive), separated by ", "
	 */
	public static String problem3_getMoviesThatContainString(Stream<Movie> movies, String str) {
		String titles = "";
		titles += movies.filter(m -> m.getTitle().contains(str));
		return titles.substring(0,titles.length()-1); // FIX ME
	}
	
	/**
	 * Write a method that counts how many movies were made in each year, given a (inclusive)
	 * range of years. Your method should grab all movies from the stream that were made 
	 * within the given range of years, and group them by the year they were
	 * made. Return a Map<Integer, Long>, that maps years to the number of movies made
	 * in that year. 
	 * 
	 * This map should be sorted in ascending order of year.
	 * 
	 * If the stream is empty, return an empty map.
	 */
	public static Map<Integer, Long> problem4_countMoviesByYear(Stream<Movie> movies, int minYear,
			int maxYear) {
		// FILL IN
		return null; // FIX ME
	}
	
	/**
	 * Given a Stream of Movies and the name of an actor, return a list of movies that 
	 * actor has been in
	 */
	public static List<Movie> problem5_getMoviesWithActor(Stream<Movie> movies, String actorName) {
		// FILL IN
		return null; // FIX ME	
	}
	
	/**
	 * Given a Stream of Movies and the name of a director, return a list of movies that 
	 * person has directed
	 */
	public static List<Movie> problem5_getMoviesDirectedBy(Stream<Movie> movies, String directorName) {
		// FILL IN
		return null; // FIX ME	
	}
	
	/**
	 * Given a Stream of Movies and the name of a producer, return a list of movies that 
	 * person has produced
	 */
	public static List<Movie> problem5_getMoviesProducedBy(Stream<Movie> movies, String producerName) {
		// FILL IN
		return null; // FIX ME	
	}
	
	/**
	 * Returns how many distinct actors are represented in given Stream of Movies
	 */
	public static long problem6_countActors(Stream<Movie> movies) {
		// FILL IN
		return -1; // FIX ME	
	}
	
	/**
	 * Returns how many distinct directors are represented in given Stream of Movies
	 */
	public static long problem6_countDirectors(Stream<Movie> movies) {
		// FILL IN
		return -1; // FIX ME
	}
	
	/**
	 * Returns how many distinct producers are represented in given Stream of Movies
	 */
	public static long problem6_countProducers(Stream<Movie> movies) {
		// FILL IN
		return -1; // FIX ME
	}
	
	/**
	 * Returns the average number of actors in each movie in given Stream of Movies,
	 * or 0 if the stream is empty
	 */
	public static double problem7_averageNumActors(Stream<Movie> movies) {
		// FILL IN
		return -1; // FIX ME
	}
	
	/**
	 * Returns the average number of directors of each movie in given Stream of Movies,
	 * or 0 if the stream is empty
	 */
	public static double problem7_averageNumDirectors(Stream<Movie> movies) {
		// FILL IN
		return -1; // FIX ME
	}
	
	/**
	 * Returns the average number of producers of each movie in given Stream of Movies,
	 * or 0 if the stream is empty
	 */
	public static double problem7_averageNumProducers(Stream<Movie> movies) {
		// FILL IN
		return -1; // FIX ME
	}
	
	/**
	 * Returns a list of movies with exactly n words in the title, using .split("\\s+"))
	 * to split a title into words
	 */
	public static List<Movie> problem8_moviesWithNWordsInTitle(Stream<Movie> movies, int n) {
		// FILL IN
		return null; // FIX ME
	}
	
	/**
	 * Returns the oldest movie with a non-zero year in the Stream (use min method of 
	 * Stream class)
	 */
	public static Optional<Movie> problem9_oldestMovie(Stream<Movie> movies) {
		// FILL IN
		return null; // FIX ME
	}
	
	/**
	 * Returns the newest movie in the Stream (use max method of Stream class)
	 */
	public static Optional<Movie> problem10_newestMovie(Stream<Movie> movies) {
		// FILL IN
		return null; // FIX ME
	}
	
	public static void main(String[] args) {
		List<Movie> moviesList = MoviesReader.readMovies("C:\\Users\\coope\\eclipse-workspace\\90967488_lab10\\src\\labs\\lab10\\movies.txt");
		problem1_countMovies(moviesList.stream()); // returns 23000
		
		problem2_countMoviesThatStartWith(moviesList.stream(), "Nobody "); // returns 4
		
		System.out.println(problem3_getMoviesThatContainString(moviesList.stream(), "Robert")); 
		// the above returns: "The Assassination of Jesse James by the Coward Robert Ford, The Last Confederate: The Story of Robert Adams, FDR: Robert Vaughn One-Man Show, After Roberto, Debating Robert Lee, Bob Roberts, Mister Roberts, The Secret Passion of Robert Clayton, Master Spy: The Robert Hanssen Story"
		/*
		for (Movie movie: moviesList) {
			System.out.println(movie);
		}
		*/
	}
}