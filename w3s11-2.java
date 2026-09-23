class Solution {
    public int daysBetweenDates(String date1, String date2) {
        String[] d1 = date1.split("-"); 
        String[] d2 = date2.split("-"); 
        int y1 = Integer.parseInt(d1[0]); 
        int m1 = Integer.parseInt(d1[1]); 
        int day1 = Integer.parseInt(d1[2]); 
        int y2 = Integer.parseInt(d2[0]); 
        int m2 = Integer.parseInt(d2[1]); 
        int day2 = Integer.parseInt(d2[2]); 
        int total1 = getDays(y1, m1, day1); 
        int total2 = getDays(y2, m2, day2); 
        return Math.abs(total1 - total2); 
        } 
        private int getDays(int year, int month, int day) { 
            int total = 0; 
            for (int y = 1971; y < year; y++) { 
                total += isLeap(y) ? 366 : 365; 
            } 
            int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; 
            for (int m = 1; m < month; m++) { 
                total += days[m - 1]; 
                if (m == 2 && isLeap(year)) { 
                    total++; } } total += day; 
                    return total; 
                    } 
                    private boolean isLeap(int year) { 
                        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}