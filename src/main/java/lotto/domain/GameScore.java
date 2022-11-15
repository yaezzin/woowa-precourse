package lotto.domain;

import java.util.Map;

public class GameScore {

    private int prizeMoney;
    private double profitRate;
    private static Map<LottoWinType, Integer> lottoWinTypeMap;

    public GameScore(int prizeMoney, double profitRate, Map<LottoWinType, Integer> lottoWinTypeMap) {
        this.prizeMoney = prizeMoney;
        this.profitRate = profitRate;
        this.lottoWinTypeMap = lottoWinTypeMap;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public Map<LottoWinType, Integer> getLottoWinType() {
        return lottoWinTypeMap;
    }

    public static GameScore of(int prizeMoney, int userPay, Map<LottoWinType, Integer> lottoWinType) {
        double profitRate = calculateProfitRate(prizeMoney, userPay);
        return new GameScore(prizeMoney, profitRate, lottoWinType);
    }

    private static double calculateProfitRate(int price, int userPay) {
        double result = (double) price / (double) userPay * 100;
        System.out.println("총 수익률은 " + String.format("%.1d",result) + "%입니다.\n");
        return result;
    }
}
