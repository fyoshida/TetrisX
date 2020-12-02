package model;

import java.util.LinkedList;

public class Stage {
	//------------------------
	// 属性
	//------------------------
	private int xsize = 10;
	private int ysize = 20;
	private LinkedList<Line> lines = new LinkedList<Line>();

	//------------------------
	// コンストラクタ
	//------------------------
	public Stage() {
		initialize();
	}

	public void initialize() {
		for (int y = 0; y <= ysize; y++) {
			lines.add(new Line(xsize));
		}
	}

	//=======================================
	// メソッド（座標（x,y)のセルの値・取得）
	//=======================================
	public int getType(int x, int y) {
		return lines.get(y).getType(x);
	}

	public void setType(int x, int y, int type) {
		lines.get(y).setType(x, type);
	}

	//======================================
	// メソッド（ステージの操作）
	//======================================
	//----------------------------
	// すべて埋まったラインを消す
	//----------------------------
	public void eraseLines() {
		for (int i = 0; i < lines.size(); i++) {
			Line line = lines.get(i);
			if (line.isFull()) {
				lines.remove(i);
				lines.add(new Line(xsize));
			}
		}
	}

	//------------------------------------------
	// ブロックのセルのタイプをステージにコピー
	//------------------------------------------
	public void copyTypeFrom(Block block) {
		for (int i = 0; i < block.getCellSize(); i++) {
			int x = block.getCellX(i);
			int y = block.getCellY(i);
			int type = block.getType();
			setType(x, y, type);
		}
	}

	//======================================
	// メソッド（ブロックの操作）
	//======================================
	//-------------------------------
	// ステージをはみ出しているか？
	//-------------------------------
	private boolean overStage(Block block) {
		for (int i = 0; i < block.getCellSize(); i++) {
			int x = block.getCellX(i);
			int y = block.getCellY(i);
			if (x < 0 || x >= xsize || y < 0 || y >= ysize) {
				return true;
			}
		}
		return false;
	}

	//--------------------------------------
	// 落下済みのブロックと重なっているか？
	//--------------------------------------
	protected boolean isOverlap(Block block) {
		for (int i = 0; i < block.getCellSize(); i++) {
			int x = block.getCellX(i);
			int y = block.getCellY(i);
			if (getType(x, y) != 0) {
				return true;
			}
		}
		return false;
	}

	//--------------------------------------
	// ブロックは落下可能か？
	//--------------------------------------
	public boolean isDownable(Block block) {
		block.moveDown();
		boolean result = !overStage(block) && !isOverlap(block);
		block.moveUp();
		return result;
	}

	//--------------------------------------
	// ブロックは左に移動可能か？
	//--------------------------------------
	public boolean isMovableToLeft(Block block) {
		block.moveLeft();
		boolean result = !overStage(block) && !isOverlap(block);
		block.moveRight();
		return result;
	}

	//--------------------------------------
	// ブロックは右に移動可能か？
	//--------------------------------------
	public boolean isMovableToRight(Block block) {
		block.moveRight();
		boolean result = !overStage(block) && !isOverlap(block);
		block.moveLeft();
		return result;
	}

	//--------------------------------------
	// ブロックは回転可能か？
	//--------------------------------------
	public boolean isTurnable(Block block) {
		block.turnRight();
		boolean result = !overStage(block) && !isOverlap(block);
		block.turnLeft();
		return result;
	}
}
