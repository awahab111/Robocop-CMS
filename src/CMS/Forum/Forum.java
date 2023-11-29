package CMS.Forum;

import java.util.ArrayList;

import CMS.DBHandler.ForumHandler;

public class Forum {
    private ArrayList<Post> posts;
    private int postCount;

    ForumHandler forumHandler = new ForumHandler();

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
