package bridge.service;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

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

    // 1.
    public List<String> getBridge() {
        OutputView.printStartMessage();
        int size = getInputBridgeSize();
        return bridgeMaker.makeBridge(size);
    }

    private static int getInputBridgeSize() {
        OutputView.printInputBridgeSize();
        return InputView.readBridgeSize();
    }


    // 2.
    public void gameStart(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while(!bridgeGame.isGameOver()) {
            play(bridgeGame);
        }
        outputView.printResult();
    }
}
