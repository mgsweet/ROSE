package exceptions;

/**
 * IllegalSymbolException
 * @author Aaron-Qiu
 *
 */
public class IllegalSymbolException extends LexicalException
{

    public IllegalSymbolException()
    {
        this("Illegal Symbol.");
    }

    public IllegalSymbolException(String s)
    {
        super(s);
    }
}
