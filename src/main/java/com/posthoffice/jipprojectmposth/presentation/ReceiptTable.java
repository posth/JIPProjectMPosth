package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.model.ReceiptTableModel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ReceiptTable extends JTable {

    public ReceiptTable(ReceiptTableModel receiptTableModel) {
        super(receiptTableModel);
    }
}
