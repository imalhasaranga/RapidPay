
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Imal
 */
public class abc extends JTable{
    
    
    @Override
    public Component prepareRenderer(TableCellRenderer renderer,
        int rowIndex, int vColIndex) {
        Component c = super.prepareRenderer(renderer, rowIndex,	vColIndex);
        
            try {
                if(this.getValueAt(rowIndex,4 ).toString().equals("PAYIED")){
                    c.setBackground(java.awt.Color.GREEN);
                    c.setForeground(Color.WHITE);
                }else{
                    c.setBackground(java.awt.Color.RED);
                    c.setForeground(Color.WHITE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        
        return c;
    }
}
