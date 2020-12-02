package model;

public class Block6 extends Block {

	//========================
	// コンストラクタ
	//========================
	public Block6() {
		type = 6;
		cells.add(new Cell(1, 1));
		cells.add(new Cell(1, 0));
		cells.add(new Cell(0, 1));
		cells.add(new Cell(0, 0));
	}

}
