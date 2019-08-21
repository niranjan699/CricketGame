package Cricket;

public class CricketMain {


    private Team t1;
    private Team t2;


    public static void main ( String[] args ) {

        MatchController matchController = new MatchController( "AUSTRALIA", "INDIA", Match.MatchType.T10 );
        matchController.runMatch( );

    }


}
