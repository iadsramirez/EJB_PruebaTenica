/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.promerica.service;

import java.util.List;

/**
 *
 * @author user
 */
public interface IService<T> {

    Integer registrar(T t) throws Exception;

    Integer modificar(T t) throws Exception;

    Integer eliminar(T t) throws Exception;

    List<T> listar() throws Exception;

    T listarPorId(T t) throws Exception;

    T listarPorId(Integer t) throws Exception;
    
     List<T> listarById() throws Exception;

}
