package controller;

import model.Football;
import model.FootballForm;
import model.Teams;
import service.FootballService;
import service.FootballServiceImpl;
import service.TeamsService;
import service.TeamsServiceImpl;

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
    private TeamsService teamsService = new TeamsServiceImpl();

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
        try {
            Football football = this.footballService.findById(id);
            RequestDispatcher dispatcher;
            if (football == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                this.footballService.remove(id);
//                dispatcher = request.getRequestDispatcher("/delete.jsp");
            }
            response.sendRedirect("/display");
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
        int age = Integer.parseInt(request.getParameter("age"));
        int height = Integer.parseInt(request.getParameter("height"));
        String nationality = request.getParameter("nationality");
        String postion = request.getParameter("postion");

        try {
            Football football = this.footballService.findById(id);
            RequestDispatcher dispatcher;
            if (football == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                football.setName(name);
                football.setAge(age);
                football.setHeight(height);
                football.setNationality(nationality);
                football.setPostion(postion);
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
            int age = Integer.parseInt(request.getParameter("age"));
            int height = Integer.parseInt(request.getParameter("height"));
            String nationality = request.getParameter("nationality");
            String postion = request.getParameter("postion");
            int teamId = Integer.parseInt(request.getParameter("teamId"));

            Football football = new Football(name, age, height, nationality, postion, teamId);
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
                showDeleteFootball(request, response);
            case "view":
                showViewFootball(request, response);
                break;
            default:
                showListTeam(request, response);
                break;
//            default:
//                showListFootballs(request, response);
//                break;
        }
    }

    private void showListTeam(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<FootballForm>footballs = this.footballService.findAll();
            request.setAttribute("x1", footballs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewListTeamFootball.jsp");
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

    private void showViewFootball(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Football football = this.footballService.findById(id);
            RequestDispatcher dispatcher;
            if (football == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                request.setAttribute("view", football);
                dispatcher = request.getRequestDispatcher("/view.jsp");
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

    private void showDeleteFootball(HttpServletRequest request, HttpServletResponse response) {
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

        try{
        List<Teams> teams = this.teamsService.findAll();
        request.setAttribute("teams",teams);
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

    private void showListFootballs(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<FootballForm> footballs = this.footballService.findAll();
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
