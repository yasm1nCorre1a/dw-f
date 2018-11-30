package DAOs;

import Entidades.Flores;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOFlores extends DAOGenerico<Flores> {

    public DAOFlores() {
        super(Flores.class);
    }

    public int autoIdFlores() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idFlor) FROM Flores e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Flores> listByIdFlor(int idFlor) {
        return em.createQuery("SELECT e FROM Flores e WHERE e.idFlor = :idFlor").setParameter("idFlor", idFlor).getResultList();
    }

    public List<Flores> listByNomeFlor(String nomeFlor) {
        return em.createQuery("SELECT e FROM Flores e WHERE e.nomeFlor LIKE :nomeFlor").setParameter("nomeFlor", "%" + nomeFlor + "%").getResultList();
    }

    public List<Flores> listInOrderIdFlor() {
        return em.createQuery("SELECT e FROM Flores e ORDER BY e.idFlor").getResultList();
    }

    public List<Flores> listInOrderNomeFlor() {
        return em.createQuery("SELECT e FROM Flores e ORDER BY e.nomeFlor").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Flores> lf;
        if (qualOrdem.equals("idFlor")) {
            lf = listInOrderIdFlor();
        } else {
            lf = listInOrderNomeFlor();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdFlor() + ";" + lf.get(i).getNomeFlor() + ";" + lf.get(i).getQuantidadeFlor() + ";" + lf.get(i).getPrecoFlor() + ";" + lf.get(i).getTipoIdTipo() + ";");
        }
        return ls;
    }
}

