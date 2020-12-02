package model;

public class Block5 extends Block {

	//========================
	// コンストラクタ
	//========================
	public Block5() {
		type = 5;
		cells.add(new Cell(-1, 1));
		cells.add(new Cell(-1, 0));
		cells.add(new Cell(0, 0));
		cells.add(new Cell(1, 0));
		cells.add(new Cell(1,-1));
	}

}
