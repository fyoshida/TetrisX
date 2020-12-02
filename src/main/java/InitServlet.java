
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Block;
import model.Block1;
import model.Block2;
import model.Block4;
import model.Block5;
import model.Block6;
import model.Stage;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(urlPatterns={"/InitServlet"})
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doMain(req, res);
	}

	protected void doMain(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession();

		// オブジェクトの生成
		Stage stage = new Stage();
		Block block = createBlock();

		// Sessionにプレーヤを保存
		session.setAttribute("Stage", stage);
		session.setAttribute("Block", block);

		req.getRequestDispatcher("/Tetris.jsp").forward(req, res);

	}

	//======================================
	// ブロック生成用関数
	//======================================
	private Block createBlock() {
		Block block;
		int type = (int) (Math.random() * 6) + 1;
		switch (type) {
		case 1:
			block = new Block1();
			break;
		case 2:
			block = new Block2();
			break;
		case 3:
			block = new Block1();
			break;
		case 4:
			block = new Block4();
			break;
		case 5:
			block = new Block5();
			break;
		default:
			block = new Block6();
			break;
		}
		return block;
	}
}
