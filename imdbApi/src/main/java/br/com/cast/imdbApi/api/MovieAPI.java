package br.com.cast.imdbApi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.imdbApi.business.BusinessMovie;
import br.com.cast.imdbApi.dto.MovieDTO;

@RestController
@RequestMapping(path="/movie")
public class MovieAPI {
	
	
	@Autowired
	private BusinessMovie businessMovie;
	
	@GetMapping()
	public List<MovieDTO> returnMovies(){
		return businessMovie.returnMovies();
	}
	
	@GetMapping("/{nomeFilme}")
	public MovieDTO returnMovie(@PathVariable("nomeFilme") String nomeFilme){
		return businessMovie.returnMovie(nomeFilme);
	}
	
	@PostMapping()
	public void insertMovie(@RequestBody MovieDTO dto) {
		businessMovie.insert(dto);
	}
	
	@DeleteMapping("/{nomeFilme}")
	public void deleteMovie(@PathVariable("nomeFilme") String nomeFilme) {
		businessMovie.delete(nomeFilme);
	}
	
	@PutMapping()
	public void updateMovie(@RequestBody MovieDTO dto) {
		businessMovie.update(dto);
	}
	
}
