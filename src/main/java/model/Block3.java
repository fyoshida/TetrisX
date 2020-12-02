package model;

public class Block3 extends Block {

	//========================
	// コンストラクタ
	//========================
	public Block3() {
		type = 3;
		cells.add(new Cell(1, 1));
		cells.add(new Cell(1, 0));
		cells.add(new Cell(0, 0));
		cells.add(new Cell(-1, 0));
	}

}
