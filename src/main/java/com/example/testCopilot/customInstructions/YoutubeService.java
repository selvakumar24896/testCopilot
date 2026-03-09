package com.example.testCopilot.customInstructions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * YoutubeService - Service layer for YouTube video search operations
 *
 * Creation Date: 2024-01-15
 * Author: selvakumar24896
 *
 * This service handles business logic for searching YouTube videos using YouTube Data API.
 * It communicates with YouTube API and processes the response.
 */
@Service
public class YoutubeService {

    @Value("${youtube.api.key}")
    private String youtubeApiKey;

    @Value("${youtube.api.url:https://www.googleapis.com/youtube/v3}")
    private String youtubeApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Search YouTube videos based on search query
     *
     * @param searchQuery the search input string
     * @param maxResults maximum number of results to return
     * @return VideoSearchResponse containing list of videos
     * @throws Exception if API call fails or response is invalid
     */
    public VideoSearchResponse searchVideos(String searchQuery, Integer maxResults) throws Exception {

        // Validate input parameters
        if (searchQuery == null || searchQuery.trim().isEmpty()) {
            throw new IllegalArgumentException("Search query cannot be empty");
        }

        if (maxResults <= 0 || maxResults > 50) {
            maxResults = 10; // Set default if invalid
        }

        try {
            // Build YouTube API URL with query parameters
            String apiUrl = buildApiUrl(searchQuery, maxResults);

            // Call YouTube API and retrieve results
            VideoSearchResponse response = restTemplate.getForObject(apiUrl, VideoSearchResponse.class);

            if (response == null) {
                throw new Exception("No response received from YouTube API");
            }

            return response;
        } catch (Exception exception) {
            throw new Exception("Failed to search YouTube videos: " + exception.getMessage(), exception);
        }
    }

    /**
     * Build YouTube API URL with query parameters
     *
     * @param searchQuery the search input string
     * @param maxResults maximum number of results
     * @return formatted API URL string
     */
    private String buildApiUrl(String searchQuery, Integer maxResults) {
        return youtubeApiUrl + "/search?part=snippet&q=" + searchQuery
                + "&maxResults=" + maxResults
                + "&key=" + youtubeApiKey;
    }
}
