package exceptions;

/**
 * MissingLeftParenthesisException
 * @author Aaron-Qiu
 *
 */
public class MissingLeftParenthesisException extends SyntacticException
{

    public MissingLeftParenthesisException()
    {
        this("Missing LeftParenthesis Exception.");
    }

    public MissingLeftParenthesisException(String s)
    {
        super(s);
    }
}