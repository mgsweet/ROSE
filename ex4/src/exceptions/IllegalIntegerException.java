package exceptions;

/**
 * IllegalIntegerException
 * @author Aaron-Qiu
 *
 */
public class IllegalIntegerException extends LexicalException
{

    public IllegalIntegerException()
    {
        this("Illegal Integer.");
    }

    public IllegalIntegerException(String s)
    {
        super(s);
    }
}
