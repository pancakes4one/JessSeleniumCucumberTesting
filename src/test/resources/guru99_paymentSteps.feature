Feature: Guru99


  Background:
    Given The user wants to see payment gateway website

  @Guru99_Payment_Steps
#  http://demo.guru99.com/payment-gateway/index.php
  Scenario: User wants to buy toy on Guru99
    When The user wants buy Elephant toy
    Then The user wants to enter payment information as
    |CNumber | 1212121212121212 |
    |EMonth  |    09            |
    |EYear   |   2026           |
    |CVVCode |    123           |
    Then The user wants to pay now
    And The user wants to verify message as "Payment successfull!"
