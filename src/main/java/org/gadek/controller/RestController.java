package org.gadek.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.gadek.dao.MovieDAO;
import org.gadek.model.Comment;
import org.gadek.model.Movie;
import org.gadek.repository.CommentRepository;
import org.gadek.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Controller
public class RestController {

	@Autowired 
	private MovieRepository movieRepository;
	@Autowired
    private MovieDAO movieDAO;	
	@Autowired
    private CommentRepository commentRepository;	
	
	//LIST ALL MOVIE
    @GetMapping(value = "/movie")
    public String movieInfo(Model model, Principal principal) {  
		List<Movie> list = movieDAO.getMovie();
        model.addAttribute("movie", list);
//        List<Movie> test = new ArrayList<>();
//        model.addAttribute("test", test);
//        List<Movie> tests = movieRepository.findAll();
//        model.addAttribute("tests", tests);
        
        return "movie";
    }
    	
	//DELETE 
	@RequestMapping(value = "/movie/delete/{id}")
	public String deleteMovie(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		movieRepository.deleteById(id);
		redirectAttrs.addFlashAttribute("message", "Movie was deleted");
	    return "redirect:/movie";
	}
	
	//CREATE
	@RequestMapping(value = "/movie/create")
	public String createMovie(Model model) {
		model.addAttribute("movie", new Movie());
	    return "movieForm";
	}
	
	//SAVE
	@RequestMapping( value = "/movie/save", method = RequestMethod.POST )
	public String save(@Valid Movie movie, BindingResult bindingResult, Model model) {
		
		if ( bindingResult.hasErrors() ) {
			return "movieForm";
		}
		else {
			movieRepository.save(movie);
			return "redirect:/movie"; 
		}
	
	}
	//EDIT
	@RequestMapping(value = "/movie/edit/{id}")
	public String editMovie(@PathVariable Long id, Model model){
		model.addAttribute("movie", movieRepository.findById(id));
		return "movieForm";
	}
	
	//SHOW
	@RequestMapping(value = "/movie/view/{id}")
	public String viewMovie(@PathVariable Long id, Model model){
		model.addAttribute("movie", movieRepository.findById(id));
		model.addAttribute("comment",commentRepository.findByMovieId(id));
		return "movieView";
	}
}
