package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        getBridge(bridge.getBridgeMaker());
    }

    private static List<String> getBridge(BridgeMaker bridgeMaker) {
        OutputView.printStartMessage();
        int size = getInputBridgeSize();
        return bridgeMaker.makeBridge(size);
    }

    //private static int getInputBridgeSize() {
    //    OutputView.printInputBridgeSize();
    //    return InputView.readBridgeSize();
    //}

}
