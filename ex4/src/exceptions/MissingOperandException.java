package exceptions;

/**
 * MissingOperandException
 * @author Aaron-Qiu
 *
 */
public class MissingOperandException extends SyntacticException
{

    public MissingOperandException()
    {
        this("Missing Operand Exception.");
    }

    public MissingOperandException(String s)
    {
        super(s);
    }
}