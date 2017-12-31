package exceptions;

/**
 * TypeMismatchedException
 * @author Aaron-Qiu
 *
 */
public class TypeMismatchedException extends SemanticException
{

    public TypeMismatchedException()
    {
        this("Type Mismatched Exception.");
    }

    public TypeMismatchedException(String s)
    {
        super(s);
    }
}