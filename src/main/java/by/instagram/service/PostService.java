package by.instagram.service;

import by.instagram.entity.Comment;
import by.instagram.entity.Like;
import by.instagram.entity.Post;
import by.instagram.entity.User;
import by.instagram.storage.CommentStorage;
import by.instagram.storage.PostStorage;
import by.instagram.storage.UserStorage;

import java.util.ArrayList;
import java.util.List;

public class PostService {

    private final PostStorage postStorage = new PostStorage();
    private final CommentStorage commentStorage = new CommentStorage();
    private final UserStorage userStorage = new UserStorage();

    public boolean save(Post post) {
        if(postStorage.contains(post)) {
            return false;
        }
        postStorage.save(post);
        return true;
    }

    public void like(long id, User user) {
        Post byId = postStorage.findById(id);
        byId.setLikesCount(byId.getLikesCount() + 1);
        byId.getLikes().add(new Like(0, user));
    }

    public void unLike(long id, User user){
        Post byId = postStorage.findById(id);
        byId.setLikesCount(byId.getLikesCount() - 1);
        for (Like like : byId.getLikes()) {
            if (like.getUser().equals(user)){
                byId.getLikes().remove(like);
                break;
            }
        }
    }

    public List<Like> getAllLikes(long id) {
        Post byId = postStorage.findById(id);
        return new ArrayList<>(byId.getLikes());
    }

    public void addComment(long id, String text, User user){
        Comment comment = new Comment(0, text, user);
        commentStorage.save(comment);
        postStorage.addComment(id, comment);
    }

    public List<Comment> getAllComments(long id) {
        if(postStorage.contains(id)) {
            return postStorage.getAllComments(id);
        }
        return null;
    }

    public boolean deleteById(long id) {
        if(postStorage.contains(id)) {
            return postStorage.deleteById(id);
        }
        return false;
    }

    public boolean editPost(long id, String description) {
        if(postStorage.contains(id)) {
            return postStorage.editPost(id, description);
        }
        return false;
    }

    public Post findById(long id) {
        if(postStorage.contains(id)) {
            return postStorage.findById(id);
        }
        return null;
    }

    public List<Post> findAllByUser(User user) {
        return postStorage.findAllByUser(user);
    }

    public List<Post> getAll() {
        return postStorage.getAll();
    }

}
