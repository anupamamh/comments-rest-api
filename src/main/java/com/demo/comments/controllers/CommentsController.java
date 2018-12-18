package com.demo.comments.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.comments.models.Comments;
import com.demo.comments.services.CommentsService;

@RestController
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
	private CommentsService commentsService;

	// To view all the comments
	@RequestMapping(method = RequestMethod.GET)
	public List<Comments> viewAllComments() {

		return commentsService.viewAllComments();
	}

	// To add a new comment
	@RequestMapping(method = RequestMethod.POST)
	public Comments addComment(@Valid @RequestBody Comments comments) {
		commentsService.addComment(comments);
		return comments;
	}

	// To delete a comment given submission Id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteComment(@PathVariable("id") String submissionId) {
		System.out.println(submissionId);
		commentsService.deleteComment(submissionId);
	}

}
