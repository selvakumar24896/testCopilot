package com.example.testCopilot.customInstructions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * YoutubeController - REST API controller for YouTube video search functionality
 *
 * Creation Date: 2024-01-15
 * Author: selvakumar24896
 *
 * This controller handles HTTP requests for searching YouTube videos based on user input.
 * It provides endpoints to retrieve video search results and manages request/response handling.
 */
@RestController
@RequestMapping("/api/youtube")
public class YoutubeController {

    @Autowired
    private YoutubeService youtubeService;

    /**
     * Search YouTube videos based on search query string
     *
     * @param searchQuery the search input string provided by user
     * @param maxResults optional parameter to limit number of results (default: 10)
     * @return ResponseEntity containing video search results
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchVideos(
            @RequestParam(name = "q") String searchQuery,
            @RequestParam(name = "maxResults", defaultValue = "10") Integer maxResults) {

        // Validate search query input
        if (searchQuery == null || searchQuery.trim().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Search query cannot be empty");
        }

        try {
            VideoSearchResponse response = youtubeService.searchVideos(searchQuery, maxResults);
            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error searching YouTube videos: " + exception.getMessage());
        }
    }
}