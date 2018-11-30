package DAOs;

import Entidades.Sexo;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOSexo extends DAOGenerico<Sexo> {

    public DAOSexo() {
        super(Sexo.class);
    }

    public int autoIdSexo() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idSexo) FROM Sexo e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Sexo> listByIdSexo(int idSexo) {
        return em.createQuery("SELECT e FROM Sexo e WHERE e.idSexo = :idSexo").setParameter("idSexo", idSexo).getResultList();
    }

    public List<Sexo> listByNomeSexo(String nomeSexo) {
        return em.createQuery("SELECT e FROM Sexo e WHERE e.nomeSexo LIKE :nomeSexo").setParameter("nomeSexo", "%" + nomeSexo + "%").getResultList();
    }

    public List<Sexo> listInOrderIdSexo() {
        return em.createQuery("SELECT e FROM Sexo e ORDER BY e.idSexo").getResultList();
    }

    public List<Sexo> listInOrderNomeSexo() {
        return em.createQuery("SELECT e FROM Sexo e ORDER BY e.nomeSexo").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Sexo> lf;
        if (qualOrdem.equals("idSexo")) {
            lf = listInOrderIdSexo();
        } else {
            lf = listInOrderNomeSexo();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdSexo() + ";" + lf.get(i).getNomeSexo() + ";");
        }
        return ls;
    }
}

