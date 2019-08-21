package Cricket;

public class MatchController {


    private String TeamOneName;

    private String          TeamTwoName;
    private Match           match;
    private Match.MatchType matchType;


    private Team TeamOne;
    private Team TeamTwo;


    private void createTeam ( ) {
        System.out.println( "Creating Teams " );
        this.TeamOne = new Team( this.TeamOneName );
        this.TeamTwo = new Team( this.TeamTwoName );

    }

    private void addPlayers ( Team t ) {

        System.out.println( " Adding Players " );
        t.addPlayers( new Player( t.getNAME( ) + " P1", "BATTER" ) );
        t.addPlayers( new Player( t.getNAME( ) + " P2", "BATTER" ) );
        t.addPlayers( new Player( t.getNAME( ) + " P3", "BATTER" ) );
        t.addPlayers( new Player( t.getNAME( ) + " P4", "BATTER" ) );
        t.addPlayers( new Player( t.getNAME( ) + " P5", "BATTER" ) );
        t.addPlayers( new Player( t.getNAME( ) + " P6", "ALLROUNDER" ) );
        t.addPlayers( new Player( t.getNAME( ) + " P7", "ALLROUNDER" ) );
        t.addPlayers( new Player( t.getNAME( ) + " P8", "BOWLER" ) );
        t.addPlayers( new Player( t.getNAME( ) + " P9", "BOWLER" ) );
        t.addPlayers( new Player( t.getNAME( ) + " P10", "BOWLER" ) );
        t.addPlayers( new Player( t.getNAME( ) + " P11", "BOWLER" ) );

        System.out.println( "Added 11 Players to " + t.getNAME( ) );


    }

    private void startMatch ( ) {
        this.createTeam( );
        this.addPlayers( this.TeamOne );
        this.addPlayers( this.TeamTwo );
        match = new Match( this.matchType, this.TeamOne, this.TeamTwo );


    }


    public void runMatch ( ) {

        this.startMatch( );
        match.runFirstInning( );
        match.setTargetScore( );
        match.runSecondInnings( );


    }

    public MatchController ( String teamOneName, String teamTwoName, Match.MatchType matchType ) {
        TeamOneName    = teamOneName;
        TeamTwoName    = teamTwoName;
        this.matchType = matchType;
    }


}
