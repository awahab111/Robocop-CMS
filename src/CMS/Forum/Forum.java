package CMS.Forum;

import java.util.ArrayList;

import DBHandler.ForumHandler;

public class Forum {
    private static Forum instance = null;
    private ArrayList<Post> posts;
    private int postCount;

    ForumHandler forumHandler = new ForumHandler();

    public static Forum getInstance() {
        if (instance == null) {
            instance = new Forum();
        }
        return instance;
    }

    private Forum() {
        posts = new ArrayList<Post>();
        postCount = 0;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public void getAllPosts() {
        posts = (ArrayList<Post>) forumHandler.getAllPosts();
    }
}
