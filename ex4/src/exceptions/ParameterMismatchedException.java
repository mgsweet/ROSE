package exceptions;

/**
 * ParameterMismatchedException
 * @author Aaron-Qiu
 *
 */
public class ParameterMismatchedException extends SemanticException
{

    public ParameterMismatchedException()
    {
        this("Parameter Mismatched Exception.");
    }

    public ParameterMismatchedException(String s)
    {
        super(s);
    }
}