class BabysitterJob {

    static final RATE_BEFORE_BEDTIME = 12
    static final RATE_AFTER_BEDTIME = 8
    static final RATE_AFTER_MIDNIGHT = 16
    static final MIDNIGHT = 24

    def bedTime

    def BabysitterJob(int bedTime) {
        this.bedTime = bedTime
    }

    def getCash(start, end) {
        def normalizedStart = normalizeTime(start)
        def normalizedEnd = normalizeTime(end)
        RATE_AFTER_BEDTIME * afterBedtime(normalizedStart, normalizedEnd) +
            RATE_BEFORE_BEDTIME * beforeBedtime(normalizedStart, normalizedEnd) +
                RATE_AFTER_MIDNIGHT * afterMidnight(normalizedEnd)
    }

    def beforeBedtime(start, end) {
        if (start < bedTime)
            Math.min(end, bedTime) - start
        else
            0
    }

    def afterBedtime(start, end) {
        if (end > bedTime)
            Math.min(end, MIDNIGHT) - Math.max(start, bedTime)
        else
            0
    }

    def afterMidnight(end) {
        if (end > MIDNIGHT)
            end - MIDNIGHT
        else
            0
    }

    def static normalizeTime(time) {
        if (time >= 0 && time < 12)
            time + MIDNIGHT
        else
            time
    }
}
