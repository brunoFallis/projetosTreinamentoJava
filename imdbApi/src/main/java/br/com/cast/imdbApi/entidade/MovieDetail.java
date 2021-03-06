package br.com.cast.imdbApi.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cast.imdbApi.dto.MovieDetailDTO;

@Entity
@Table(name="detail", schema="movie")
public class MovieDetail {

	@Id
	private String imdbid;
	private String released;
	private String genre;
	private String director;
	private String plot;

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public void fromMovieDetailDTO(MovieDetailDTO movieDetailDTO) {
		this.setDirector(movieDetailDTO.getDirector());
		this.setGenre(movieDetailDTO.getGenre());
		this.setImdbid(movieDetailDTO.getImdbid());
		this.setPlot(movieDetailDTO.getPlot());
		this.setReleased(movieDetailDTO.getReleased());
	}
	
}
