package io.javabrains.moviecatalogservice.model;

public class Rating {
	
	private String movieId;
	private int raiting;
	
	public Rating(){}
	
	public Rating(String movieId, int raiting) {		
		this.movieId = movieId;
		this.raiting = raiting;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRaiting() {
		return raiting;
	}

	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}
	
	

}
