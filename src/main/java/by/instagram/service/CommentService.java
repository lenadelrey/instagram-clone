package by.instagram.service;

import by.instagram.entity.Comment;
import by.instagram.entity.Like;
import by.instagram.entity.User;
import by.instagram.storage.CommentStorage;


import java.util.List;

public class CommentService {

    private final CommentStorage commentStorage = new CommentStorage();

    public void save(Comment comment) {
        commentStorage.save(comment);
    }

    public void like(long id, User user) {
        Comment byId = commentStorage.findById(id);
        byId.setLikesCount(byId.getLikesCount() + 1);
        byId.getLikes().add(new Like(0, user));
    }

    public void unLike(long id, User user) {
        Comment byId = commentStorage.findById(id);
        byId.setLikesCount(byId.getLikesCount() - 1);
        for (Like like : byId.getLikes()) {
            if (like.getUser().equals(user)) {
                byId.getLikes().remove(like);
                break;
            }
        }
    }

    public Comment findById(long id) {
        if (commentStorage.contains(id)) {
            return commentStorage.findById(id);
        }
        return null;
    }

    public List<Comment> findAllByUser(User user) {
        if (commentStorage.contains(user)) {
            return commentStorage.findAllByUser(user);
        }
        return null;
    }

    public List<Comment> getAll() {
        return commentStorage.getAll();
    }
}
