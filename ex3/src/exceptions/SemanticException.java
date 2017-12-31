package exceptions;

/**
 * SemanticException
 * @author Aaron-Qiu
 *
 */
public class SemanticException extends OberonException
{

    public SemanticException()
    {
        this("Semantic Exception.");
    }

    public SemanticException(String s)
    {
        super("Semantic Exception: " + s);
    }
}
