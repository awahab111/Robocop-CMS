package CMS.Forum;

import DBHandler.PostHandler;

public class Post {
    private int id;  
    private String content;
    private String author;
    private String date;
    private String time;
    private int likes;

    PostHandler postHandler = new PostHandler();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String post_time(){
        return date + " " + time;
    }

    public void createPost(String content, int userid){
        postHandler.createPost(content, userid);
    }
}

