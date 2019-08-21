package Cricket;

import java.util.concurrent.ThreadLocalRandom;

class Over {
    final static String[] bowlResults = {"0", "1", "2", "3", "4", "5", "6", "W"};


    private Player strker;
    private Player nonStriker;
    private Player bowler;
    private int    legalDelivaries;


    public Over ( Player strker, Player nonStriker, Player bowler, int legalDelivaries ) {
        this.strker          = strker;
        this.nonStriker      = nonStriker;
        this.bowler          = bowler;
        this.legalDelivaries = legalDelivaries;
    }


    public Over ( int legalDelivaries ) {
        this.legalDelivaries = legalDelivaries;
    }


    public void setStrker ( Player strker ) {
        this.strker = strker;
    }

    public void setNonStriker ( Player nonStriker ) {
        this.nonStriker = nonStriker;
    }

    public void onWicketFallen ( Innings inning ) {
        System.out.println( this.bowler.getNAME( ) + " has taken Wicket of " + this.strker.getNAME( ) );
        inning.getBattingSide( ).addToWicketsFallen( );

        this.strker.setGotOutby( this.bowler.getNAME( ) );
        this.bowler.addToMatchWickets( );


        updateScore( inning.getBattingSide( ).getRunScored( ), inning.getBattingSide( ).getWicketsFallen( ) );


        if ( inning.getBattingSide( ).getWicketsFallen( ) >= 10 ) {


            inning.setInningsstatus( "FINISHED" );
            if ( inning.getTargetScore( ) >= 0 ) {

                System.out.println( "Chasing Team Lost" );
            }

            else {

                System.out.println( "Innings Over" );
            }
        }

        else {

            this.setStrker( inning.getBattingSide( ).getNextBatter( ) );
        }


    }

    public void changeBowler ( Innings inning ) {
        this.bowler = inning.getFieldingSide( ).getBowler( );


    }

    public void changeStrike ( ) {
        Player temp = this.nonStriker;
        this.nonStriker = this.strker;
        this.strker     = temp;
    }


    public void OnRunScored ( Innings inning, int runs ) {

        inning.getBattingSide( ).addToRunScored( runs );
        this.strker.setMatchRuns( runs );
        System.out.println( this.strker.getNAME( ) + " Scored " + runs );
        updateScore( inning.getBattingSide( ).getRunScored( ), inning.getBattingSide( ).getWicketsFallen( ) );

        if ( inning.getTargetScore( ) >= 0 ) {


            if ( inning.getBattingSide( ).getRunScored( ) > inning.getTargetScore( ) ) {
                System.out.println( "Chasing team Won" );
                inning.setInningsstatus( "FINISHED" );
            }
        }


    }

    void updateScore ( int runs, int wickets ) {


        System.out.println( String.format( "Score After this bowl is   with    %1$-5s  wickets ", wickets ) );

    }

    String getBowlResult ( ) {

        return bowlResults[ThreadLocalRandom.current( ).nextInt( 0, bowlResults.length )];


    }


    void simlulateOver ( Innings inning ) {
        boolean Isovercompleted = false;
        int deliveryCount = 0;
        StringBuilder overData = new StringBuilder( );
        String bowlResult;
        while (!Isovercompleted && inning.getStatus( ) != "FINISHED") {

            bowlResult = getBowlResult( );
            overData.append( bowlResult );

            switch (bowlResult) {

                case "1":

                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    Integer runs = Integer.parseInt( bowlResult );
                    OnRunScored( inning, runs );


                    break;
                case "W":
                    onWicketFallen( inning );

                    break;
                case "0":
                    System.out.println( "Dot ball" );
                    updateScore( inning.getBattingSide( ).getRunScored( ), inning.getBattingSide( ).getWicketsFallen( ) );
                    break;
            }


            deliveryCount++;


            if ( deliveryCount >= this.legalDelivaries ) {

                inning.addToOversData( overData.toString( ) );
                Isovercompleted = true;
            }


        }


    }


}
