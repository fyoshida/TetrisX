import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Block;
import model.Stage;

@WebServlet(urlPatterns = { "/PlayServlet" })
public class PlayServlet extends HttpServlet {

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

		// Sessionからステージ、ブロックを取得
		Stage stage = (Stage) session.getAttribute("Stage");
		Block block = (Block) session.getAttribute("Block");

		// 入力
		if (req.getParameter("Right") != null) {
			if (stage.isMovableToRight(block)) {
				block.moveRight();
			}
		} else if (req.getParameter("Left") != null) {
			if (stage.isMovableToLeft(block)) {
				block.moveLeft();
			}
		} else if (req.getParameter("Down") != null) {
			if (stage.isDownable(block)) {
				while(stage.isDownable(block)) {
					block.moveDown();
				}
			}
		} else if (req.getParameter("Turn") != null) {
			if (stage.isTurnable(block)) {
				block.turnRight();
			}
		}

		// Sessionにプレーヤを保存
		session.setAttribute("Stage",stage);
		session.setAttribute("Block",block);

		req.getRequestDispatcher("/Tetris.jsp").forward(req, res);
	}
}
