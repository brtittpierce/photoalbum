package com.photoalbum.photoalbum;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.photoalbum.services.GalleryService; 

@SpringBootTest	
class PhotoalbumApplicationTests {
	@Autowired
	private GalleryService galleryService;
	
private GalleryService galleryServiceTests;
	
	  @Test public void contextLoads() { }
	  
	  @Test public void testFindGallery() { Map<Long, String> galleryMap =
	  galleryService.findGallery(3); assertTrue(galleryMap.size() == 50); }
	  
	  @Test public void testGalleryNotFound() { Map<Long, String> galleryMap =
	  galleryService.findGallery(999); assertTrue(galleryMap.size() == 0); }
	 
}
