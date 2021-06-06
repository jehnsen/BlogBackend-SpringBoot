package com.core.blogbackend.post;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )

    private Long id;
    private String title;
    private Long authorId;
    private String slugTitle;
    private LocalDate dateCreated;
    private Integer status;

    public Post(){

    }
    public Post(Long id, String title, Long authorId, String slugTitle, LocalDate dateCreated, Integer status) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.slugTitle = slugTitle;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public Post(String title, Long authorId, String slugTitle, LocalDate dateCreated, Integer status) {
        this.title = title;
        this.authorId = authorId;
        this.slugTitle = slugTitle;
        this.dateCreated = dateCreated;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getSlugTitle() {
        return slugTitle;
    }

    public void setSlugTitle(String slugTitle) {
        this.slugTitle = slugTitle;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
