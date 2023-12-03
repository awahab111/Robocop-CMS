package CMS.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import CMS.Forum.Post;

public class ForumHandler {
    public List<Post> getAllPosts() {

        Database db = Database.getInstance();


        List<Post> posts = new ArrayList<>();
        try {
            java.sql.Connection conn = db.getconn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from post inner join user_login on post.user_id = user_login.userid order by pub_date desc, pub_time desc");

            while (rs.next()) {
                Post post = new Post();
                post.setAuthor(rs.getString("username"));
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
