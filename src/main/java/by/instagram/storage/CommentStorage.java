package by.instagram.storage;

import by.instagram.entity.Comment;
import by.instagram.entity.User;

import java.util.ArrayList;
import java.util.List;

public class CommentStorage {

    public static List<Comment> comments = new ArrayList<>();
    private long count = 0;

    public void save(Comment comment) {
        comments.add(comment);
        comment.setId(count++);
    }

    public Comment findById(long id) {
        for (Comment comment : comments) {
            if (comment.getId() == id) {
                return comment;
            }
        }
        return null;
    }

    public List<Comment> findAllByUser(User user) {
        List<Comment> commentList = new ArrayList<>();
        for (Comment comment : comments) {
            if(comment.getUser().equals(user)) {
                commentList.add(comment);
            }
        }
        return commentList;
    }

    public List<Comment> getAll() {
        return comments;
    }

    public boolean contains(long id) {
        for (Comment comment : comments) {
            if(comment.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(User user) {
        for (Comment comment : comments) {
            if(comment.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }
}
