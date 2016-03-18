import spock.lang.Specification
import spock.lang.Unroll

class BabysitterSpec extends Specification {
//    - gets paid $12/hour from start-time to bedtime
//    - gets paid $8/hour from bedtime to midnight
//    - gets paid $16/hour from midnight to end of job

    BabysitterJob job

    @Unroll
    def "babysitter gets paid #expectedCashReceived when starting at #start and finishing at #end before bedtime"() {
        setup:
            job = new BabysitterJob(bedTime: 12)

        expect:
            job.getCash(start, end) == expectedCashReceived

        where:
            start | end || expectedCashReceived
            5     | 6   || 12
            5     | 7   || 24
    }

    def "babysitter gets paid 8 dollas for 1 hour of work after bedtime"() {
        setup:
            job = new BabysitterJob(bedTime: 5)

        expect:
            job.getCash(5, 6) == 8
    }

}
