
import br.com.motta.leiloestdsat.ConectaDAO;
import br.com.motta.leiloestdsat.ProdutosDTO;
import jakarta.persistence.EntityManager;

public class ProudutosDAOS {

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

}
