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
            job = new BabysitterJob(23)

        expect:
            job.getCash(start, end) == expectedCashReceived

        where:
            start | end || expectedCashReceived
            17    | 18  || 12
            17    | 19  || 24
    }

    def "babysitter gets paid 8 dollas for 1 hour of work after bedtime"() {
        setup:
            job = new BabysitterJob(17)

        expect:
            job.getCash(17, 18) == 8
    }

    def "babysitter gets paid for one hour before bedtime and one hour after bedtime"() {
        setup:
            job = new BabysitterJob(17)

        expect:
            job.getCash(16, 18) == 20
    }

    def "babysitter gets paid for one hour after midnight"() {
        setup:
        job = new BabysitterJob(0)

        expect:
        job.getCash(0, 1) == 16
    }

}
