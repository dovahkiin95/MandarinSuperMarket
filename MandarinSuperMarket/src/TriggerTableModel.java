import java.util.List;

import javax.swing.table.AbstractTableModel;


class TriggerTableModel extends AbstractTableModel {

	private static final int Update_COL = 0;
	private static final int Changed_COL = 1;
	private static final int Item_COL = 2;
	private static final int Id_COL = 3;
	private static final int Old_COL = 4;
	private static final int New_COL = 5;
	
	
	private String[] columnNames = { "Update No.", "Changed On","Item","Id","Old Price","New Price" };
	private List<TriggerClass> Products1;

	public TriggerTableModel(List<TriggerClass> theProducts) {
		Products1 = theProducts;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return Products1.size();
	}

	@Override
	public String getColumnName(int col) {
		
		return columnNames[col];
		
	}
	

	@Override
	public Object getValueAt(int row, int col) {

		TriggerClass tempProducts = Products1.get(row);

		switch (col) {
		case Update_COL:
			return tempProducts.getUpdate();
		case Changed_COL:
			return tempProducts.getChanged();
		case Item_COL:
			return tempProducts.getItem();
		case Id_COL:
			return tempProducts.getId();
		case Old_COL:
			return tempProducts.getOldPrice();
		case New_COL:
			return tempProducts.getNewPrice();
		
		default:
			return tempProducts.getUpdate();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
		
	}
}