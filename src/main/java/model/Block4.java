package model;

public class Block4 extends Block {

	//========================
	// コンストラクタ
	//========================
	public Block4() {
		type = 4;
		cells.add(new Cell(1, 1));
		cells.add(new Cell(1, 0));
		cells.add(new Cell(0, 0));
		cells.add(new Cell(-1, 0));
		cells.add(new Cell(-1,-1));
	}

}
