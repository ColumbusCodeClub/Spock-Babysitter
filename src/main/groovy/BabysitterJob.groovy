class BabysitterJob {

    final RATE_BEFORE_BEDTIME = 12
    final RATE_AFTER_BEDTIME = 8

    def endTime

    def BabysitterJob(endTime) {
        this.endTime = endTime
    }


    def getCash(start, end) {


        RATE_BEFORE_BEDTIME * (end - start)
    }
}
