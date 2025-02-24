/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author alunos
 */
@WebServlet(name = "operacoes", urlPatterns = {"/operacoes"})
public class operacoes extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            String op = request.getParameter("op");

            
            if (op.equals("CADASTRAR")) {
                String nome = request.getParameter("txtnome");
                double cpf = Double.parseDouble(request.getParameter("txtcpf"));
                double rg = Double.parseDouble(request.getParameter("txtrg"));
                double data_nascimento = Double.parseDouble(request.getParameter("txtdata_nascimento"));
                double telefone = Double.parseDouble(request.getParameter("txttelefone"));
                double cep = Double.parseDouble(request.getParameter("txtcep"));
                String endereco = request.getParameter("txtendereco");
                String email = request.getParameter("txtemail");
                String genero = request.getParameter("txtgenero");
                Cliente clin = new Cliente();
                ClienteDAO cdao = new ClienteDAO();
                clin.setNome(nome);
                clin.setCpf(cpf);
                clin.setRg(rg);
                clin.setData_nascimento(data_nascimento);
                clin.setTelefone(telefone);
                clin.setCep(cep);
                clin.setEndereco(endereco);
                clin.setEmail(email);
                clin.setGenero(genero);
                
                try {
                    cdao.cadastrar(clin);
                    request.setAttribute("msg", "Cadastrado com sucesso");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }

            } else if (op.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Cliente clin = new Cliente();
                ClienteDAO cdao = new ClienteDAO();
                
                clin.setId(id);
                try {
                    cdao.deletar(clin);
                    request.setAttribute("msg", "Deletado com sucesso");
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            } else if (op.equals("ATUALIZAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Cliente clin = new Cliente();
                ClienteDAO cdao = new ClienteDAO();
                 String nome = request.getParameter("txtnome");
                double cpf = Double.parseDouble(request.getParameter("txtcpf"));
                double rg = Double.parseDouble(request.getParameter("txtrg"));
                double data_nascimento = Double.parseDouble(request.getParameter("txtdata_nascimento"));
                double telefone = Double.parseDouble(request.getParameter("txttelefone"));
                double cep = Double.parseDouble(request.getParameter("txtcep"));
                String endereco = request.getParameter("txtendereco");
                String email = request.getParameter("txtemail");
                String genero = request.getParameter("txtgenero");
                clin.setId(id);
                clin.setNome(nome);
                clin.setCpf(cpf);
                clin.setRg(rg);
                clin.setData_nascimento(data_nascimento);
                clin.setTelefone(telefone);
                clin.setCep(cep);
                clin.setEndereco(endereco);
                clin.setEmail(email);
                clin.setGenero(genero);
                try{
                cdao.atualizar(clin);
                request.setAttribute("msg", "Atualizado com sucesso");
                    request.getRequestDispatcher("resultadoatualizar.jsp").forward(request, response);
                }catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
                
                
            } else if (op.equals("CONSULTAR BY ID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Cliente clin = new Cliente();
                ClienteDAO cdao = new ClienteDAO();
                clin.setId(id);
                try {
                    clin = cdao.consultarById(clin);                
                    
                    request.setAttribute("clin", clin);
                    request.getRequestDispatcher("resultadoconsultarbyid.jsp").forward(request, response);
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
                
                
            } else if (op.equals("CONSULTAR TODOS")) {
                 ClienteDAO cdao = new ClienteDAO();
                  try {
                    List<Cliente> listcliente = cdao.consultarTodos();;                
                    
                    request.setAttribute("listcliente", listcliente);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
                
            }

            
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
