package Cricket;

import java.util.ArrayList;
import java.util.List;

class Innings {

    private int oversPerInnings;


    private List<String> oversData = new ArrayList<String>( );


    private int oversCompleted = 0;


    private int targetScore = -1;


    private Team battingSide;
    private Team fieldingSide;

    private enum INNINGS_STATUS {
        STARTED, FINISHED,

    }

    ;

    public void setInningsstatus ( String inningsstatus ) {
        this.inningsstatus = INNINGS_STATUS.valueOf( inningsstatus );
    }

    private INNINGS_STATUS inningsstatus;


    public Innings ( int oversPerInnings, Team battingSide, Team fieldingSide, int targetScore ) {
        this.oversPerInnings = oversPerInnings;
        this.battingSide     = battingSide;
        this.fieldingSide    = fieldingSide;
        this.inningsstatus   = INNINGS_STATUS.STARTED;
        this.targetScore     = targetScore;
    }

    public void changeInningsStatus ( String inningsStatus ) {
        this.inningsstatus = INNINGS_STATUS.valueOf( inningsStatus );


    }

    public void addToOversData ( String oversData ) {
        this.oversData.add( oversData );
    }


    public String getStatus ( ) {
        return inningsstatus.toString( );


    }

    public int getOversPerInnings ( ) {
        return oversPerInnings;
    }


    public int getOversCompleted ( ) {
        return oversCompleted;
    }

    public void incrementOversCompleted ( ) {
        this.oversCompleted = this.oversCompleted + 1;
    }

    public Team getBattingSide ( ) {
        return battingSide;
    }

    public Team getFieldingSide ( ) {
        return fieldingSide;
    }

    public int getTargetScore ( ) {
        return targetScore;
    }

    public void setTargetScore ( int targetScore ) {
        this.targetScore = targetScore;
    }

    public void play ( ) {
        Player striker = this.getBattingSide( ).getNextBatter( );
        Player nonStriker = this.getBattingSide( ).getNextBatter( );
        Over overRunner = new Over( 6 );
        overRunner.setStrker( striker );
        overRunner.setNonStriker( nonStriker );
        overRunner.changeBowler( this );

        for (int overNumber = 1; overNumber < this.getOversPerInnings( ) && this.getStatus( ) != "FINISHED"; overNumber++) {

            System.out.println( "Simulating Over Number " + overNumber );
            overRunner.simlulateOver( this );
            overRunner.changeStrike( );
            overRunner.changeBowler( this );
            this.printScores( );


        }
        this.setInningsstatus( "FINISHED" );
        this.setTargetScore( this.getBattingSide( ).getRunScored( ) );


    }


    public void printScores ( ) {
        System.out.println( "\n" );


        for (Player player : this.getBattingSide( ).getPlayers( )) {


            if ( player.getDidBat( ) ) {
                if ( !(player.getGotOutby( ).equals( new String( "" ) )) ) {
                    System.out.println( String.format( " %1$-20s  Scored   %2$-5s   got out By   %3$-20s   ", player.getNAME( ), player.getMatchRuns( ), player.getGotOutby( ) ) );
                }
                else {
                    System.out.println( String.format( " %1$-20s  Scored  %2$-5s    Not  Out   ", player.getNAME( ), player.getMatchRuns( ) ) );

                }

            }
            else {
                System.out.println( player.getNAME( ) + " Did Not Bat " );
            }

        }

        System.out.println( this.getBattingSide( ).getNAME( ) + "  Scored " + this.getBattingSide( ).getRunScored( ) + " with " + this.getBattingSide( ).getWicketsFallen( ) + " Wickets " );


    }

}
