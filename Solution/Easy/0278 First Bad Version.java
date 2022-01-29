/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int high = n;
        int low = 1;
        int mid = 0;        

        while (high >= low) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid) == false) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return isBadVersion(mid) ? mid : mid + 1;
    }
}
