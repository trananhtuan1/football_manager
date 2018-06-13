package controller;

import model.Football;
import service.FootballService;
import service.FootballServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FootballServlet", urlPatterns = "/display")
public class FootballServlet extends javax.servlet.http.HttpServlet {
    private FootballService footballService = new FootballServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createFootball(request, response);
                break;
            case "edit":
                editFootball(request, response);
                break;
            case "delete":
                deleteFootball(request, response);
                break;
        }
    }

    private void deleteFootball(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        try {
            Football football = this.footballService.findById(id);
            RequestDispatcher dispatcher;
            if (football == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                this.footballService.remove(id);
                response.sendRedirect("/dispatcher");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editFootball(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        try {
            Football football = this.footballService.findById(id);
            RequestDispatcher dispatcher;
            if (football == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                football.setName(name);
                this.footballService.update(id, football);
                request.setAttribute("edit", football);
                request.setAttribute("message", "done");
                dispatcher = request.getRequestDispatcher("/edit.jsp");
            }
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFootball(HttpServletRequest request, HttpServletResponse response) {
        try {
            String name = request.getParameter("name");

            Football football = new Football(name);
            this.footballService.save(football);
            request.setAttribute("message", "done");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFootball(request, response);
                break;
            case "edit":
                showEditFootball(request, response);
                break;
            case "delete":
                showDelete(request, response);
            default:
                showListFootballs(request, response);
                break;
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Football football = this.footballService.findById(id);
            RequestDispatcher dispatcher;
            if (football == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                request.setAttribute("delete", football);
                dispatcher = request.getRequestDispatcher("/delete.jsp");
            }
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditFootball(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Football football = this.footballService.findById(id);
            request.setAttribute("edit", football);
            RequestDispatcher dispatcher;
            if (football == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("/edit.jsp");
            }
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFootball(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListFootballs(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Football> footballs = this.footballService.findAll();
            request.setAttribute("x1", footballs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
