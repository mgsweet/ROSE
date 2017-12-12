package exceptions;

/**
 * IllegalIdentifierLengthException
 * @author Aaron-Qiu
 *
 */
public class IllegalIdentifierLengthException extends LexicalException
{

    public IllegalIdentifierLengthException()
    {
        this("Illegal Identifier Length.");
    }

    public IllegalIdentifierLengthException(String s)
    {
        super(s);
    }
}
