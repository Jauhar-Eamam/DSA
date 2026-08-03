class Solution {
    public int hIndex(int[] citations) {

        int minCitations = 1;
        int maxCitations = citations.length;

        int midCitations = (minCitations + maxCitations) / 2;

        int resultOfHIndex = 0;

        while (minCitations <= maxCitations) {
            if (isHIndex(citations, midCitations)) {

                minCitations = midCitations + 1;
                resultOfHIndex = Math.max(resultOfHIndex, midCitations);
            } else {
                maxCitations = midCitations - 1;
            }

            midCitations = (minCitations + maxCitations) / 2;

        }

        return resultOfHIndex;

    }

    public boolean isHIndex(int[] citations, int midCitations) {

        int lengthOfCitations = citations.length;
        int low = 0;
        int high = lengthOfCitations - 1;

        int mid = (low + high) / 2;

        int tempResult = lengthOfCitations;

        while (low <= high) {
            if (citations[mid] >= midCitations) {
                tempResult = Math.min(tempResult, mid);

                // if () {
                //     return true;
                // } else {
                //     low = mid + 1;
                // }
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            mid = (low + high) / 2;
        }

        if((lengthOfCitations - tempResult) >= midCitations){
            return true;
        }else {
            return false;
        }

    }
}