package pages.component;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public static void setDate(String day, String month, String year) {
        $(".react-datepicker__year-select").sendKeys(year);
        $(".react-datepicker__month-select").sendKeys(month);
        $(".react-datepicker__day--0" + String.format("%02d", Integer.parseInt(day))).click();
    }
}
