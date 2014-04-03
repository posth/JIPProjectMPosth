package com.posthoffice.jipprojectmposth.presentation;

import com.posthoffice.jipprojectmposth.model.SurgicalDBTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class SurgicalCustomTable extends JTable {

    private final Font tableFont = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
    private final Font headerFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

    public SurgicalCustomTable(SurgicalDBTableModel surgicalModel) {
        super(surgicalModel);
        FontMetrics fm = this.getFontMetrics(tableFont);
        this.setRowHeight(fm.getHeight());
        this.setFont(tableFont);
    }

    @Override
    protected JTableHeader createDefaultTableHeader() {
        return new JTableHeader(columnModel) {
            @Override
            public Font getFont() {
                return headerFont;
            }
        };
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row,
            int column) {
        Component returnComp = super.prepareRenderer(renderer, row, column);
        Color alternateColor = new Color(229, 251, 255);
        Color whiteColor = Color.WHITE;


        if (!returnComp.getBackground().equals(getSelectionBackground())) {
            Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
            returnComp.setBackground(bg);
        }
        returnComp.setFont(tableFont);
        return returnComp;
    }
}
