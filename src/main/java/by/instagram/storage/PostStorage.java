package by.instagram.storage;

import by.instagram.entity.Comment;
import by.instagram.entity.Post;
import by.instagram.entity.User;

import java.util.ArrayList;
import java.util.List;

public class PostStorage {

    private static List<Post> posts = new ArrayList<>();
    private long count = 0;


    public void save(Post post) {
        posts.add(post);
        post.setId(count++);
    }

    public void addComment(long id, Comment comment){
        for (Post post : posts) {
            if (post.getId() == id) {
                post.getCommentList().add(comment);
                break;
            }
        }
    }

    public List<Comment> getAllComments(long id) {
        List<Comment> comments = new ArrayList<>();
        for (Post post : posts) {
            if(post.getId() == id) {
                comments.addAll(post.getCommentList());
            }
        }
        return comments;
    }

    public boolean deleteById(long id) {
        for (Post post : posts) {
            if(post.getId() == id) {
                posts.remove(post);
                return true;
            }
        }
        return false;
    }

    public boolean editPost(long id, String description) {
        for (Post post : posts) {
            if(post.getId() == id) {
                post.setDescription(description);
                return true;
            }
        }
        return false;
    }

    public Post findById(long id) {
        for (Post post : posts) {
            if(post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List<Post> findAllByUser(User user) {
        List<Post> postList = new ArrayList<>();
        for (Post post : posts) {
            if(post.getUser().equals(user)) {
                postList.add(post);
            }
        }
        return postList;
    }

    public List<Post> getAll() {
        return posts;
    }

    public boolean contains(long id) {
        for (Post post : posts) {
            if(post.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(User user) {
        for (Post post : posts) {
            if(post.getUser().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Post post) {
        for (Post post1 : posts) {
            if(post.equals(post1)) {
                return true;
            }
        }
        return false;
    }
}
