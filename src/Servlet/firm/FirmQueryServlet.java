package Servlet.firm;

import Bean.Firm;
import utils.QueryFirm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirmQueryServlet")
public class FirmQueryServlet extends HttpServlet {
    private String firmName;
    private Firm firm;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        firmName = request.getParameter("FirmName");
        QueryFirm queryFirm = new QueryFirm(firmName);
        queryFirm.executeQuery();
        this.firm = queryFirm.getFirm();
        request.setAttribute("Firm",this.firm);
        request.getRequestDispatcher("/film/firmQueryResult.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
