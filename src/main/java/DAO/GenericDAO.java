package DAO;

import java.util.List;

public interface GenericDAO<T, ID> {
    void inserir(T entidade);
    List<T> listar();
}
