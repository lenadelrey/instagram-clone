package by.instagram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private long id;
    private String description;
    private User user;
    private List<Comment> commentList = new ArrayList<>();
    private long likesCount;
    private List<Like> likes = new ArrayList<>();
}
