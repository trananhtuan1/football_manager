package controller;

import model.Teams;
import service.TeamsService;
import service.TeamsServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TeamsServlet", urlPatterns = "/teams")
public class TeamsServlet extends HttpServlet {
    private TeamsService teamsService = new TeamsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createTeam(request, response);
                break;
            case "edit":
                editTeam(request, response);
                break;
            case "delete":
                deleteTeam(request, response);
                break;
        }
    }

    private void deleteTeam(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Teams teams = this.teamsService.findById(id);
            RequestDispatcher dispatcher;
            if (teams == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                this.teamsService.remove(id);
                response.sendRedirect("/teams");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void editTeam(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        try {
            Teams teams = this.teamsService.findById(id);
            RequestDispatcher dispatcher;
            if (teams == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                teams.setName(name);
                this.teamsService.update(id, teams);
                request.setAttribute("edit", teams);
                request.setAttribute("message", "done");
                dispatcher = request.getRequestDispatcher("/editTeam.jsp");
            }
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

    private void createTeam(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        try {
            Teams teams = new Teams(name);
            this.teamsService.save(teams);
            request.setAttribute("message", "done");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/createTeam.jsp");
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateTeam(request, response);
                break;
            case "edit":
                showEditTeam(request, response);
                break;
            case "delete":
                showDeleteTeam(request, response);
                break;
            case "view":
                viewTeam(request, response);
                break;
            default:
                showListTeams(request, response);
                break;
        }
    }

    private void viewTeam(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Teams teams = this.teamsService.findById(id);
            RequestDispatcher dispatcher;
            if (teams == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                request.setAttribute("view", teams);
                dispatcher = request.getRequestDispatcher("/viewTeam.jsp");
            }
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

    private void showDeleteTeam(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Teams teams = this.teamsService.findById(id);
            RequestDispatcher dispatcher;
            if (teams == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                request.setAttribute("delete", teams);
                dispatcher = request.getRequestDispatcher("/deleteTeam.jsp");
            }
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

    private void showEditTeam(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Teams teams = this.teamsService.findById(id);
            RequestDispatcher dispatcher;
            if (teams == null) {
                dispatcher = request.getRequestDispatcher("/error.jsp");
            } else {
                request.setAttribute("edit", teams);
                dispatcher = request.getRequestDispatcher("/editTeam.jsp");
                dispatcher.forward(request, response);
            }

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

    private void showCreateTeam(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/createTeam.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListTeams(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Teams> teams = this.teamsService.findAll();
            request.setAttribute("x1", teams);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/listTeams.jsp");
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
}
