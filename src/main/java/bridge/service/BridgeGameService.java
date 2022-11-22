package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.io.Console;
import java.util.List;

public class BridgeGameService {

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameService() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> getBridge() {
        int size = getInputBridgeSize();
        return bridgeMaker.makeBridge(size);
    }

    private int getInputBridgeSize() {
        outputView.printStartMessage();
        outputView.printInputBridgeSize();
        return inputView.readBridgeSize();
    }

    public void gameStart(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while(!bridgeGame.isGameOver()) {
            play(bridgeGame);
        }
        outputView.printResult(bridgeGame);
    }

    public void play(BridgeGame bridgeGame) {
        String board = getBoard(inputView, outputView);
        bridgeGame.move(board);
        List<String> upBoardList = bridgeGame.getUpBoardList();
        List<String> downBoardList = bridgeGame.getDownBoardList();
        outputView.printMap(upBoardList, downBoardList);
        if (isQuit(inputView, outputView, bridgeGame)) break;
        if (bridgeGame.getSuccess()) break;
    }

    private String getBoard(InputView inputView, OutputView outputView) {
        outputView.printInputBoard();
        return inputView.readMoving();
    }

    private static boolean isQuit(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        if (!bridgeGame.getMoveSuccess()) {
            outputView.printInputRetry();
            String retry = inputView.readGameCommand();
            if (retry.equals("R")) {
                bridgeGame.retry();
            }
            return retry.equals("Q");
        }
        return false;
    }

}
