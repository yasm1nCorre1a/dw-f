package DAOs;

import Entidades.Pedido;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOPedido extends DAOGenerico<Pedido> {

    public DAOPedido() {
        super(Pedido.class);
    }

    public int autoIdPedido() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idPedido) FROM Pedido e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Pedido> listByIdPedido(int idPedido) {
        return em.createQuery("SELECT e FROM Pedido e WHERE e.idPedido = :idPedido").setParameter("idPedido", idPedido).getResultList();
    }

    public List<Pedido> listByData(String data) {
        return em.createQuery("SELECT e FROM Pedido e WHERE e.data LIKE :data").setParameter("data", "%" + data + "%").getResultList();
    }

    public List<Pedido> listInOrderIdPedido() {
        return em.createQuery("SELECT e FROM Pedido e ORDER BY e.idPedido").getResultList();
    }

    public List<Pedido> listInOrderData() {
        return em.createQuery("SELECT e FROM Pedido e ORDER BY e.data").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Pedido> lf;
        if (qualOrdem.equals("idPedido")) {
            lf = listInOrderIdPedido();
        } else {
            lf = listInOrderData();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdPedido() + ";" + sdf.format(lf.get(i).getData()) + ";" + lf.get(i).getClienteIdCliente() + ";");
        }
        return ls;
    }
}

