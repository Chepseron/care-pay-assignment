/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.blog.springblog.security;

import com.amon.blog.springblog.dto.PostDto;
import com.amon.blog.springblog.exception.PostNotFoundException;
import com.amon.blog.springblog.model.Post;
import com.amon.blog.springblog.model.User;
import com.amon.blog.springblog.repository.PostRepository;
import com.amon.blog.springblog.service.AuthService;
import com.blog.io.blog.exception.ResourceNotFoundException;
import java.util.List;
import java.util.function.Supplier;
import static java.util.stream.Collectors.toList;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.RequestEntity.post;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tech
 */
@Service
public class PostService {

    @Autowired
    private AuthService authService;

    @Autowired
    private PostRepository postRepository;

    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    public void createPost(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);
        postRepository.save(post);
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getUsername());
        return postDto;

    }

    private Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setCreatedOn(new java.util.Date());
        post.setUpdatedOn(new java.util.Date());
        //   User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new ResourceNotFoundException("Blog not found for this id ::"));
        // User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new ResourceNotFoundException("Blog not found for this id ::" + id));
        post.setUsername(postDto.getUsername());
        return post;

    }

    public PostDto readSinglePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapFromPostToDto(post);
    }
}
