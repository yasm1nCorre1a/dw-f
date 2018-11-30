package DAOs;

import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOCliente extends DAOGenerico<Cliente> {

    public DAOCliente() {
        super(Cliente.class);
    }

    public int autoIdCliente() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idCliente) FROM Cliente e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Cliente> listByIdCliente(int idCliente) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.idCliente = :idCliente").setParameter("idCliente", idCliente).getResultList();
    }

    public List<Cliente> listByNomeCliente(String nomeCliente) {
        return em.createQuery("SELECT e FROM Cliente e WHERE e.nomeCliente LIKE :nomeCliente").setParameter("nomeCliente", "%" + nomeCliente + "%").getResultList();
    }

    public List<Cliente> listInOrderIdCliente() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.idCliente").getResultList();
    }

    public List<Cliente> listInOrderNomeCliente() {
        return em.createQuery("SELECT e FROM Cliente e ORDER BY e.nomeCliente").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Cliente> lf;
        if (qualOrdem.equals("idCliente")) {
            lf = listInOrderIdCliente();
        } else {
            lf = listInOrderNomeCliente();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdCliente() + ";" + lf.get(i).getNomeCliente() + ";" + lf.get(i).getTelefone() + ";" + lf.get(i).getCelular() + ";" + lf.get(i).getEMail() + ";" + lf.get(i).getEndereco() + ";" + lf.get(i).getCidade() + ";" + lf.get(i).getCep() + ";" + lf.get(i).getBairro() + ";" + lf.get(i).getSexoIdSexo() + ";");
        }
        return ls;
    }
}

