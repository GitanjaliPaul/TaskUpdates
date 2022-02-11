package com.tsk.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.controller.FolderActions;

@Service
public class creation {

	@Autowired
	FolderActions folderact;

//Creation of random String of given length 10
	public static String StringGenerator() {
		String p = "";
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		System.out.println(generatedString);
		return generatedString;
	}

	static final String FolderName = StringGenerator();
	private static final String FolderNamee = null;

	public static String createfolder() {
		try {
			String FolderNamee = FolderName;
			Path p = Paths.get("/Users/Geet.ja/Documents/" + FolderNamee);
			System.out.println(p);
			System.out.println(FolderName);
			if (Files.exists(p)) {
				System.out.println("Directory already exists");
				// Creating subfolder
				Path p1 = Paths.get("/Users/Geet.ja/Documents/" + FolderNamee + "/foldername");
				Files.createDirectory(p1);
			} else {
				Files.createDirectory(p);
				System.out.println("Directory has been created at " + p.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Directory created";
	}

	public static String deletefolder() throws IOException {
		Path p2 = Paths.get("/Users/Geet.teja/Documents/" + FolderNamee + "/foldername");
		if (Files.exists(p2)) {

			Files.deleteIfExists(p2);

		}
		return "Directory deleted";
	}

}
