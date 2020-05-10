/*
* SearchByTitle.java
*
* All Right Reserved
* Copyright (c) 2020 FPT University
 */
package controller;

import dal.DBDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;

/**
 * SearchByTitle.<br>
 *
 * <pre>
 * The program will retrieve the search string from the jsp file and then retrieve the value from the search by title from the databse via the title
 * In this class, we will proceed with the following processing.
 *
 * . ProcessRequest.
 * . DoGet.
 * . DoPost.
 *
 *
 * </pre>
 *
 * @author Hoang Viet
 * @version 1.0
 */
public class SearchByTitle extends HttpServlet {

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
        try {
            DBDao db = new DBDao();
            String stringSearch = request.getParameter("stringSearch");
            String pageIndex = request.getParameter("index");
            List<Article> getTop5 = db.getTop5();
            String message;
            if (stringSearch.isEmpty()) {
                message = "Please enter something to search!";
                request.setAttribute("message", message);
                request.setAttribute("getTop5", getTop5);
                request.getRequestDispatcher("SearchByTitle.jsp").forward(request, response);
            } else {
                if (pageIndex == null) {
                    pageIndex = "1";
                }
                int pageSize = 3;
                int index = Integer.parseInt(pageIndex);
                int total = db.countPost(stringSearch);
                int numberPage = total / pageSize;
                if (total % pageSize != 0) {
                    numberPage++;
                }
                List<Article> listSearch = db.searchArticle(stringSearch, index, pageSize);
                request.setAttribute("numberPage", numberPage);
                request.setAttribute("listSearch", listSearch);
                request.setAttribute("stringSearch", stringSearch);
                request.setAttribute("index", index);
                request.setAttribute("getTop5", getTop5);
                request.getRequestDispatcher("SearchByTitle.jsp").forward(request, response);
            }
        } catch (IOException | ClassNotFoundException | NumberFormatException | SQLException | ServletException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
     * Handles the HTTP <code>POST</code> method. Lay thong tin tu khung search
     * va tim kiem va phan trang Neu khong nhap gi vao thi se yeu cau nguoi dung
     * nhap Neu gia tri tim kiem khong co trong database thi se bao not found!
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
