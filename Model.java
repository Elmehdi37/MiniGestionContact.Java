import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Model extends AbstractTableModel {

    private List<Personne> data = new LinkedList<>();
    private String[] header = {"Nom","Prénom","Téléphone"};

    public int sizeData(){
        return data.size();
    }

    public void addPersonne(Personne p){
        data.add(p);
        this.fireTableDataChanged();
    }

    public void removePersonne(int index){
        data.remove(index);
        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Personne db = data.get(rowIndex);
        switch (columnIndex){
            case 0 : return db.getNom();
            case 1 : return db.getPrenom();
            case 2 : return db.getTelephone();
            default: return null;
        }
    }
}
