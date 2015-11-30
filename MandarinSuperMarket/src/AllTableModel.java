import java.util.List;

import javax.swing.table.AbstractTableModel;


class AllTableModel extends AbstractTableModel {

	private static final int Item_COL = 1;
	private static final int Price_COL = 2;
	private static final int Id_COL = 0;
	private static final int Dnum_COL = 3;
	
	
	private String[] columnNames = { "Item ID","Item", "Price" ,"Dnum"};
	private List<Products> Products;

	public AllTableModel(List<Products> theProducts) {
		Products = theProducts;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return Products.size();
	}

	@Override
	public String getColumnName(int col) {
		
		return columnNames[col];
		
	}
	

	@Override
	public Object getValueAt(int row, int col) {

		Products tempProducts = Products.get(row);

		switch (col) {
		case Item_COL:
			return tempProducts.getItem();
		case Price_COL:
			return tempProducts.getPrice();
		case Id_COL:
			return tempProducts.getID();
		case Dnum_COL:
			return tempProducts.getdnum();
		
		default:
			return tempProducts.getPrice();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}