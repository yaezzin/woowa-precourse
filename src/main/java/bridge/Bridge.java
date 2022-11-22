package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Bridge {

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public Bridge() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public BridgeMaker getBridgeMaker() {
        return bridgeMaker;
    }
}
