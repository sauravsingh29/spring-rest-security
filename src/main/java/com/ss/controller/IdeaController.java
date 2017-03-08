package com.ss.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.model.Idea;
import com.ss.repo.IdeaRepository;

@RestController
@RequestMapping("/api/ideas")
public class IdeaController {
	@Autowired
	private IdeaRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Idea> findAll() {
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Idea add(@RequestBody Idea idea) {
		Idea model = new Idea();
		model.setCreatedAt(new Date());
		model.setTitle(idea.getTitle());
		model.setDescription(idea.getDescription());
		return repository.saveAndFlush(model);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Idea findOne(@PathVariable long id) {
		return repository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Idea update(@PathVariable long id, @RequestBody Idea idea) {
		Idea model = repository.findOne(id);
		if (model != null) {
			model.setTitle(idea.getTitle());
			model.setDescription(idea.getDescription());
			return repository.saveAndFlush(model);
		}
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		repository.delete(id);
	}
}
