package com.example.testCopilot.customInstructions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * VideoSearchResponse - Data model for YouTube video search response
 *
 * Creation Date: 2024-01-15
 * Author: selvakumar24896
 *
 * This class represents the response structure from YouTube API containing video search results.
 * Uses Lombok annotations to reduce boilerplate code for getters, setters, and constructors.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoSearchResponse {

    @JsonProperty("items")
    private List<VideoItem> videoItems;

    @JsonProperty("pageInfo")
    private PageInfo pageInfo;

    /**
     * VideoItem - Represents individual video information
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VideoItem {
        @JsonProperty("id")
        private VideoId id;

        @JsonProperty("snippet")
        private VideoSnippet snippet;
    }

    /**
     * VideoId - Contains video identifier
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VideoId {
        @JsonProperty("videoId")
        private String videoId;
    }

    /**
     * VideoSnippet - Contains video metadata
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VideoSnippet {
        @JsonProperty("title")
        private String title;

        @JsonProperty("description")
        private String description;

        @JsonProperty("channelTitle")
        private String channelTitle;

        @JsonProperty("publishedAt")
        private String publishedAt;

        @JsonProperty("thumbnails")
        private Thumbnails thumbnails;
    }

    /**
     * Thumbnails - Contains video thumbnail images
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Thumbnails {
        @JsonProperty("default")
        private Thumbnail defaultThumbnail;

        @JsonProperty("medium")
        private Thumbnail medium;
    }

    /**
     * Thumbnail - Contains thumbnail URL and dimensions
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Thumbnail {
        @JsonProperty("url")
        private String url;

        @JsonProperty("width")
        private Integer width;

        @JsonProperty("height")
        private Integer height;
    }

    /**
     * PageInfo - Contains pagination information
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PageInfo {
        @JsonProperty("totalResults")
        private Integer totalResults;

        @JsonProperty("resultsPerPage")
        private Integer resultsPerPage;
    }
}
