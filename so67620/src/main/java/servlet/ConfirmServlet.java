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

import logic.ConfirmQuestionLogic;
import logic.GetAnswerLogic;
import model.Answer;
import model.Question;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //文字コードエンコーディング
        request.setCharacterEncoding("UTF-8");
        //リクエストパラメータ取得
        // int question_id = this.question_id;
        int question_id = Integer.parseInt(request.getParameter("question_id"));

        //選択された行の質問リスト取得
        ConfirmQuestionLogic ConfirmQuestionLogic = new ConfirmQuestionLogic();
        List<Question> questionList = ConfirmQuestionLogic.confirm(question_id);
        HttpSession session = request.getSession();
        session.setAttribute("questionList", questionList);

        //選択された行の回答リスト取得
        GetAnswerLogic GetAnswerLogic = new GetAnswerLogic();
        List<Answer> answerList = GetAnswerLogic.getAnswer(question_id);
        session.setAttribute("answerList", answerList);

        //質問リスト画面へフォワード
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/jsp/QandAComfirm.jsp");
        dispatcher.forward(request, response);
    }
}
