package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.EditQuestionLogic;
import logic.GetQuestionLogic;
import model.Question;


/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditQuestionServlet")
public class EditQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int question_id;
    private String update_timestamp;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //リクエストから取得した情報を表示
        HttpSession session = request.getSession();
        Question questionList = (Question) request.getAttribute("questionList");
        String eKey = questionList.getEdit_delete_key();

        //文字コードエンコーディング
        request.setCharacterEncoding("UTF-8");
        //リクエストパラメータ取得
        String editKey = request.getParameter("edit_delete_key");

        if(eKey == editKey){
            //入力されたキーの質問リストを取得してスコープへ保存
            EditQuestionLogic EditQuestionLogic = new EditQuestionLogic();
            List<Question> EditQuestionList = EditQuestionLogic.findKey(editKey);
            session.setAttribute("EditQuestionList", EditQuestionList);
            //質問編集画面へフォワード
            RequestDispatcher dispatcher =
                        request.getRequestDispatcher("/WEB-INF/jsp/QandAEdit.jsp");
            dispatcher.forward(request, response);
        } else {
            //質問リスト画面へフォワード
            RequestDispatcher dispatcher =
                        request.getRequestDispatcher("/WEB-INF/jsp/QandAList.jsp");
            dispatcher.forward(request, response);
        }
    }
}
