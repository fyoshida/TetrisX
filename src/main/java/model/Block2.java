package model;

public class Block2 extends Block {

	//========================
	// コンストラクタ
	//========================
	public Block2() {
		type = 2;
		cells.add(new Cell(-1, 1));
		cells.add(new Cell(-1, 0));
		cells.add(new Cell(0, 0));
		cells.add(new Cell(1, 0));
	}

}
