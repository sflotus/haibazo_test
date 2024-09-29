package org.c07.haibazo_test.dto;

import java.time.LocalDateTime;

public class PostDto {
    private String content;
    private LocalDateTime createAt;

    public PostDto() {
    }

    public PostDto(String content, LocalDateTime createAt) {
        this.content = content;
        this.createAt = createAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
