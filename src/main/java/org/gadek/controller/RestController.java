package org.gadek.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.gadek.dao.MovieDAO;
import org.gadek.model.Comment;
import org.gadek.model.Movie;
import org.gadek.repository.CommentRepository;
import org.gadek.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RestController {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private MovieDAO movieDAO;
	@Autowired
	private CommentRepository commentRepository;
	
	@PersistenceContext
	EntityManager entityManager;
	
	Logger logger = LoggerFactory.getLogger(RestController.class);

	// LIST ALL MOVIE
	@GetMapping(value = "/movie")
	public String movieInfo(Model model, Principal principal) {
		List<Movie> list = movieDAO.getMovie();
		model.addAttribute("movie", list);
		return "movie";
	}

	// DELETE
	@RequestMapping(value = "/movie/delete/{id}")
	public String deleteMovie(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		movieRepository.deleteById(id);
		redirectAttrs.addFlashAttribute("message", "Movie was deleted");
		return "redirect:/movie";
	}

	// CREATE
	@RequestMapping(value = "/movie/create")
	public String createMovie(Model model) {
		model.addAttribute("movie", new Movie());
		return "movieForm";
	}

	// SAVE movie
	@RequestMapping(value = "/movie/save", method = RequestMethod.POST)
	public String save(@Valid Movie movie, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "movieForm";
		} else {
			movieRepository.save(movie);
			return "redirect:/movie";
		}
	}

	// EDIT movie
	@RequestMapping(value = "/movie/edit/{id}")
	public String editMovie(@PathVariable Long id, Model model) {
		model.addAttribute("movie", movieRepository.findById(id));
		return "movieForm";
	}

	// SHOW movie comment
	@RequestMapping(value = "/movie/view/{id}")
	public String viewMovie(@PathVariable Long id, Model model) {
		model.addAttribute("movie", movieRepository.findById(id));
		model.addAttribute("comment", commentRepository.findByMovieId(id));
		model.addAttribute("new",movieRepository.findById(id));
		return "movieView";
	}
	
	// save comment
//	@RequestMapping(value = "/movie/view/{id}/{body}", method = RequestMethod.GET)
//	public String addComment(Model model, @PathVariable String body, @PathVariable Long id) {
//		String title= "Tytuł";
//		logger.info("Pokaz id " + id);
//		logger.info("Pokaz body " + body);
//		//commentRepository.save(entity);
//		return "welcomePage";
//	}
	
	@RequestMapping(value = "/movie/view/{movieId}/{body}", method = RequestMethod.POST)
	public String addComment(Model model, @PathVariable String body, @PathVariable Long movieId) {
		String title= "Tytuł";
		logger.info("Pokaz id " + movieId);
		logger.info("Pokaz body " + body);
		
		Comment comm = new Comment() ;
		
		Optional<Movie> mov = movieRepository.findById(movieId);
		
		if(mov.isPresent())
		{
			Movie movies = mov.get();
			comm.setBody(body);
			comm.setTitle(title);
			comm.setUserId(1L);
			comm.setCommentDate("2006-02-02");
			comm.setMovie(movies);
			commentRepository.save(comm);
		}

			
		return "redirect:/movie";
	}

}
