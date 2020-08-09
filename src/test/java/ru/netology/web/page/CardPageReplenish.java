package ru.netology.web.page;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


    public class CardPageReplenish {
        private SelenideElement amountField = $("[data-test-id='amount'] .input__control");
        private SelenideElement cardFrom = $("[data-test-id='from'] .input__control");
        private SelenideElement replenish = $("[data-test-id='action-transfer']");
        private SelenideElement cardPageReplenish = $("[data-test-id='dashboard']");

        public CardPageReplenish() {
            cardPageReplenish.shouldBe(visible);
        }

        public void replenishCardToCard(DataHelper.CardNumber cardNumber, String sum) {
            amountField.setValue(sum);
            cardFrom.setValue(cardNumber.getCardForm());
            replenish.click();
        }
    }