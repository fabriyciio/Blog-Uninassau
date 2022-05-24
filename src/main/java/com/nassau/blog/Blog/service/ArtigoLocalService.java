package com.nassau.blog.blog.service;

import java.util.Date;
import java.util.NoSuchElementException;

import com.nassau.blog.blog.exception.ArtigoInexistenteException;
import com.nassau.blog.blog.model.Artigo;
import com.nassau.blog.blog.service.persistence.ArtigoPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
    * @author Alcir Balaka
 */

@Service
public class ArtigoLocalService {

    public Artigo criarArtigo( Artigo artigo){

        return artigoPersistence.save(artigo);
    }

    public Page<Artigo> buscarArtigos(Pageable paging) {

        return artigoPersistence.findAll(paging);
    }

    public Artigo buscarArtigoPeloId(int id) throws ArtigoInexistenteException {

        try{
            Artigo artigo = artigoPersistence.findById(id).get();

            return artigo;
        } catch (NoSuchElementException e){

            throw new ArtigoInexistenteException(
                String.format("Não existe artig com id %d", id)
            );
        }

    }

    public void deletarArtigo(int id) throws ArtigoInexistenteException {

        try {
            artigoPersistence.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ArtigoInexistenteException(
                String.format("Não existe artigo com id %id", id)
            );
        }
        artigoPersistence.deleteById(id);
    }

    public Artigo atualizarArtigo(int id, String titulo, String autor, 
           Date data, String texto ) throws ArtigoInexistenteException {
        
        try {
            Artigo artigo = artigoPersistence.findById(id).get();

            artigo.setTitulo(titulo);
            artigo.setAutor(autor);
            artigo.setData(data);
            artigo.setTexto(texto);

            artigoPersistence.save(artigo);

            return artigo;
        } catch (NoSuchElementException e) {
            throw new ArtigoInexistenteException (
               String.format("Não existe artigo com id %d", id) );
        }

    }

    @Autowired
    private ArtigoPersistence artigoPersistence;
    
}
