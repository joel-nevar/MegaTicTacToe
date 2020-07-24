import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public class CellTest {
    public static void main(String[] args) {
        Cell cellBuilder = new Cell.CellBuilder("a", "b", CellValueType.EMPTY).drawGameBoard().build();
    }
}
