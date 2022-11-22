package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge = new ArrayList<>();
    private final List<String> boardList = new ArrayList<>();
    private final List<String> upBoardList = new ArrayList<>();
    private final List<String> downBoardList = new ArrayList<>();
    private int count = 0;
    private boolean success = false;
    private int tryCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String move) {
        boardList.add(move);
        if (move.equals("U")) {
            addUpList(move);
        }
        if (move.equals("D")) {
            addDownList(move);
        }
        count += 1;
        ValidateBrideSizeSameAsBoardList();
        return success;
    }

    private void addUpList(String move) {
        if (bridge.get(count).equals(move)) {
            upBoardList.add("O");
            downBoardList.add(" ");
            success = true;
            return;
        }
        upBoardList.add("X");
        downBoardList.add(" ");
        success = false;
    }

    private void addDownList(String move) {
        if (bridge.get(count).equals(move)) {
            downBoardList.add("O");
            upBoardList.add(" ");
            success = true;
            return;
        }
        downBoardList.add("X");
        upBoardList.add(" ");
        success = false;
    }

    private void ValidateBrideSizeSameAsBoardList() {
        if (bridge.size() == boardList.size()) {
            if (Arrays.equals(bridge.toArray(), boardList.toArray())) {
                this.success = true;
            }
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.boardList.clear();
        this.upBoardList.clear();
        this.downBoardList.clear();
        this.count = 0;
        this.tryCount += 1;
        this.success = true;
    }
}
