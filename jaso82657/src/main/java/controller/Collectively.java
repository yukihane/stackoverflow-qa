package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LunchDAO;
import model.Lunch;

/**
 *
 */
@WebServlet("/Collectively")
public class Collectively extends HttpServlet {
 private static final long serialVersionUID = 1L;

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

  request.setCharacterEncoding("UTF-8");

  java.util.Date dt = new java.util.Date();
  long timeInMilliSeconds = dt.getTime();
  java.sql.Date dtsql = new java.sql.Date(timeInMilliSeconds);
  request.setAttribute("dtsql", dtsql);

  LunchDAO dao = new LunchDAO();
  dao.findTwo(dtsql);
  //全件表示のメソッド呼び出し
  List<Lunch> collectively = dao.findTwo(dtsql);
  request.setAttribute("collectively", collectively);
  List<Lunch> list = dao.findAll();
  request.setAttribute("list", list);
  //response.sendRedirect("/B31/WEB-INF/view/collectively.jsp");
  //contextと接続
  ServletContext context = getServletContext();
  //ページ移動
  RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/view/collectively.jsp");
  rd.forward(request, response);
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  request.setCharacterEncoding("UTF-8");
  try {
   Connection con = new ResourceFinder().getConnection();

   String search = request.getParameter("quantity");
   String code = request.getParameter("DropDownList");
   //メソッドが稼働した日時を取得
   Timestamp timestamp = new Timestamp(System.currentTimeMillis());
   //メソッドが稼働した日時を取得
   java.util.Date dt = new java.util.Date();
   long timeInMilliSeconds = dt.getTime();
   java.sql.Date dtsql = new java.sql.Date(timeInMilliSeconds);
   //SQL文実行
   PreparedStatement ps = con.prepareStatement(
     "INSERT INTO t_sales(sales_date,product_code,quantity,register_datetime) VALUES(?,?,?,?)");
   ps.setString(1, "" + dtsql + "");
   ps.setString(2, "" + code + "");
   ps.setString(3, "" + search + "");
   ps.setString(4, "" + timestamp + "");
   ps.executeUpdate();
   response.sendRedirect("/B31/Collectively");
   
  } catch (Exception e) {
   e.printStackTrace();
  }

  ///forward(request, response);
  //contextと接続
  //ServletContext context = getServletContext();
  //ページ移動
  //RequestDispatcher rd = context.getRequestDispatcher("/Test");
  //rd.forward(request, response);
 }
}