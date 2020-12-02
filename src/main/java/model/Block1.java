package model;

public class Block1 extends Block {

	//========================
	// コンストラクタ
	//========================
	public Block1() {
		type =1;
		cells.add(new Cell(0, 1));
		cells.add(new Cell(0, 0));
		cells.add(new Cell(0, -1));
		cells.add(new Cell(0, -2));
	}

}
