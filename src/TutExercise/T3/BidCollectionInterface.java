package TutExercise.T3;

/**An interface that describes operations for collection
 * of air conditioner bids for a company*/

public interface BidCollectionInterface {

    /**Search for the bid based on unit cost of AC
     * @return the bid that matches the unit cost of AC*/
    BidInterface searchBidOnUnitCost(double cost);

    /**Search for the bid based on AC's capacity
     * @return the bid that matches the AC's capacity*/
    BidInterface searchBidOnCapacity(double capacity);

    /**Search for the bid based on seasonal efficiency of AC
     * @return the bid that matches the seasonal efficiency of AC*/
    BidInterface searchBidOnSeasonalEfficiency(double efficiency);

    /**Search for the bid based on installation cost of AC
     * @return the bid that matches the installation cost of AC*/
    BidInterface searchBidOnInstallationCost(double cost);

    /**Search for the bid based on operating cost of AC
     * @return the bid that matches the operating cost of AC*/
    BidInterface searchBidOnOperatingCost(double cost);

    /**Add a bid to the collection*/
    void addBid(BidInterface bidInterface);

    /**Get the bid with the best yearly cost
     * @return the bid with the best yearly cost*/
    BidInterface bestYearlyCost();

    /**Get the bid with the best initial cost
     * Initial cost = unit cost + installation cost
     * @return the bid with the best initial cost*/
    BidInterface bestInitialCost();

    /**Clear the collection*/
    void clearCollection();

    /**Get the number of bids in the collection
     * @return integer value of number of bids in the collection*/
    int numOfBids();

    /**Check if the collection is empty
     * @return true if the collection is empty, else false*/
    boolean isEmpty();

}// end of BidCollectionInterface
