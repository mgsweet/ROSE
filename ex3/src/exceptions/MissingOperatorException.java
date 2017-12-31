package exceptions;

/**
 * MissingOperatorException
 * @author Aaron-Qiu
 *
 */
public class MissingOperatorException extends SyntacticException
{

    public MissingOperatorException()
    {
        this("Missing Operator Exception.");
    }

    public MissingOperatorException(String s)
    {
        super(s);
    }
}