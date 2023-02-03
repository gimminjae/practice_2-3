package com.practice.post.entity;

import com.practice.post.dto.PostDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public PostDto toDto() {
        return PostDto.builder()
                .id(this.getId())
                .title(this.getTitle())
                .content(this.getContent())
                .createDateTime(this.getCreateDateTime())
                .updateDateTime(this.getUpdateDateTime())
                .build();
    }
}
