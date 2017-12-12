package exceptions;

/**
 * MissingRightParenthesisException
 * @author Aaron-Qiu
 *
 */
public class MissingRightParenthesisException extends SyntacticException
{

    public MissingRightParenthesisException()
    {
        this("Missing Right Parenthesis Exception.");
    }

    public MissingRightParenthesisException(String s)
    {
        super(s);
    }
}