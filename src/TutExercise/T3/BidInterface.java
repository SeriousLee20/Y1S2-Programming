package TutExercise.T3;

/**An interface that represents a bid for installing an air conditioning unit*/
public interface BidInterface {

    /**Get the company's name, which makes the bid
     * @return String that states company's name*/
    String companyName();

    /**Get the description of the air conditioner that the bid is for
     * @return a String that shows the description*/
    String bidDescription();

    /**Get the capacity of the bid's AC in tons (1 ton = 12,000 BTU)
     * @return double value that shows the capacity*/
    double AC_Capacity();

    /**Get the seasonal efficiency of the bid's AC
     * @return a double value that shows the seasonal efficiency*/
    double seasonalEfficiency();

    /**Get the cost of bid's AC
     * @return a double value of cost for bid's AC*/
    double AC_Cost();

    /**Get the installation cost of the AC
     * @return double value of the installation cost*/
    double installationCost();

    /**Get the yearly operating cost of the AC
     * @return double value of yearly operating cost*/
    double operationYearCost();

}// end of BidInterface
