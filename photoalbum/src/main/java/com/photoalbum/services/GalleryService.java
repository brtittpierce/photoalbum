package com.photoalbum.services;

import java.util.Map;

public interface GalleryService {
	public Map<Long, String> findGallery(long requestedAlbumId);
}
