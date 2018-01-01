package exceptions;


/**
 * MismatchedCommentException
 * @author Aaron-Qiu
 *
 */
public class MismatchedCommentException extends LexicalException
{

    public MismatchedCommentException()
    {
        this("Mismatched Comment.");
    }

    public MismatchedCommentException(String s)
    {
        super(s);
    }
}
