package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {

        private SelenideElement TransferPage = $("[data-test-id='dashboard']");

        private ElementsCollection cards = $$(".list__item");
        private final String balanceStart = "баланс: ";
        private final String balanceEnd = " р.";

        private SelenideElement replenish1 = cards.first().$("[data-test-id=action-deposit]");
        private SelenideElement replenish2 = cards.last().$("[data-test-id=action-deposit]");
        private SelenideElement reload = $("[data-test-id='action-reload']");


        public TransferPage() {
            TransferPage.shouldBe(visible);
        }

        public CardPageReplenish replenish1() {
            replenish1.click();
            return new CardPageReplenish();
        }

        public CardPageReplenish replenish2() {
            replenish2.click();
            return new CardPageReplenish();
        }

        public int getCard1Balance() {
            val text = cards.first().text();
            return extractBalanceCard1(text);
        }

        private int extractBalanceCard1(String text) {
            val start = text.indexOf(balanceStart);
            val end = text.indexOf(balanceEnd);
            val value = text.substring(start + balanceStart.length(), end);
            return Integer.parseInt(value);
        }

        public int getCard2Balance() {
            val text = cards.last().text();
            return extractBalanceCard2(text);
        }

        private int extractBalanceCard2(String text) {
            val start = text.indexOf(balanceStart);
            val end = text.indexOf(balanceEnd);
            val value = text.substring(start + balanceStart.length(), end);
            return Integer.parseInt(value);
        }
    }




