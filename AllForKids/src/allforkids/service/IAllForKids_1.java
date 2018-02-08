/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;


import java.util.List;

/**
 *
 * @author Molka
 * @param <T>
 */
public interface IAllForKids_1<T> {
    public void insert(T p) ; 
    public List<T> getAll() ; 
    public T search(int n) ; 
    public boolean delete(int p) ; 
    public boolean update(T p) ; 
}
