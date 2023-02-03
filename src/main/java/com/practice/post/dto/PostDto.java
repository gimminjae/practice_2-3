package com.practice.post.dto;

import com.practice.post.entity.Post;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private long id;
    private String title;
    private String content;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public Post toEntity() {
        return Post.builder()
                .id(this.getId())
                .title(this.getTitle())
                .content(this.getContent())
                .createDateTime(this.getCreateDateTime())
                .updateDateTime(this.getUpdateDateTime())
                .build();
    }
}
