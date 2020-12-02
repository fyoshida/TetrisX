package model;

import java.util.LinkedList;

public class Block extends Character {
	//------------------------
	// 属性
	//------------------------
	protected int type=0;
	protected LinkedList<Cell> cells = new LinkedList<Cell>();

	//========================
	// コンストラクタ
	//========================
	public Block() {
		x = 5;
		y = 18;
	}

	//------------------------
	// アクセッサ
	//------------------------
	public int getType() {
		return type;
	}

	//========================
	// メソッド（移動、回転）
	//========================
	public void moveRight() {
		x++;
	}

	public void moveLeft() {
		x--;
	}

	public void moveDown() {
		y--;
	}

	public void moveUp() {
		y++;
	}

	public void turnRight() {
		for (Cell cell : cells) {
			cell.turn90toRight();
		}
	}

	public void turnLeft() {
		for (Cell cell : cells) {
			cell.turn90toLeft();
		}
	}

	//========================
	// メソッド（セルの座標）
	//========================
	public int getCellSize() {
		return cells.size();
	}

	public int getCellX(int index) {
		Cell cell = cells.get(index);
		return x + cell.getX();
	}

	public int getCellY(int index) {
		Cell cell = cells.get(index);
		return y + cell.getY();
	}


}
