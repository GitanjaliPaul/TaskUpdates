package com.task.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsk.service.creation;
@RestController
public class FolderActions {
@Autowired
creation create;
	@GetMapping(value ="/create")
	public String createfolderApi() {
		String result=creation.createfolder();
		return result;
		
	}
	
	@GetMapping(value ="/delete")
	public String deletefolderApi() throws IOException {
		String result=creation.deletefolder();
		return result;
		
	}
}

