/*
* SearchById.java
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
 * SearchById.<br>
 *
 * <pre>
 * The program will retrieve the id from the jsp file and will retrieve the article data from the database via the id
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
public class SearchById extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Seach theo id cua bai viet Neu id khong phai la so thi se bao
     * loi trong trang error.jsp New id khong ton tai thi se bao loi o trang
     * PostInTop5.jsp
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
            String message = null;
            List<Article> getTop5 = db.getTop5();
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                Article postById = db.getPostById(id);
                if (postById == null) {
                    message = "Id not exist!";
                    request.setAttribute("message", message);
                    request.setAttribute("getTop5", getTop5);
                    request.getRequestDispatcher("SearchById.jsp").forward(request, response);
                } else {
                    String imagesId = "./images/" + postById.getImages();
                    String synopsis = postById.getContent().substring(0, 200) + "...";
                    request.setAttribute("imagesId", imagesId);
                    request.setAttribute("synopsis", synopsis);
                    request.setAttribute("postById", postById);
                    request.setAttribute("getTop5", getTop5);
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("SearchById.jsp").forward(request, response);
                }
            } catch (NumberFormatException | ServletException | IOException e) {
                message = "Error!";
                request.setAttribute("message", message);
                request.setAttribute("getTop5", getTop5);
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
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
