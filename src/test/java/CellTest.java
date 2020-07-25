import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.mvc.controller.MainController;
import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.model.grid.SuperGrid;
import org.academiadecodigo.felinux.mvc.view.MenuView;

public class CellTest {
    public static void main(String[] args) {
        SuperGrid grid = new SuperGrid();
        grid.drawGameBoard();
        Grid grid1 = new Grid();
        grid1.drawGameBoard();

        MenuView menuView = new MenuView();
        menuView.setMainController(new MainController());
        menuView.setPrompt(new Prompt(System.in, System.out));
        menuView.show();
    }
}
