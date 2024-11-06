package br.com.motta.leiloestdsat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    public static void cadastrar(ProdutosDTO p) {
        EntityManager manager = ConectaDAO.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(p);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            ConectaDAO.desconectar();
        }
    }

    public static List<ProdutosDTO> listarProdutos() {
        List<ProdutosDTO> lista = new ArrayList<ProdutosDTO>();

        EntityManager manager = ConectaDAO.conectar();
        try {
            Query consulta = manager.createQuery("FROM Produtos");
            lista = consulta.getResultList();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar os dados");
            System.out.println(e);
        } finally {
            ConectaDAO.desconectar();
        }
        return lista;
    }

    public static void venderProduto(int id) {
        EntityManager manager = ConectaDAO.conectar();
        try {
            manager.getTransaction().begin();
            ProdutosDTO p = manager.find(ProdutosDTO.class, id);
            if (p != null) {
                p.setStatus("Vendido");
                manager.merge(p);
                manager.getTransaction().commit();

            } else {
                System.out.println("Produto não encontrado!");
                manager.getTransaction().rollback();

            }

        } catch (Exception e) {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            e.printStackTrace();
            
        } finally {
            ConectaDAO.desconectar();
        }
    }
}
