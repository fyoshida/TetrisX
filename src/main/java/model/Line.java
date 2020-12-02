package model;

import java.util.LinkedList;

public class Line {
	//------------------------
	// 属性
	//------------------------
	LinkedList<Integer> types = new LinkedList<Integer>();

	//------------------------
	// コンストラクタ
	//------------------------
	public Line(int xsize) {
		for (int i = 0; i < xsize; i++) {
			types.add(0);
		}
	}

	//======================================
	// メソッド（x番目の値の設定・取得）
	//======================================
	public int getType(int x) {
		return types.get(x);
	}

	public void setType(int x, int type) {
		types.set(x, type);
	}

	//=======================================================
	// メソッド（全ての要素に０以外の値が設定されているか？）
	//=======================================================
	public boolean isFull() {
		for (int type : types) {
			if (type == 0) {
				return false;
			}
		}
		return true;
	}
}
