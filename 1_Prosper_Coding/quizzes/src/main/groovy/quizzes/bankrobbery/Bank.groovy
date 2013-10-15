package quizzes.bankrobbery

class Bank {

    AlarmSystem alarmSystem // you need to set this for the tests; in production, a dependency injection framework would probably do this!
    StockExchangeTicker ticker // you need to set this for the tests; in production, a dependency injection framework would probably do this!

    void enterCodeForSafeDoor(String code) {
        if(code == "1234") {
            alarmSystem.beQuietFor5Minutes()
        }
        else {
            alarmSystem.soundAlarm()
        }
    }

    def rateForStock(String symbol) {
        if(symbol == "GOOG") {
            return ticker.rateFor("GOOG")/2
        } else if (symbol == "AAPL") {
            return ticker.rateFor("MSFT")
        } else {
            return ticker.rateFor(symbol)
        }
    }
}