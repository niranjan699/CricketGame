package Cricket;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Team {


    private final String       NAME;
    private       List<Player> players = new ArrayList<Player>( );
    private       int          runScored;

    private int runConceded;
    private int wicketsFallen;
    private int wicketsTaken;


    private int currentBatsmen = -1;


    Team ( String name ) {
        NAME = name;
    }


    public String getNAME ( ) {
        return NAME;
    }


    public List<Player> getPlayers ( ) {
        return players;
    }


    public int getRunScored ( ) {
        return runScored;
    }

    public void addToRunScored ( int runScored ) {
        this.runScored += runScored;
    }

    public int getRunConceded ( ) {
        return runConceded;
    }

    public void addRunConceded ( int runConceded ) {
        this.runConceded += runConceded;
    }

    public int getWicketsFallen ( ) {
        return wicketsFallen;
    }

    public void addToWicketsFallen ( ) {
        this.wicketsFallen += 1;
    }

    public int getWicketsTaken ( ) {
        return wicketsTaken;
    }

    public void addToWicketsTaken ( ) {
        this.wicketsTaken = +1;
    }


    public Player getNextBatter ( ) {
        currentBatsmen++;
        Player nextbatter = players.get( currentBatsmen );
        nextbatter.setDidBat( true );
        return nextbatter;

    }

    public Player getBowler ( ) {
        return players.get( ThreadLocalRandom.current( ).nextInt( 0, players.size( ) ) );

    }


    void addPlayers ( Player player ) {
        if ( players.size( ) < 11 ) {
            players.add( player );
        }
        else {
            System.out.println( "Team is already Full" );

        }

    }


}
