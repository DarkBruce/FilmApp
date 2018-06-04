package Servlet.film;

import Bean.Film;
import utils.QueryFilm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FilmQueryServlet")
public class FilmQueryServlet extends HttpServlet {
    private String filmName;
    private List<Film> filmList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        filmName = request.getParameter("FilmName");
        QueryFilm queryFilm = new QueryFilm(filmName);
        request.setAttribute("filmList",this.filmList);
        request.getRequestDispatcher("/film/filmNameQueryResult.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
