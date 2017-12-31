package exceptions;

/**
 * SyntacticException
 * @author Aaron-Qiu
 *
 */
public class SyntacticException extends OberonException
{

    public SyntacticException()
    {
        this("Syntactic Exception.");
    }

    public SyntacticException(String s)
    {
        super("Syntactic Exception: " + s);
    }
}
