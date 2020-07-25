import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.model.grid.SuperGrid;

public class CellTest {
    public static void main(String[] args) {
        SuperGrid grid = new SuperGrid();
        grid.drawGameBoard();
        Grid grid1 = new Grid();
        grid1.drawGameBoard();
    }
}
