package exceptions;

/**
 * IllegalOctalException
 * @author Aaron-Qiu
 *
 */
public class IllegalOctalException extends LexicalException
{

    public IllegalOctalException()
    {
        this("Illegal Octal number.");
    }

    public IllegalOctalException(String s)
    {
        super(s);
    }
}
