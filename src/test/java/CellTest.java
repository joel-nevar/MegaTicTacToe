import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.mvc.controller.GameOverController;
import org.academiadecodigo.felinux.mvc.controller.MainController;
import org.academiadecodigo.felinux.mvc.controller.SinglePlayerController;
import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.model.grid.SuperGrid;
import org.academiadecodigo.felinux.mvc.view.GameOverView;
import org.academiadecodigo.felinux.mvc.view.GameView;
import org.academiadecodigo.felinux.mvc.view.MenuView;
import org.academiadecodigo.felinux.mvc.view.SinglePlayerView;
import org.academiadecodigo.felinux.service.GameService;

public class CellTest {
    public static void main(String[] args) {
        //OTHER TESTS, NOTHING TO DO WITH WHAT'S DOWN BELLOW
        SuperGrid grid = new SuperGrid();
        grid.drawGameBoard();
        Grid grid1 = new Grid();
        grid1.drawGameBoard();
        //

        Prompt prompt = new Prompt(System.in, System.out);
        MenuView menuView = new MenuView();
        MainController mainController = new MainController();
        SinglePlayerController singlePlayerController = new SinglePlayerController();
        SinglePlayerView singlePlayerView = new SinglePlayerView();
        GameService gameService = new GameService();
        GameOverController gameOverController = new GameOverController();
        GameOverView gameOverView = new GameOverView();

        mainController.setMenuView(menuView);
        mainController.setSinglePlayerController(singlePlayerController);

        singlePlayerController.setMainController(mainController);
        singlePlayerController.setGameService(gameService);
        singlePlayerController.setSinglePlayerView(singlePlayerView);
        singlePlayerController.setGameOverController(gameOverController);

        singlePlayerView.setSinglePlayerController(singlePlayerController);
        singlePlayerView.setPrompt(prompt);

        gameOverController.setGameOverView(gameOverView);
        gameOverController.setGameService(gameService);
        gameOverController.setMainController(mainController);
        gameOverController.setSinglePlayerController(singlePlayerController);

        gameOverView.setGameOverController(gameOverController);
        gameOverView.setPrompt(prompt);

        menuView.setMainController(mainController);
        menuView.setPrompt(prompt);

        mainController.init();
    }
}
