package Cricket;

public class Player {
    private int careerRuns;
    private int careerWickets;

    private int bowledFaced=0;
    private int numberofBowls=0;


    private int matchRuns = 0;


    private int matchWickets = 0;


    private String gotOutby = new String( "" );

    public Boolean getDidBat ( ) {
        return didBat;
    }

    private Boolean didBat = false;


    private final String   NAME;
    private       Category category;

    private enum Category {
        BATTER, BOWLER, ALLROUNDER;
    }

    ;


    public void setDidBat ( Boolean didBat ) {
        this.didBat = didBat;
    }


    public Player ( String name, String category ) {
        this.NAME     = name;
        this.category = Category.valueOf( category.toUpperCase( ) );

    }


    public int getCareerRuns ( ) {
        return careerRuns;
    }

    public void setCareerRuns ( int careerRuns ) {
        this.careerRuns = careerRuns;
    }

    public int getCareerWickets ( ) {
        return careerWickets;
    }

    public void setCareerWickets ( int careerWickets ) {
        this.careerWickets = careerWickets;
    }

    public int getMatchRuns ( ) {
        return matchRuns;
    }

    public void setMatchRuns ( int matchRuns ) {
        this.matchRuns += matchRuns;
    }

    public int getMatchWickets ( ) {
        return matchWickets;
    }

    public void addToMatchWickets ( ) {
        this.matchWickets += 1;
    }

    public String getNAME ( ) {
        return NAME;
    }

    public String getGotOutby ( ) {
        return gotOutby;
    }

    public void setGotOutby ( String gotOutby ) {
        this.gotOutby = gotOutby;
    }


}
