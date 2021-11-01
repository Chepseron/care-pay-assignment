package com.amon.blog.springblog;

import com.amon.blog.springblog.model.Post;
import com.amon.blog.springblog.model.User;
import com.amon.blog.springblog.repository.PostRepository;
import com.amon.blog.springblog.repository.UserRepository;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringblogApplicationTests {

    UserRepository userRepo;
    PostRepository postrepo;

    @Test
    void contextLoads() {
    }

    @Test
    public void userCreate() {
        User user = new User();
        user.setEmail("testemail@email.com");
        user.setPassword("password");
        user.setUsername("testUsername");
        userRepo.save(user);
        Assertions.assertNotNull(userRepo.findByUsername("testUsername"));

    }

    @Test
    public void postCreate() {
        Post post = new Post();
        post.setContent("test content");
        post.setId(1);
        post.setTitle("test title");
        post.setCreatedOn(new java.util.Date());
        post.setUpdatedOn(new java.util.Date());
        postrepo.save(post);
        Assertions.assertNotNull(postrepo.findById(Long.valueOf(1)));

    }

    public void testReadAllPosts() {
        List<Post> posts = postrepo.findAll();
        assertThat(posts, not(IsEmptyCollection.empty()));
    }

    public void testReadAllUsers() {
        List<User> users = userRepo.findAll();
        assertThat(users, not(IsEmptyCollection.empty()));
    }

}
