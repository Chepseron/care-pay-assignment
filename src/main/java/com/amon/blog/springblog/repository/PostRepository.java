/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.blog.springblog.repository;

import com.amon.blog.springblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tech
 */
public interface PostRepository extends JpaRepository<Post, Long> {

}
