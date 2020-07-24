import org.academiadecodigo.felinux.mvc.model.cell.Cell;

public class CellTest {
    public static void main(String[] args) {

        Cell cell = new Cell("a", "b");
        cell.drawCellInNewLine();
        cell.drawCellInSameLine(cell);
    }
}
