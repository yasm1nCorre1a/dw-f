package DAOs;

import Entidades.Tipo;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOTipo extends DAOGenerico<Tipo> {

    public DAOTipo() {
        super(Tipo.class);
    }

    public int autoIdTipo() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idTipo) FROM Tipo e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Tipo> listByIdTipo(int idTipo) {
        return em.createQuery("SELECT e FROM Tipo e WHERE e.idTipo = :idTipo").setParameter("idTipo", idTipo).getResultList();
    }

    public List<Tipo> listByNomeTipo(String nomeTipo) {
        return em.createQuery("SELECT e FROM Tipo e WHERE e.nomeTipo LIKE :nomeTipo").setParameter("nomeTipo", "%" + nomeTipo + "%").getResultList();
    }

    public List<Tipo> listInOrderIdTipo() {
        return em.createQuery("SELECT e FROM Tipo e ORDER BY e.idTipo").getResultList();
    }

    public List<Tipo> listInOrderNomeTipo() {
        return em.createQuery("SELECT e FROM Tipo e ORDER BY e.nomeTipo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Tipo> lf;
        if (qualOrdem.equals("idTipo")) {
            lf = listInOrderIdTipo();
        } else {
            lf = listInOrderNomeTipo();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdTipo() + ";" + lf.get(i).getNomeTipo() + ";");
        }
        return ls;
    }
}

