class Solution {
    public String reformatDate(String date) {
        String[] parts = date.split(" ");

        String day = parts[0].replaceAll("[a-zA-Z]", "");
        if (day.length() == 1) {
            day = "0" + day;
        }

        String[] months = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        String month = "";
        for (int i = 0; i < 12; i++) {
            if (months[i].equals(parts[1])) {
                month = (i + 1 < 10) ? "0" + (i + 1) : String.valueOf(i + 1);
                break;
            }
        }

        return parts[2] + "-" + month + "-" + day;
    }
}
