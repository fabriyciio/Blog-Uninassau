package com.nassau.blog.blog.service.persistence;

import com.nassau.blog.blog.model.Artigo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
    * @author Alcir Balaka
 */
    public interface ArtigoPersistence extends CrudRepository<Artigo, Integer>{

        Page<Artigo> findAll(Pageable pageable);

    }
    
