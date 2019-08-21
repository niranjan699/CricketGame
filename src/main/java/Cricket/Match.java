package Cricket;

public class Match {
    private int MatchNumber;


    private final MatchType matchType;


    private final Team battingTeam;
    private final Team fieldingTeam;


    private Innings firstInnings;
    private Innings secondInnings;


    private int targetScore;

    public enum MatchType {
        ODI( 50 ), T20( 20 ), T10( 10 );


        private final int numberOfOvers;


        MatchType ( int numberOfOvers ) {

            this.numberOfOvers = numberOfOvers;
        }


    }


    public Match ( MatchType matchType, Team battingTeam, Team fieldingTeam ) {
        this.matchType    = matchType;
        this.battingTeam  = battingTeam;
        this.fieldingTeam = fieldingTeam;
    }


    public Innings getFirstInnings ( ) {
        return firstInnings;
    }

    public Innings getSecondInnings ( ) {
        return secondInnings;
    }

    public int getMatchNumber ( ) {
        return MatchNumber;
    }

    public MatchType getMatchType ( ) {
        return matchType;
    }

    public Team getBattingTeam ( ) {
        return battingTeam;
    }

    public Team getFieldingTeam ( ) {
        return fieldingTeam;
    }


    public void runFirstInning ( ) {
        firstInnings = new Innings( matchType.numberOfOvers, battingTeam, fieldingTeam, -1 );
        firstInnings.play( );


    }

    public void runSecondInnings ( ) {

        secondInnings = new Innings( matchType.numberOfOvers, fieldingTeam, battingTeam, this.targetScore );
        secondInnings.play( );


    }


    public int getTargetScore ( ) {
        return targetScore;
    }

    public void setTargetScore ( ) {
        this.targetScore = this.getFirstInnings( ).getBattingSide( ).getRunScored( );
    }


}
