package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {


  @Test
  void shouldTransferMoneyBag() {
    String sum = "30000";
    val loginPage = open("http://localhost:9999", LoginPage.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val transferPage = verificationPage.validVerify(verificationCode);
    int balanceCard1 = transferPage.getCard1Balance();
    int balanceCard2 = transferPage.getCard2Balance();
    val cardPageReplenish = transferPage.replenish1();
    val infoCard = DataHelper.getCardNumber2();
    cardPageReplenish.replenishCardToCard(infoCard, sum);
    assertEquals(balanceCard1 + Integer.parseInt(sum), transferPage.getCard1Balance());
    assertEquals(balanceCard2 - Integer.parseInt(sum), transferPage.getCard2Balance());
  }

  @Test
  void shouldTransferMoney() {
    String sum = "10000";
    val loginPage = open("http://localhost:9999", LoginPage.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val transferPage = verificationPage.validVerify(verificationCode);
    int balanceCard1 = transferPage.getCard1Balance();
    int balanceCard2 = transferPage.getCard2Balance();
    val cardPageReplenish = transferPage.replenish1();
    val infoCard = DataHelper.getCardNumber2();
    cardPageReplenish.replenishCardToCard(infoCard, sum);
    assertEquals(balanceCard1 + Integer.parseInt(sum), transferPage.getCard1Balance());
    assertEquals(balanceCard2 - Integer.parseInt(sum), transferPage.getCard2Balance());
  }




}