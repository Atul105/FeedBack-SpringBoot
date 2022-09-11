package magar.atul.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import magar.atul.webapp.entity.FeedBack;
import magar.atul.webapp.exception.FeedBackNotFound;
import magar.atul.webapp.exception.InvalidFeedBackException;
import magar.atul.webapp.repository.FeedBackRepository;

@RestController
public class FeedBackController {
	
	@Autowired
	FeedBackRepository feedBackRepository;
	
	List<FeedBack> feedBacks = new ArrayList<FeedBack>();

	//Checking json format
//	@RequestMapping(value="/feedBacks", method=RequestMethod.GET)
//	public List<FeedBack> getFeedBacks() {
//		addDefaultData();
//		return feedBacks;
//	}
//	private void addDefaultData() {
//
//		feedBacks.add(new FeedBack("Atul Magar", "atul.magar0@gmail.com", "the system is goood"));
//
//	}
	//adding html(front page) page
	@RequestMapping(value = "../", method = RequestMethod.GET)
	public String index() {
		return "index.html";
	}
	
	//list feedback
	@RequestMapping(value="/feedBacks", method=RequestMethod.GET)
	public List<FeedBack> getFeedBacks() {
		List<FeedBack> feedBackList = feedBackRepository.findAll();
		if(feedBackList.isEmpty()) {
			throw new FeedBackNotFound("FeedBack Not Found,List is empty");
		}
		return feedBackList;
	}
	
	//add feedback
	@RequestMapping(value = "/feedBacks", method = RequestMethod.POST)
	public FeedBack addFeedBacks(@RequestBody(required = false) FeedBack feedback) {
		if (feedback != null) {
			if (feedback.getName() != null) {
				return feedBackRepository.save(feedback);
			} else {
				throw new InvalidFeedBackException("required name is missing");
			}
		}

		throw new InvalidFeedBackException("required fileds are missing");
	}
	
}
