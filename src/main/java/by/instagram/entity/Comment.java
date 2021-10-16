package by.instagram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private long id;
    private String text;
    private User user;
    private long likesCount;
    private List<Like> likes = new ArrayList<>();

    public Comment(long id, String text, User user) {
        this.id = id;
        this.text = text;
        this.user = user;
    }
}
