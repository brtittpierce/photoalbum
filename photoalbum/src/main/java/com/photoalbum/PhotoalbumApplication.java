package com.photoalbum;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.photoalbum.services.GalleryService;

@SpringBootApplication
public class PhotoalbumApplication  implements ApplicationRunner{
	@Autowired
	private GalleryService galleryService;
	
	public static void main(String[] args) {
    	System.setProperty("spring.profiles.default", "dev");
        SpringApplication.run(PhotoalbumApplication.class, args);
        
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("args = " + args);
		
		if (args.getSourceArgs().length > 1) {
			System.out.println("This program only uses one argument.");
			return;
		}
		
		if (args.getSourceArgs().length == 0) {
			System.out.println("This program requires an argument for the Gallery Id.");
			return;
		}
		
		String albumStr = args.getSourceArgs()[0];
		long album = 0;
		try {
			album = Long.parseLong(albumStr);
		} catch (NumberFormatException nfe) {
			System.out.println("The album ID must be numeric.");
		}
		
		System.out.println("Photo-album " + args.getSourceArgs()[0]);
		Map <Long, String> gallery = galleryService.findGallery(album);
		
		gallery.forEach((k,v)->{
			System.out.println("[" + k + "] " + v);
		});
//		
//	
//		for(String arg:args.getSourceArgs()   ) {
//            System.out.println(arg);
//        }
	}
	private void displayAlbum() {
		
		
	}
}