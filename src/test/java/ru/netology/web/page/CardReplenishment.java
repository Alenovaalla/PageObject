package ru.netology.web.page;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CardReplenishment {

    public class CardPageReplenish {
        private SelenideElement amountField = $("[data-test-id='amount'] .input__control");
        private SelenideElement cardFrom = $("[data-test-id='from'] .input__control");
        private SelenideElement replenish = $("[data-test-id='action-transfer']");
        private SelenideElement cardPageReplenish = $("[data-test-id='dashboard']");

        public CardPageReplenish() {
            cardPageReplenish.shouldBe(visible);
        }

        public void replenishCardToCard(DataHelper.AuthInfo authInfo, String sum, DataHelper.CardNumber cardNumber) {
            amountField.setValue(sum);
            cardFrom.setValue(cardNumber.getCardForm());
            replenish.click();
        }
    }
}
