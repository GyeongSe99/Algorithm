public class PG_150368 {
    private static int maxEmoticonPlusCnt;
    private static int maxTotalPrice;
    private static int[] discountOptions = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        setDiscountedRate(users, emoticons, 0, new int[emoticons.length]);
        return new int[]{maxEmoticonPlusCnt, maxTotalPrice};
    }

    private static void setDiscountedRate(int[][] users, int[] emoticons, int idx, int[] currentDiscounts) {
        // 이모티콘 할인율이 모두 결정되었다면
        if (idx == emoticons.length) {
            int totalPrice = 0;
            int plusCnt = 0;

            for (int[] user : users) {
                int discountThreshold = user[0];
                int subscribeThreshold = user[1];
                int sum = 0;

                // 할인된 이모티콘을 모두 구매했을 때 총액 계산
                for (int i = 0; i < emoticons.length; i++) {
                    if (currentDiscounts[i] >= discountThreshold) {
                        sum += (emoticons[i] * (100 - currentDiscounts[i]))/100;
                    }
                }

                // 총액이 기준보다 넘으면 구독
                if (sum >= subscribeThreshold) {
                    plusCnt++;
                } else {
                    totalPrice += sum;
                }
            }
            
            // 최대 이익 갱신
            if (plusCnt > maxEmoticonPlusCnt) {
                maxEmoticonPlusCnt = plusCnt;
                maxTotalPrice = totalPrice;
            } else if (plusCnt == maxEmoticonPlusCnt) {
                maxTotalPrice = Math.max(totalPrice, maxTotalPrice);
            }

            return;
        }

        // 이모티콘 할인 조합 결정
        for (int i = 0; i < discountOptions.length; i++) {
            currentDiscounts[idx] = discountOptions[i];
            setDiscountedRate(users, emoticons, idx + 1, currentDiscounts);
        }
    }

}
