/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOCliente;
import DAOs.DAOSexo;
import Entidades.Cliente;
import Entidades.Sexo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "CadastroClienteServlet", urlPatterns = {"/cadCliente"})
public class CadastroClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DAOCliente daoCliente = new DAOCliente();
            Cliente p = new Cliente();
            String id = request.getParameter("id_cliente");
            String nome = request.getParameter("nome_cliente");
            String telefone = request.getParameter("telefone_cliente");
            String celular = request.getParameter("celular_cliente");
            String email = request.getParameter("email_cliente");
            String endereco = request.getParameter("endereco_cliente");
            String cidade = request.getParameter("cidade_cliente");
            String cep = request.getParameter("cep_cliente");
            String bairro = request.getParameter("bairro_cliente");
            String sexo = request.getParameter("sexo");
            
            DAOSexo daoSexo = new DAOSexo();
            Sexo t = new Sexo();
            out.print("aqui");
            p.setIdCliente(Integer.valueOf(id));
            p.setNomeCliente(nome);
            p.setTelefone(telefone);
            p.setCelular(celular);
            p.setEMail(email);
            p.setEndereco(endereco);
            p.setCidade(cidade);
            p.setCep(cep);
            p.setBairro(bairro);
            p.setSexoIdSexo(daoSexo.obter(Integer.valueOf(sexo)));
            out.print("aqui");
            
            
            daoCliente.inserir(p);
            response.sendRedirect(request.getContextPath()+"/paginas/cliente.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
