package CMS.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import CMS.Forum.Post;

public class ForumHandler {
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        Database db = new Database();
        try {
            java.sql.Connection conn = db.getconn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM post");

            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("post_id"));
                post.setContent(rs.getString("description"));
                post.setDate(rs.getString("pub_date"));
                post.setTime(rs.getString("pub_time"));
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }
}
