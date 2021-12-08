import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Model class.
 *
 * @author Sanjay Janardhan
 */
public final class NNCalcModel1 implements NNCalcModel {

    /**
     * Model variables.
     */
    private final NaturalNumber topNum, bottomNum;

    /**
     * Default constructor.
     */
    public NNCalcModel1() {
        this.topNum = new NaturalNumber2();
        this.bottomNum = new NaturalNumber2();
    }

    @Override
    public NaturalNumber top() {
        return this.topNum;
    }

    @Override
    public NaturalNumber bottom() {
        return this.bottomNum;
    }

}
