package quizzes.bankrobbery

import spock.lang.Specification

class BankSpec extends Specification{
    AlarmSystem alarmSystem = Mock()
    StockExchangeTicker stockExchangeTicker = Mock()
    Bank bank = new Bank()

    def setup() {
        bank.ticker = stockExchangeTicker
    }

    def "sounds alarm if safe code is entered incorrectly"() {
        expect: false
    }

    def "sets alarm to quiet and does *not* sound it if safe door code is entered correctly"() {
        expect: false
    }

    def "returns stock quote for MSFT truthfully"() { // think twice what you need to check here!
        expect: false
    }

    def "returns stock quote for MSFT when asked for AAPL"() {
        expect: false
    }

    def "returns half the actual value when asked for GOOG stocks"() {
        given:
        stockExchangeTicker.rateFor("GOOG") >> 10

        expect:
        bank.rateForStock("GOOG") == 5
    }
}
