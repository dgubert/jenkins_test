package pages.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class TableComponent {

    public static void checkTableData(SelenideElement table, String key, String value) {
        table.$(byText(key)).parent().shouldHave(text(value));
    }
}
