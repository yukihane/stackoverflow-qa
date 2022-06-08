import java.io.IOException;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AnalyzeSite {
  private static final String LOGIN_URL = "example.com/login";
  private final String USERNAME = "username@example.com";
  private final String PASSWORD = "pass1234";
  private final String UA = "Mozilla/5.0";
  private Map<String, String> cookie;

  public Document getDocument(String url) {
    Document document = null;
    try {
      if (cookie == null) {
        Response response = Jsoup.connect(LOGIN_URL).method(Connection.Method.GET).execute();
        response = Jsoup.connect(LOGIN_URL).data("Username", USERNAME, "Password", PASSWORD)
            .userAgent(UA).cookies(response.cookies()).method(Connection.Method.POST).timeout(10000).execute();
        System.out.println(response.statusCode());// httpステータス200 問題なし
        System.out.println(response.parse()); // ログインできてるHTMLが出る
        System.out.println(response.cookies().isEmpty());//なぜか空っぽ
        cookie = response.cookies();
      }
      document = Jsoup.connect(url).userAgent(UA).cookies(cookie).timeout(10000).get();
      System.out.println(document.html());//なぜかリダイレクトされたログインページが出力される
    } catch (IOException e) {
      e.printStackTrace();
    }
    return document;
  }

  public static void main(String[] args) {
    AnalyzeSite as = new AnalyzeSite();
    doSomething(as.getDocument("example.com/mypage"));// ここで取ったdocumentを解析したい
  }

private static void doSomething(Document document) {
    // TODO Auto-generated method stub
}
}
