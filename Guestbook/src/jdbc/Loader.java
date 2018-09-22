package jdbc;

import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		try {
			String drivers = config.getInitParameter("jdbcdriver");
			StringTokenizer tokenizer = new StringTokenizer(drivers, ",");

			while (tokenizer.hasMoreTokens()) {
				String driver = tokenizer.nextToken();

				// 데이터베이스 드라이버 로드
				Class.forName(driver);
				System.out.println(driver + " : 데이터베이스 드라이버 로드 성공!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
