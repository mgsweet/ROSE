package exceptions;

/**
 * IllegalIntegerRangeException
 * @author Aaron-Qiu
 *
 */
public class IllegalIntegerRangeException extends LexicalException
{

    public IllegalIntegerRangeException()
    {
        this("Illegal IntegerRange.");
    }

    public IllegalIntegerRangeException(String s)
    {
        super(s);
    }
}
