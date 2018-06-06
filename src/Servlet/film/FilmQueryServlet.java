package Servlet.film;

import Bean.Film;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
    private String filmCategory;
    private Boolean isName = false;

    private List<Film> filmList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.filmName = request.getParameter("FilmName");
        filmCategory = request.getParameter("kind");
        if(filmName!=null) {
            this.isName = true;
            QueryFilm queryFilm = new QueryFilm(filmName, true);
            queryFilm.executeQuery();
            this.filmList = queryFilm.getFilmList();
            request.setAttribute("filmList",this.filmList);
            request.getRequestDispatcher("film/filmNameQueryResult.jsp").forward(request,response);
        }
        else if(filmCategory!=null){
            this.isName = false;
            QueryFilm queryFilm = new QueryFilm(filmCategory,false);
            queryFilm.executeQuery();
            this.filmList = queryFilm.getFilmList();
            request.setAttribute("filmList",this.filmList);
            request.getRequestDispatcher("/film/filmCategoryQueryResult.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
