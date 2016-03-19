class BabysitterJob {

    final RATE_BEFORE_BEDTIME = 12
    final RATE_AFTER_BEDTIME = 8
    final RATE_AFTER_MIDNIGHT = 16

    def bedTime

    def BabysitterJob(int bedTime) {
        this.bedTime = bedTime
    }


    def getCash(start, end) {
        RATE_AFTER_BEDTIME * afterBedtime(start, end) +
            RATE_BEFORE_BEDTIME * beforeBedtime(start, end) +
                RATE_AFTER_MIDNIGHT * afterMidnight(start)


    }

    def beforeBedtime(start, end) {
        if (start < bedTime)
            (Math.min(end, bedTime) - start)
        else
            0
    }

    def afterBedtime(start, end) {
        if (end > bedTime && start != 0)
            (end - Math.max(start, bedTime))
        else
            0
    }

    def afterMidnight(start) {
        if (start == 0)
            1
        else
            0
    }
}
