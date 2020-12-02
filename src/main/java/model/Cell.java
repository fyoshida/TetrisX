package model;

public class Cell extends Character{
	//------------------------
	// コンストラクタ
	//------------------------
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	//========================
	// メソッド（回転）
	//========================
	public void turn90toRight() {
		set(y, -x);
	}

	public void turn90toLeft() {
		set(-y, x);
	}

	private void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
