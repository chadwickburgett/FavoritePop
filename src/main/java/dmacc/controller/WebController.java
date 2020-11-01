package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Pop;
import dmacc.repository.PopRepository;

@Controller
public class WebController {
	@Autowired
	PopRepository repo;
	
	@GetMapping({ "/", "viewAll" })
	public String viewAllPops(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewPop(model);
		}
		
		model.addAttribute("pop", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputPop")
	public String addNewPop(Model model) {
		Pop p = new Pop();
		model.addAttribute("newPop", p);
		return "input";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdatePop(@PathVariable("id") long id, Model model) {
		Pop p = repo.findById(id).orElse(null);
		model.addAttribute("newPop", p);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String revisePop(Pop p, Model model) {
		repo.save(p);
		return viewAllPops(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Pop p = repo.findById(id).orElse(null);
		repo.delete(p);
		return viewAllPops(model);
	}
	
}